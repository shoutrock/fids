/*******************************************************************************
 * Copyright(c) 2015-2020 Incheon International Airport Corporation.
 * All rights reserved. This software is the proprietary information of
 * Incheon International Airport Corporation.
 *******************************************************************************/
package broker.ri.delegate.client.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MessageDispatchChannelInitializer extends ChannelInitializer<SocketChannel> {
	//
	private static final Logger logger = LoggerFactory.getLogger(MessageDispatchChannelInitializer.class);

	private String message; 
	
	public MessageDispatchChannelInitializer(String message) {
		// 
		this.message = message; 
	}

	@Override
	public void initChannel(SocketChannel channel) throws Exception {
		//
		logger.debug(String.format("initChannel():%s", channel.toString()));
		
		ChannelPipeline pipeline = channel.pipeline();
		pipeline.addLast(new MessageDispatchInboundHandler(message)); 
	}
}