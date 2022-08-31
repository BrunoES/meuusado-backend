package com.meuusado.adapters.outbound.messaging;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.meuusado.adapters.outbound.messaging.serialization.GsonSerializer;

public class KafkaDispatcher<T> implements Closeable {
	
	private final KafkaProducer<String, T> producer;
	
	public KafkaDispatcher() {
		this.producer = new KafkaProducer<String, T>(properties()); 
	}

	public static Properties properties() {
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "host.docker.internal:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
				
		return properties;
	}
	
	
	public void send(String topic, String key, T value) throws InterruptedException, ExecutionException {
		ProducerRecord record = new ProducerRecord<String, T>(topic, key, value);
		producer.send(record, new NewMessageCallBack()).get();
	}

	@Override
	public void close() throws IOException {
		producer.close();
	}
}