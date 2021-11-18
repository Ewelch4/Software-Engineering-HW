package lab3out;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer {
	private JTextArea log; 
	private JLabel status; //Corresponds to JTextArea in ServerGUI
	
	public ChatServer() {
		super(8300);
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
		//log.append("Server Started\n");
	}

	public void clientConnected(ConnectionToClient client) {
		
		try {
			client.sendToClient(("username:"+"Client"+ client.getId()+"\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.append("Client"+client.getId()+" Connected\n");
		
	}
	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// TODO Auto-generated method stub
		log.append("\nClient"+arg1.getId()+": "+arg0);
		try {
			//System.out.println("server sent");
			arg1.sendToClient(arg0+"\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Client Message sent to Server");
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
