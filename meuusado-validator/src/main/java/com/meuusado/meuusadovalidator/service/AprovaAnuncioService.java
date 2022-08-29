package com.meuusado.meuusadovalidator.service;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import com.meuusado.meuusadovalidator.dto.AnuncioDTO;
import com.meuusado.meuusadovalidator.persistence.MongoDBAnuncioRepository;

@Service
public class AprovaAnuncioService {
	
	private MongoDBAnuncioRepository mongoDBAnuncioRepository = new MongoDBAnuncioRepository();
	
	public static void consume() throws IOException {
		AprovaAnuncioService aprovaAnuncioService = new AprovaAnuncioService();
		try(KafkaService<AnuncioDTO> service = new KafkaService(AprovaAnuncioService.class.getSimpleName(),
				Pattern.compile("MEUUSADO.*"),
				aprovaAnuncioService::parse,
				AnuncioDTO.class,
				Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
				)){
			service.run();
		}
	}
	
	private void parse(ConsumerRecord<String, AnuncioDTO> record) {
		System.out.println("Aprovando anúncio " + record.topic());
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());
		
		//Object obj = record.value();
		//System.out.println(obj.getClass().getCanonicalName());
		
		//AnuncioDTO anuncioDto = new AnuncioDTO(null, record.value().getIdAnuncio(), record.value().getIdUsuario(), record.value().getIdModelo(), record.value().getNomeModelo(), record.value().getTitulo(), record.value().getDescricao(), record.value().getAno(), record.value().getValor(), record.value().getDataCriacao(), record.value().getBase64Imagem(), record.value().getListAnuncioFotosBase64());
		
		mongoDBAnuncioRepository.salvar(record.value());
	}
}