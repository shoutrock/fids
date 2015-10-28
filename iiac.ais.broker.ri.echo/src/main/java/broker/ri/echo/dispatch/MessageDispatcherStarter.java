package broker.ri.echo.dispatch;

public class MessageDispatcherStarter {
	//
	public static void main(String[] args) {
		MessageDispatcher dispatcher = new MessageDispatcher();
		dispatcher.dispatch("Hello");
	}
}
