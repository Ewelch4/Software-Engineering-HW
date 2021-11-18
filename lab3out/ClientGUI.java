package lab3out;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.GridBagLayout;
import javax.swing.*;
public class ClientGUI extends JFrame implements ActionListener
{
   JLabel status;
   JButton connect;
   JButton submit;
   JButton stop; // end lab1 fileds
   String[] labels = {"Client ID","Server URL", "Server Port"};
   JTextArea clientArea;
   JTextArea serverArea;
   JTextArea port;
   JTextArea clientdata;
   ChatClient client;
   JTextArea serverdata;
   JLabel clientID;
  public ClientGUI(String title)
  {
    int i = 0;
    
    client = new ChatClient(title, i);
   
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
   
    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
    status = new JLabel();
    status.setText("Not Connected");
    status.setForeground(Color.red);
	//adding label to panel
    
    JPanel north = new JPanel();
    north.setLayout(new FlowLayout());
	north.add(status);
	//adding panel to frame
	this.add(north, BorderLayout.NORTH);
	//add 3 buttons
	connect = new JButton();
	connect.setText("Connect");
	connect.addActionListener(this);
	
	submit = new JButton();
	submit.setText("Submit");
	submit.addActionListener(this);
	
	stop = new JButton();
	stop.setText("Stop");
	stop.addActionListener(this);
	
	// add buttons to jpanel
	JPanel south = new JPanel();
	south.setLayout(new FlowLayout());
	south.add(connect);
	south.add(submit);
	south.add(stop);
	
	// add south panel to frame
	this.add(south, BorderLayout.SOUTH);
	
	
	//Lab2 Additions of labels and text fields
	clientArea = new JTextArea("",1,10);
	clientArea.setEditable(false);
	clientID = new JLabel("Client ID");
	serverArea = new JTextArea("", 1, 10);
	JLabel serverLabel = new JLabel(labels[1]);
	port = new JTextArea("",1,10);
	JLabel portLabel = new JLabel(labels[2]);
	JPanel contentPanel = new JPanel();
	JPanel contentPanel2 = new JPanel();
	JPanel contentPanel3=new JPanel();
	JPanel contentHolder = new JPanel();
	contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.Y_AXIS));
	
	contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	contentPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);
	contentPanel3.setAlignmentX(Component.CENTER_ALIGNMENT);
	contentHolder.add(contentPanel);
	contentHolder.add(contentPanel2);
	contentHolder.add(contentPanel3);
	contentPanel.add(clientID,BorderLayout.CENTER);
	contentPanel.add(clientArea,BorderLayout.CENTER);
	
	contentPanel2.add(serverLabel,BorderLayout.CENTER);
	contentPanel2.add(serverArea, BorderLayout.CENTER);
	
	contentPanel3.add(portLabel,BorderLayout.CENTER);
	contentPanel3.add(port, BorderLayout.CENTER);
	//Adding server feedback textfields w/ scrollpane
	 clientdata = new JTextArea();
	JScrollPane clientScroll = new JScrollPane (clientdata);
	JLabel clientdataLabel = new JLabel("Enter Client Data Below");
	 serverdata = new JTextArea();
	JScrollPane serverScroll = new JScrollPane(serverdata);
	JLabel serverdataLabel = new JLabel("Recieved Server Data");
	serverdata.setEditable(false);
	clientdataLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	contentHolder.add(clientdataLabel);
	clientScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
	contentHolder.add(clientScroll);
	
	contentHolder.add(serverdataLabel);
	contentHolder.add(serverScroll);
	
	//this.add(contentPanel);
	//this.add(contentPanel2);
	this.add(contentHolder);
	//Display of Window/frame
	this.pack();
	this.setVisible(true);
	
	//Button Press Method Calls/action listeners
	
  }

  public static void main(String[] args)
  {
    new ClientGUI(args[0]); //args[0] represents the title of the GUI
  }
//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html

@Override
public void actionPerformed(ActionEvent e) {
	
	String command = e.getActionCommand();
	
	if (command.equals("Connect")) {
		if(status.getText()!="Connected") {
		try {
			status.setText("Connected");
			status.setForeground(Color.green);
			 client.setHost(serverArea.getText());
			 client.setPort(Integer.parseInt((port.getText())));
			 client.setServerMsg(serverdata);
			 client.setClientID(clientArea);
			 client.openConnection();
			 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
	else if (command.equals("Submit")) {
		try {
			client.sendToServer(clientdata.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if (command.equals("Stop")) {
		try {
			client.closeConnection();
			status.setText("Not Connected");
			status.setForeground(Color.red);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


}
