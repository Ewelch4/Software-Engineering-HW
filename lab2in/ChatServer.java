package lab2in;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer {


	public ChatServer() {
		super(12345);
		setTimeout(500);
	}
	
	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// TODO Auto-generated method stub
		System.out.println("Client Message sent to Server");
	}
	
	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
		System.out.println(exception.getMessage());
		exception.printStackTrace();		
	}
	
	public void serverStarted() {
		System.out.println("Server Started");
	}

}
