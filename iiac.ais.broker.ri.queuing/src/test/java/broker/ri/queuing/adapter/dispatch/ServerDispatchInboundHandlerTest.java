package broker.ri.queuing.adapter.dispatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;

public class ServerDispatchInboundHandlerTest {

	@Test
	public void testChannelActive() {
		//
		EmbeddedChannel channel = new EmbeddedChannel(new ServerDispatchInboundHandler("Hello Embedded Channel"));
		assertTrue(channel.finish());
		ByteBuf byteBuf = (ByteBuf)channel.readOutbound();
		String requestMessage = byteBuf.toString(CharsetUtil.UTF_8);
		
		assertEquals("Hello Embedded Channel", requestMessage);
	}

}
