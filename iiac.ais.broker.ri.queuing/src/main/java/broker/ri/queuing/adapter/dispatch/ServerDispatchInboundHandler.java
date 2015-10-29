/*******************************************************************************
 * Copyright(c) 2015-2020 Incheon International Airport Corporation.
 * All rights reserved. This software is the proprietary information of
 * Incheon International Airport Corporation.
 *******************************************************************************/
package broker.ri.queuing.adapter.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@Sharable
public class ServerDispatchInboundHandler extends ChannelInboundHandlerAdapter {
	//
	private static final Logger logger = LoggerFactory.getLogger(ServerDispatchInboundHandler.class);
	
	private String message; 
	
	public ServerDispatchInboundHandler(String message) {
		// 
		this.message = message; 
	}
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    	//
    	String requestStr = message;
    	logger.debug(String.format("channelActive():%s", requestStr));
    	
        ctx.writeAndFlush(Unpooled.copiedBuffer(requestStr, CharsetUtil.UTF_8)); // 서버에 전송 
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	//
    	cause.printStackTrace();
		logger.error(String.format("exceptionCaught():%s", cause.getMessage())); 
		
        ctx.close();
    }
}