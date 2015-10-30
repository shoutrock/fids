package broker.ri.single.server.reaction;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MessageReactorChannelInitializer extends ChannelInitializer<SocketChannel> {

	public MessageReactorChannelInitializer() {
		//
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		//
		ChannelPipeline pipeLine = channel.pipeline();
		pipeLine.addLast(new MessageReactorHandler());
	}
	
}
