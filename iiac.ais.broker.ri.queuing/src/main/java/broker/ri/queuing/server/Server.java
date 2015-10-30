package broker.ri.queuing.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.queuing.server.dispatch.AgentDispatcher;
import broker.ri.queuing.server.queue.ServerRequestQueue;
import broker.ri.queuing.server.queue.ServerRequestSubscriber;
import broker.ri.queuing.server.reaction.AdapterReactor;

public class Server {
	//
	private static final Logger logger = LoggerFactory.getLogger(Server.class);
	
	private static Server server;
	
	private AdapterReactor reactor;
	private AgentDispatcher dispatcher;
	private ServerRequestQueue requestQueue;
	private ServerRequestSubscriber requestSubscriber;
	
	private Server() {
		this.reactor = new AdapterReactor();
		this.dispatcher = new AgentDispatcher();
		this.requestQueue = new ServerRequestQueue();
		this.requestSubscriber = new ServerRequestSubscriber(requestQueue);
	}
	
	public static synchronized Server getInstance() {
		if (server==null) {
			server = new Server();
		}
		return server;
	}
	
	public void startAll() {
		logger.debug("============================== Server prepare. ==============================");
		this.requestSubscriber.start();
		logger.debug("============================== Server prepare1. ==============================");
		this.reactor.start();
		logger.debug("============================== Server Started. ==============================");
	}

	public AgentDispatcher getDispatcher() {
		return dispatcher;
	}

	public ServerRequestQueue getRequestQueue() {
		return requestQueue;
	}
	
}
