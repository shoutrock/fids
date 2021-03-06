package broker.ri.echo.server.reaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MessageReactorHandler extends SimpleChannelInboundHandler<ByteBuf> {
	//
	private static final Logger logger = LoggerFactory.getLogger(MessageReactorHandler.class);
	
	public MessageReactorHandler() {
		//
	}
	
	 @Override
	 public void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) {
		 String requestStr = byteBuf.toString(CharsetUtil.UTF_8); 
        logger.debug(String.format("Server received0:channelRead():%s ", requestStr));
        
        ctx.writeAndFlush(Unpooled.copiedBuffer(requestStr, CharsetUtil.UTF_8));
	 }
	
	 @Override
	    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	        //
	        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	    }

	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
	        cause.printStackTrace();

	        if (ctx.channel().isActive()) {
	            ctx.writeAndFlush("ERR: " + cause.getClass().getSimpleName() + ": " + cause.getMessage() + '\n')
	                    .addListener(ChannelFutureListener.CLOSE);
	        }
	    }
}
