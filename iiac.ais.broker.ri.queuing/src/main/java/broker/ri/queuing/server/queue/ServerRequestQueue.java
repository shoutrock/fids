/*******************************************************************************
 * Copyright(c) 2015-2020 Incheon International Airport Corporation.
 * All rights reserved. This software is the proprietary information of
 * Incheon International Airport Corporation.
 *******************************************************************************/
package broker.ri.queuing.server.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerRequestQueue {
	//
	private static final int queueCapacity = 1000; 
	private static final Logger logger = LoggerFactory.getLogger(ServerRequestQueue.class);
	
	private ArrayBlockingQueue<String> requestQueue; 
	
	public ServerRequestQueue() {
		// 
		this.requestQueue = new ArrayBlockingQueue<String>(queueCapacity);
	}
	
	public ServerRequestQueue(int capacity) {
		// 
		this.requestQueue = new ArrayBlockingQueue<String>(capacity);
	}
	
	public int size() {
		// 
		return requestQueue.size(); 
	}
	
	public int capacity() {
		// 
		return queueCapacity; 
	}
	
	public int remainingCapacity() {
		//
		return requestQueue.remainingCapacity(); 
	}
	
	public void putRequest(String requestMessage) {
		// 
		if (requestQueue.remainingCapacity() == 0) {
			// TODO 예외발생 
			logger.error("ServerRequestQueue is full.");
		}
		
		try {
			requestQueue.put(requestMessage);
			logger.debug(String.format("Control is arrived:%s", requestMessage.toString()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 	
	public String takeRequest() {
		// 
		String request = null; 
		
		try {
			request = requestQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		return request; 
	}
	
	public String pollRequest(long timeout) {
		// 
		String request = null; 
		
		try {
			request = requestQueue.poll(timeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		return request; 
	}
}