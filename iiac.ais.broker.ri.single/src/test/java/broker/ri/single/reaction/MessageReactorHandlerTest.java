package broker.ri.single.reaction;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.channel.embedded.EmbeddedChannel;

public class MessageReactorHandlerTest {
	//
	@Test
	public void testChannelRead0() {
		//
		System.out.println("testChannelRead0");
		EmbeddedChannel channel = new EmbeddedChannel(new MessageReactorHandler());
		assertTrue(channel.writeInbound("RequestMessage"));
		assertTrue(channel.finish());
	}
}
