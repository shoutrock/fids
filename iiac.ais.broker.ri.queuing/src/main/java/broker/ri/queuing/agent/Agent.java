package broker.ri.queuing.agent;

import broker.ri.queuing.agent.reaction.ServerReactor;

public class Agent {
	private ServerReactor reactor;

	public Agent() {
		this.reactor = new ServerReactor();
	}
	
	public void start() {
		this.reactor.start();
	}
}
