package lab3in;

import java.io.IOException;

public class TestChatServer {

	private ChatServer server;
	public TestChatServer(int port, int timeout) {
		server = new ChatServer();
		
		//setting port and Timeout
		server.setPort(port); 
		server.setTimeout(timeout);
		//Hey Listen! (listens for client)
		try {
			server.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		int timeout = Integer.parseInt(args[1]);
		new TestChatServer(port,timeout);
		
		
	}

}
