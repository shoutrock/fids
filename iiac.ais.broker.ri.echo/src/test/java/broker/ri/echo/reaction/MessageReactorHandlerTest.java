package broker.ri.echo.reaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import broker.ri.echo.server.reaction.MessageReactorHandler;
import io.netty.channel.embedded.EmbeddedChannel;

public class MessageReactorHandlerTest {
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
