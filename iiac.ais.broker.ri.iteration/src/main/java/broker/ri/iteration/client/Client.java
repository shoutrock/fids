package broker.ri.iteration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.iteration.client.dispatch.MessageDispatcher;

public class Client extends Thread {
    //
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    private MessageDispatcher dispatcher;

    public Client() {
        this.dispatcher = new MessageDispatcher();
    }

    public void run() {
        int requestCount = 0;
        
        while(true){
            if (hasSleepInterrupt()) {
                break;
            }
            dispatcher.dispatch("Request Message "+requestCount++);
        }
    }

    private boolean hasSleepInterrupt() {
        try {
            Thread.sleep(100);
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("Catch a interrupt signal, so I stop this thread."); 
            return true;
        }
    }
}
