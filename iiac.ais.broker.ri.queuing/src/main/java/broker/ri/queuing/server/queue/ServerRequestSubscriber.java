package broker.ri.queuing.server.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.queuing.server.Server;

public class ServerRequestSubscriber extends Thread {
	//
	private static final Logger logger = LoggerFactory.getLogger(ServerRequestSubscriber.class);
	
	private ServerRequestQueue requestQueue; 
	
	public ServerRequestSubscriber(ServerRequestQueue requestQueue) {
		// 
		super("ServerRequestSubscriber"); 
		this.requestQueue = requestQueue;
	} 
	
	public void run() {
		// 
		logger.debug("ServerRequestSubscriber is ready...."); 
		
		while(true) {
			//
			String requestMessage = requestQueue.pollRequest(1000);	// milli seconds 
			
			if (requestMessage != null) {
				logger.debug("## Wow I got you: " + requestMessage); 
				
				Server.getInstance().getDispatcher().dispatch(requestMessage);
				logger.debug("I sent message to dispatcher."); 
			}
			
			if (hasSleepInterrupt()) {
				logger.debug("Catch a interrupt signal, so I stop this thread."); 
				break; 
			}
		}
	}
	
	private boolean hasSleepInterrupt() {
		// 
		try {
			Thread.sleep(10);
			return false; 
		} catch (InterruptedException e) {
			return true; 
		}
	}
}