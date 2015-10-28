package broker.ri.echo.dispatch;

public class MessageDispatcherStater {
	//
	public static void main(String[] args) {
		MessageDispatcher dispatcher = new MessageDispatcher();
		dispatcher.dispatch("Hello");
	}
}
