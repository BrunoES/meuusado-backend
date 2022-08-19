package com.meuusado.meuusadovalidator.service;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.meuusado.meuusadovalidator.dto.AnuncioDTO;

@Service
public class AprovaAnuncioService {
	
	public static void consume() throws IOException {
		AprovaAnuncioService aprovaAnuncioService = new AprovaAnuncioService();
		try(KafkaService<AnuncioDTO> service = new KafkaService(AprovaAnuncioService.class.getSimpleName(),
				Pattern.compile("MEUUSADO.*"),
				aprovaAnuncioService::parse,
				String.class,
				Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
				)){
			service.run();
		}
	}
	
	private void parse(ConsumerRecord<String, AnuncioDTO> record) {
		System.out.println("LOG] Toppic " + record.topic());
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());
	}
}
