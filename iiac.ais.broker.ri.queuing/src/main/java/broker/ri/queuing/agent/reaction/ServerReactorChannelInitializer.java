package broker.ri.queuing.agent.reaction;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerReactorChannelInitializer extends ChannelInitializer<SocketChannel> {
	private ServerReactorHandler handler;

	public ServerReactorChannelInitializer() {
		//
		this.handler = new ServerReactorHandler();
	}

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		//
		ChannelPipeline pipeLine = channel.pipeline();
		pipeLine.addLast(handler);
	}

}
