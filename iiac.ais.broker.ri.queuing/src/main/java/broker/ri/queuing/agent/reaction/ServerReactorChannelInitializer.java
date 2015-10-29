package broker.ri.queuing.agent.reaction;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerReactorChannelInitializer extends ChannelInitializer<SocketChannel> {

	public ServerReactorChannelInitializer() {
		//
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		//
		ChannelPipeline pipeLine = channel.pipeline();
		pipeLine.addLast(new ServerReactorHandler());
	}
	
}
