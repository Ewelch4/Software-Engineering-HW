package lab3out;

import java.awt.Color;

import javax.swing.*;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient {

	 JLabel status;
	 JTextArea serverMsg;
	 JTextArea clientID;
	 boolean assigned;
	public ChatClient(String host, int port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleMessageFromServer(Object arg0) {
		// TODO Auto-generated method stub
	
		if (assigned == false) {
			String[] split = ((String) arg0).split(":");
			String splitid=split[1];
			System.out.println((String)split[0]);
			System.out.println(split[1]);
			System.out.println(clientID.getText());
			clientID.setText(splitid);
			assigned = true;
		}
		System.out.println("message recieved");
		serverMsg.append("Server: " + (String)arg0);
		
	}

	public void setStatus(JLabel status) {
		this.status = (status);
		
	}
	
	public void setServerMsg(JTextArea serverMsg) {
		this.serverMsg = (serverMsg);
	}
	public void setClientID(JTextArea clientID) {
		this.clientID = (clientID);
	}
	public void connectionEstablished() {
		JLabel connectionStatus = new JLabel("Connected");
		connectionStatus.setForeground(Color.green);
		setStatus(connectionStatus);
		
	}
	public void connectionClosed() {
		status.setText("Not Connected");
		status.setForeground(Color.red);
		setStatus(status);
		assigned = false;
		clientID.setText("");
	}

}
