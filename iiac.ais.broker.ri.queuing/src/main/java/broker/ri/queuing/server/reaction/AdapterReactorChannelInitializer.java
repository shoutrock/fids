package broker.ri.queuing.server.reaction;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class AdapterReactorChannelInitializer extends ChannelInitializer<SocketChannel> {

	public AdapterReactorChannelInitializer() {
		//
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		//
		ChannelPipeline pipeLine = channel.pipeline();
		pipeLine.addLast(new AdapterReactorHandler());
	}
	
}
