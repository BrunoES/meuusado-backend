package com.meuusado.meuusadovalidator.persistence.codecs;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import com.meuusado.meuusadovalidator.dto.AnuncioDTO;

public class AnuncioCodec implements CollectibleCodec<AnuncioDTO> {

	private Codec<Document> codec;
	
	public AnuncioCodec(Codec<Document> codec) {
		this.codec = codec;
	}

	@Override
	public void encode(BsonWriter writer, AnuncioDTO anuncioDto, EncoderContext encoder) {
		ObjectId id = anuncioDto.getId();
		String titulo = anuncioDto.getTitulo();
		String descricao = anuncioDto.getDescricao();
		
		Document document = new Document();
		
		document.put("_id", id);
		document.put("descricao", descricao);
		document.put("titulo", titulo);
		
		codec.encode(writer, document, encoder);
		
	}

	@Override
	public Class<AnuncioDTO> getEncoderClass() {
		return AnuncioDTO.class;
	}

	@Override
	public AnuncioDTO decode(BsonReader reader, DecoderContext decoder) {
		Document document = codec.decode(reader, decoder);
		
		AnuncioDTO anuncioDto = new AnuncioDTO();
		
		anuncioDto.setId(document.getObjectId("_id"));
		anuncioDto.setTitulo(document.getString("titulo"));
		anuncioDto.setDescricao(document.getString("descricao"));
		
		return anuncioDto;
	}

	@Override
	public boolean documentHasId(AnuncioDTO anuncioDto) {
		return anuncioDto.getId() == null;
	}

	@Override
	public AnuncioDTO generateIdIfAbsentFromDocument(AnuncioDTO anuncioDto) {
		return documentHasId(anuncioDto) ? anuncioDto.criarId() : anuncioDto;
	}

	@Override
	public BsonValue getDocumentId(AnuncioDTO anuncioDto) {
		if (!documentHasId(anuncioDto)) {
			throw new IllegalStateException("Esse Document nao tem id");
		}
		
		return new BsonString(anuncioDto.getId().toHexString());
	}
	
}
