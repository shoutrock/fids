package broker.ri.single.client;

import broker.ri.single.client.dispatch.MessageDispatcher;

public class Client {
    //
    private MessageDispatcher dispatcher;

    public Client() {
        this.dispatcher = new MessageDispatcher();
    }

    public void start() {
        dispatcher.dispatch("Hello");
    }
    
}
