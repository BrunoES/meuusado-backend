package com.meuusado.meuusadovalidator.service;

import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.meuusadovalidator.dto.AnuncioDTO;
import com.meuusado.meuusadovalidator.persistence.MongoDBAnuncioRepository;

@Service
public class AprovaAnuncioService {
	
	@Autowired
	private KafkaService<AnuncioDTO> kafkaService;
	
	@Autowired
	private MongoDBAnuncioRepository mongoDBAnuncioRepository;
	
	public void consume() {
		try {
			kafkaService.configure(AprovaAnuncioService.class.getSimpleName(),
					Pattern.compile("MEUUSADO.*"),
					this::parse,
					AnuncioDTO.class,
					Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()));
			kafkaService.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void parse(ConsumerRecord<String, AnuncioDTO> record) {
		System.out.println("Aprovando anúncio " + record.topic());
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());
		
		mongoDBAnuncioRepository.salvar(record.value());
	}
}