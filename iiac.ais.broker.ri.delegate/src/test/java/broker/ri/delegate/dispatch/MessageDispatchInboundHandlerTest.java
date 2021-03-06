package broker.ri.delegate.dispatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import broker.ri.delegate.client.dispatch.MessageDispatchInboundHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;

public class MessageDispatchInboundHandlerTest {
	//
	@Test
	public void testChannelActive() {
		//
		EmbeddedChannel channel = new EmbeddedChannel(new MessageDispatchInboundHandler("Hello Embedded Channel"));
		assertTrue(channel.finish());
		ByteBuf byteBuf = (ByteBuf)channel.readOutbound();
		String requestMessage = byteBuf.toString(CharsetUtil.UTF_8);
		
		assertEquals("Hello Embedded Channel", requestMessage);
	}
}
