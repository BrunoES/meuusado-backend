package com.meuusado.application.services;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.meuusado.adapters.outbound.messaging.NewMessageCallBack;
import com.meuusado.adapters.outbound.messaging.serialization.GsonSerializer;
import com.meuusado.application.ports.MessagingServicePort;

public class MessagingServiceImpl<T> implements MessagingServicePort<T>, Closeable {

	private String kafkaAddress;
	
	private final KafkaProducer<String, T> producer;
	
	public MessagingServiceImpl(String kafkaAddress) {
		this.kafkaAddress = kafkaAddress;
		this.producer = new KafkaProducer<String, T>(properties()); 
	}

	public Properties properties() {
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
				
		return properties;
	}
	
	@Override
	public void send(String queue, String messageId, T objectMessage) throws InterruptedException, ExecutionException {
		ProducerRecord<String, T> record = new ProducerRecord<String, T>(queue, messageId, objectMessage);
		producer.send(record, new NewMessageCallBack()).get();
	}
	
	@Override
	public void close() throws IOException {
		producer.close();
	}

}