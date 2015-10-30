package broker.ri.single.server.reaction;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MessageReactor {
	//
	private static final Logger logger = LoggerFactory.getLogger(MessageReactor.class);
	private final InetSocketAddress socketAddress; 
	private EventLoopGroup eventLoopGroup;
	
	public MessageReactor() {
		this.eventLoopGroup = new NioEventLoopGroup();
		this.socketAddress = new InetSocketAddress(12000);
	}
	
	public void start() {
    	//
		logger.debug("MessageReactor is started");
       try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(eventLoopGroup); 
            bootstrap.channel(NioServerSocketChannel.class); 
            bootstrap.localAddress(socketAddress);
            bootstrap.childHandler(new MessageReactorChannelInitializer());

            ChannelFuture f = bootstrap.bind().sync();
            
            f.channel().closeFuture().sync();
        } catch (InterruptedException ie) {
        	logger.debug("Interrupted:" + ie.getMessage());
        	ie.printStackTrace(); 
        }
        
    	logger.debug("end.");
    } 
}
