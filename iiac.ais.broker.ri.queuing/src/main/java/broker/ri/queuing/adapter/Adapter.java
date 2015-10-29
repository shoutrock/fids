package broker.ri.queuing.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.queuing.adapter.dispatch.ServerDispatcher;
import broker.ri.queuing.server.dispatch.AgentDispatcher;

public class Adapter extends Thread {
	//
	private static final Logger logger = LoggerFactory.getLogger(AgentDispatcher.class);
	
	private ServerDispatcher dispatcher;

	public Adapter() {
		this.dispatcher = new ServerDispatcher();
	}

	public void run() {
		int index = 0;
		while (true) {
			if (hasSleepInterrupt()) {
				logger.debug("Catch a interrupt signal, so I stop this thread."); 
				break; 
			}
			
			String requestMessage = "[Adapter] Hello~ _" + index++;

			this.dispatcher.dispatch(requestMessage);
		}
	}

	public boolean hasSleepInterrupt() {
		try {
			Thread.sleep(500);
			return false;
		} catch (InterruptedException e) {
			return true;
		}
	}
}
