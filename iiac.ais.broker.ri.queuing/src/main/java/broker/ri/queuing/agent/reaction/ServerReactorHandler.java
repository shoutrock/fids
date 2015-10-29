package broker.ri.queuing.agent.reaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ServerReactorHandler extends SimpleChannelInboundHandler<ByteBuf> {
	//
	private static final Logger logger = LoggerFactory.getLogger(ServerReactorHandler.class);
	
	public ServerReactorHandler() {
		//
	}
	
	 @Override
	 public void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) {
		 String requestStr = byteBuf.toString(CharsetUtil.UTF_8); 
        logger.debug(String.format("Agent received0:channelRead():%s ", requestStr));
	 }
	
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    	//
        logger.debug("channelReadComplete(): writeAndFlushed.");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	//
        logger.debug("exceptionCaught(): closed().");
        cause.printStackTrace();
        ctx.close();
    }
}
