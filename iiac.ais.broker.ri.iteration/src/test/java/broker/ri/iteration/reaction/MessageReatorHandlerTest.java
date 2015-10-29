package broker.ri.iteration.reaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.channel.embedded.EmbeddedChannel;

public class MessageReatorHandlerTest {
	//
	@Test
	public void testChannelRead0() {
		//
		EmbeddedChannel channel = new EmbeddedChannel(new MessageReactorHandler());
		assertTrue(channel.writeInbound("RequestMessage"));
		assertTrue(channel.finish());
		String requestMessage = (String)channel.readInbound();
		assertEquals("RequestMessage", requestMessage);
	}
}
