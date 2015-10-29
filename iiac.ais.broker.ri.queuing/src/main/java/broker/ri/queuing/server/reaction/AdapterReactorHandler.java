package broker.ri.queuing.server.reaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import broker.ri.queuing.server.Server;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class AdapterReactorHandler extends SimpleChannelInboundHandler<ByteBuf> {
	//
	private static final Logger logger = LoggerFactory.getLogger(AdapterReactorHandler.class);

	public AdapterReactorHandler() {
		//
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) {
		String requestMessage = byteBuf.toString(CharsetUtil.UTF_8);
		logger.debug(String.format("Server received0:channelRead():%s ", requestMessage));

		Server.getInstance().getRequestQueue().putRequest(requestMessage);
		logger.debug("I put Message in RequestQueue");
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
