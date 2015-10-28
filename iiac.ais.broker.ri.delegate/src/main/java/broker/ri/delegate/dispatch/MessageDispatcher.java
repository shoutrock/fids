package broker.ri.delegate.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MessageDispatcher {
	//
	private static final Logger logger = LoggerFactory.getLogger(MessageDispatcher.class);
	
    private EventLoopGroup eventLoopGroup; 
   
    public MessageDispatcher() {
    	// 
        this.eventLoopGroup = new NioEventLoopGroup();
   }

    public void dispatch(String requestMessage) {
    	//
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup);
            bootstrap.channel(NioSocketChannel.class); 
            bootstrap.handler(new MessageDispatchChannelInitializer(requestMessage));
            
            ChannelFuture future = bootstrap.connect("172.24.255.70", 12000).sync();
            future.addListener(new MessageDispatchFutureListener());
        } catch (Exception e) {
        	logger.debug("Exception occurred:" + e.getMessage());
        	e.printStackTrace();
        } 
         
    }
    
    public void shutdown() {
        try {
			eventLoopGroup.shutdownGracefully().sync();
		} catch (InterruptedException e) {
	       	logger.error(e.getMessage());
		}       
    }
}
