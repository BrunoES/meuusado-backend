package com.meuusado.application.ports;

import java.util.concurrent.ExecutionException;

public interface MessagingServicePort<T> {

	void send(String queue, String messageId, T objectMessage) throws InterruptedException, ExecutionException;
	
}