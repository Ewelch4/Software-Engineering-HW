package lab3in;

import java.io.IOException;

public class TestChatClient {
	private ChatClient client;
	
	public TestChatClient(String host, int port) throws IOException {
		client = new ChatClient();
		client.setHost(host);
		client.setPort(port);
		client.openConnection();
		client.sendToServer("Hello Server");
	}
	
	public static void main(String[] args) throws IOException {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		new TestChatClient(host,port);
	}
	
	
}
