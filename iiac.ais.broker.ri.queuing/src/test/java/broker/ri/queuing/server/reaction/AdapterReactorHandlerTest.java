package broker.ri.queuing.server.reaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.channel.embedded.EmbeddedChannel;

public class AdapterReactorHandlerTest {
	//
	@Test
	public void testChannelRead0() {
		//
		EmbeddedChannel channel = new EmbeddedChannel(new AdapterReactorHandler());
		assertTrue(channel.writeInbound("RequestMessage"));
		assertTrue(channel.finish());
		String requestMessage = (String)channel.readInbound();
		assertEquals("RequestMessage", requestMessage);
	}
}
