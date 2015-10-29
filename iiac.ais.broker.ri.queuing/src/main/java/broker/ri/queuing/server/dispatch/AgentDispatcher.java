package broker.ri.queuing.server.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class AgentDispatcher {
	//
	private static final Logger logger = LoggerFactory.getLogger(AgentDispatcher.class);
	
	private static final String INET_ADDRESS = "172.24.255.71";
	private static final int INET_PORT = 12000;
	
    private EventLoopGroup eventLoopGroup; 
   
    public AgentDispatcher() {
    	// 
        this.eventLoopGroup = new NioEventLoopGroup();
   }

    public void dispatch(String requestMessage) {
    	//
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup);
            bootstrap.channel(NioSocketChannel.class); 
            bootstrap.handler(new AgentDispatchChannelInitializer(requestMessage));
            
            ChannelFuture future = bootstrap.connect(INET_ADDRESS, INET_PORT).sync();
            future.addListener(new AgentDispatchFutureListener());
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
