package lab2out;

import java.awt.*;

import javax.swing.*;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer {
	private JTextArea log; 
	private JLabel status; //Corresponds to JTextArea in ServerGUI
	
	public ChatServer() {
		super(12345);
		setTimeout(500);
	}
	public void setLog(JTextArea log) {
		this.log = log;
		
	}
	public void setStatus(JLabel status) {
		this.status = status;
	}
	public void serverStarted() {
		status.setText("Listening");
		status.setForeground(Color.green);
		log.append("Server Started\n");
	}

	public void clientConnected(ConnectionToClient client) {
		log.append("Client Connected\n");
	}
	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// TODO Auto-generated method stub
		System.out.println("Client Message sent to Server");
	}
	
	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
		System.out.println(exception.getMessage());
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.red);
		log.append(exception.getMessage() + "\n");		
		log.append("Press Listen to Restart Server\n");
	}
	

}
