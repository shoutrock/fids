/*******************************************************************************
 * Copyright(c) 2015-2020 Incheon International Airport Corporation.
 * All rights reserved. This software is the proprietary information of
 * Incheon International Airport Corporation.
 *******************************************************************************/
package broker.ri.queuing.adapter.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

public class ServerDispatchFutureListener implements ChannelFutureListener {
	//
	private static final Logger logger = LoggerFactory.getLogger(ServerDispatchFutureListener.class);
	
	public ServerDispatchFutureListener() {
		// 
	}
	
	@Override
	public void operationComplete(ChannelFuture channelFuture) throws Exception {
		//
		logger.info("in AdapterDispatchFutureListener");
		logger.debug(String.format("operationComplete():[success:%b],[done:%b],[cancelled:%b],[toString:%s]", 
				channelFuture.isSuccess(), 
				channelFuture.isDone(), 
				channelFuture.isCancelled(),
				channelFuture.toString())); 
		
		if (!channelFuture.isSuccess()) {
			logger.error("Fail!!!!!");
		}
	}
}