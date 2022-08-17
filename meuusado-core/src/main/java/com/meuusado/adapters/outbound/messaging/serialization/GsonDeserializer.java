package com.meuusado.adapters.outbound.messaging.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDeserializer<T> implements Deserializer<T> {
	
	static final String TYPE_CONFIG = "com.estudos.kafka";
	private final Gson gson = new GsonBuilder().create();
	private Class<T> type;
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		String classType = String.valueOf(configs.get(TYPE_CONFIG));

		try {
			this.type = (Class<T>) Class.forName(classType);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public T deserialize(String topic, byte[] data) {
		return gson.fromJson(new String(data), type);
	}

}
