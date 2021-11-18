package lab3in;

import java.io.IOException;

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
		String msg = (String) arg0;
		System.out.println("Client " + arg1.getId()+ ": " + msg);
		try {
			arg1.sendToClient("\nHello Client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
