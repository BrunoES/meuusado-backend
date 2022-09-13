package com.meuusado.meuusadovalidator.persistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.meuusado.meuusadovalidator.dto.AnuncioDTO;
import com.meuusado.meuusadovalidator.persistence.codecs.AnuncioCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Component
public class MongoDBAnuncioRepository {

	@Value("${mongo-db.address:localhost:27017}")
	private String mongoAdress;
	
	private MongoClient cliente;
	private MongoDatabase bancaDeDados;

	private void criarConexao() {
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		
		AnuncioCodec anuncioDtoCodec = new AnuncioCodec(codec);
		
		CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromCodecs(anuncioDtoCodec));
		
		MongoClientOptions opcoes = MongoClientOptions.builder().codecRegistry(registro).build();

		try {
			this.cliente = new MongoClient(mongoAdress, opcoes);
			this.bancaDeDados = cliente.getDatabase("test");
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void salvar(AnuncioDTO anuncioDto) {
		
		criarConexao();
		MongoCollection<AnuncioDTO> anuncioDtos = this.bancaDeDados.getCollection("anuncioDtos", AnuncioDTO.class);
		if (anuncioDto.getId() == null) {
			anuncioDtos.insertOne(anuncioDto);
		}else{
			anuncioDtos.updateOne(Filters.eq("_id", anuncioDto.getId()), new Document("$set", anuncioDto));
		}
		
		fecharConexao();
	}

	
	
	public List<AnuncioDTO> obterTodosAnuncioDTOs(){
		criarConexao();
		MongoCollection<AnuncioDTO> anuncioDtos = this.bancaDeDados.getCollection("anuncioDtos", AnuncioDTO.class);
		
		MongoCursor<AnuncioDTO> resultados = anuncioDtos.find().iterator();
		
		List<AnuncioDTO> anuncioDtosEncontrados = popularAnuncioDTOs(resultados);
		fecharConexao();
		
		return anuncioDtosEncontrados;
		
	}
	
	public AnuncioDTO obterAnuncioDTOPor(String id){
		criarConexao();
		MongoCollection<AnuncioDTO> anuncioDtos = this.bancaDeDados.getCollection("anuncioDtos", AnuncioDTO.class);
		AnuncioDTO anuncioDto = anuncioDtos.find(Filters.eq("_id", new ObjectId(id))).first();
		
		return anuncioDto;
		
	}

	public List<AnuncioDTO> pesquisarPor(String nome) {
		criarConexao();
		MongoCollection<AnuncioDTO> anuncioDtoCollection = this.bancaDeDados.getCollection("anuncioDtos" , AnuncioDTO.class);
		MongoCursor<AnuncioDTO> resultados = anuncioDtoCollection.find(Filters.eq("nome", nome), AnuncioDTO.class).iterator();
		List<AnuncioDTO> anuncioDtos = popularAnuncioDTOs(resultados);
		
		fecharConexao();
		
		return anuncioDtos;
	}

	private void fecharConexao() {
		this.cliente.close();
	}
	
	private List<AnuncioDTO> popularAnuncioDTOs(MongoCursor<AnuncioDTO> resultados){
		List<AnuncioDTO> anuncioDtos = new ArrayList<>();
		while(resultados.hasNext()){
			anuncioDtos.add(resultados.next());
		}
		return anuncioDtos;
	}

	public List<AnuncioDTO> pesquisarPor(String classificacao, double nota) {
		criarConexao();
		
		MongoCollection<AnuncioDTO> anuncioDtoCollection = this.bancaDeDados.getCollection("anuncioDtos", AnuncioDTO.class);
		
		MongoCursor<AnuncioDTO> resultados = null;
		
		if (classificacao.equals("reprovados")) {
			resultados = anuncioDtoCollection.find(Filters.lt("notas", nota)).iterator();
		}else if(classificacao.equals("aprovados")){
			resultados = anuncioDtoCollection.find(Filters.gte("notas", nota)).iterator();
		}
		
		List<AnuncioDTO> anuncioDtos = popularAnuncioDTOs(resultados);
		
		fecharConexao();
		
		return anuncioDtos;
		
	}

	/*
	public List<AnuncioDTO> pesquisaPorGeolocalizacao(AnuncioDTO anuncioDto) {
		criarConexao();
		MongoCollection<AnuncioDTO> anuncioDtoCollection = this.bancaDeDados.getCollection("anuncioDtos", AnuncioDTO.class);
		
		anuncioDtoCollection.createIndex(Indexes.geo2dsphere("contato"));
		
		List<Double> coordinates = anuncioDto.getContato().getCoordinates();
		Point pontoReferencia = new Point(new Position(coordinates.get(0), coordinates.get(1)));
		
		MongoCursor<AnuncioDTO> resultados = anuncioDtoCollection.find(Filters.nearSphere("contato", pontoReferencia, 2000.0, 0.0)).limit(2).skip(1).iterator();
		
		List<AnuncioDTO> anuncioDtos = popularAnuncioDTOs(resultados);
		
		fecharConexao();
		return anuncioDtos;
	}
	*/
	
}
