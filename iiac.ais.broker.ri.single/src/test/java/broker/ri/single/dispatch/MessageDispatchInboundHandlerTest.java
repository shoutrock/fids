package broker.ri.single.dispatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;

public class MessageDispatchInboundHandlerTest {
	//
	
	@Test
	public void testChannelActive() {
		//
		EmbeddedChannel channel = new EmbeddedChannel(new MessageDispatchInboundHandler("Hello Embedded Channel"));
		ByteBuf byteBuf = (ByteBuf)channel.readOutbound();
		String requestMessage = byteBuf.toString(CharsetUtil.UTF_8);
		
		assertEquals("Hello Embedded Channel", requestMessage);
		assertTrue(channel.finish());
	}
}
