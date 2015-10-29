package broker.ri.queuing.server;

public class ServerStarter {
	//
	public static void main(String[] args) {
		//
		Server server = Server.getInstance();
		server.startAll();
		
		// TODO Thread 2
	}
}
