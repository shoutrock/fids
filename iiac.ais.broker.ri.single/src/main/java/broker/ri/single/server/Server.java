package broker.ri.single.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.single.server.reaction.MessageReactor;

public class Server {
    //
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private MessageReactor reactor;

    public Server() {
        //
        this.reactor = new MessageReactor();
    }
    
    public void start() {
        this.reactor.start();
        logger.debug("Server Started.");
    }
}
