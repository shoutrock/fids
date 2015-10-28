package broker.ri.echo.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDispatcherStarter {
	//
	private static final Logger logger = LoggerFactory.getLogger(MessageDispatcherStarter.class);
	
	public static void main(String[] args) {
		//
		MessageDispatcher dispatcher = new MessageDispatcher();
		
		try {
			for(int i=0; i<1000; i++) {
				dispatcher.dispatch("Hello_" + i);
				Thread.sleep(100);
			}
		} catch(InterruptedException e) {
			logger.debug("Interrupted. : " + e.getMessage() );
		}
	}
}
