package lab3out;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
public class ServerGUI extends JFrame implements ActionListener{
	 static JLabel status;
	 private JTextArea log;
	 private JButton listen;
	 private JButton close;
	 private JButton stop;
	 private JButton quit;
	 
	 private JTextArea port;
	 private JTextArea timeoutArea;
	 
	 private ChatServer server;
	 
	 
	public ServerGUI(String title){
	    this.setTitle(title);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    server = new ChatServer();
	    
	   
	    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
	    status = new JLabel();
	    
	    status.setText("Not Connected");
	    status.setForeground(Color.red);
	    
	    server.setStatus(status); // added lab2out
		//adding label to panel
	    
	    JPanel north = new JPanel();
	    north.setLayout(new FlowLayout());
		north.add(status);
		//adding panel to frame
		this.add(north, BorderLayout.NORTH);
		
		
		listen = new JButton();
		listen.setText("Listen");
		listen.addActionListener(this);
		
		close = new JButton();
		close.setText("Close");
		close.addActionListener(this);
		
		stop = new JButton();
		stop.setText("Stop");
		stop.addActionListener(this);
		
		quit = new JButton();
		quit.setText("Quit");
		quit.addActionListener(this);
		// add buttons to jpanel
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		south.add(listen);
		south.add(close);
		south.add(stop);
		south.add(quit);
	
		// add south panel to frame
		this.add(south, BorderLayout.SOUTH);
		
		
		JPanel contentHolder = new JPanel();
		contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.Y_AXIS));
		
		port = new JTextArea();
		port = new JTextArea("",1,10);
		//port.setEditable(false);
		JLabel portLabel = new JLabel("Port #");
		timeoutArea = new JTextArea("", 1, 10);
		JLabel timeoutLabel = new JLabel("Timeout");

		JPanel contentPanel = new JPanel();
		JPanel contentPanel2 = new JPanel();
		
		contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		contentPanel.add(portLabel,BorderLayout.CENTER);
		contentPanel.add(port,BorderLayout.CENTER);
		
		contentPanel2.add(timeoutLabel,BorderLayout.CENTER);
		contentPanel2.add(timeoutArea, BorderLayout.CENTER);
		contentHolder.add(contentPanel);
		contentHolder.add(contentPanel2);
		

		
		log = new JTextArea();
		JScrollPane serverScroll = new JScrollPane(log);
		JLabel serverlogLabel = new JLabel("Server Log Below");
		log.setEditable(false);
		server.setLog(log); //added lab2out
		serverlogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentHolder.add(serverlogLabel);
		contentHolder.add(serverScroll);
		
		this.add(contentHolder);
		this.pack();
		this.setVisible(true);
		
	}
	
	  public void EventHandler(String name) {
		  //Displays a message based on which button was pressed above.
		  System.out.println(name + " Button Pressed");
	  }
	  public void ListenHandler() throws IOException {
		 
		  if( port.getText().isEmpty() == false && timeoutArea.getText().isEmpty() == false) {
			  server.listen();
			  server.serverStarted();
		  }
		  else {
			 log.append("Port Number/Timeout not entered before pressing Listen\n");
		  }
		  
	  }
	  public void stopHandler() {
		  if( status.getText() != "Listening" ) {
			  log.append("Server Not Currently Started");
		  }
		  else {
			  server.stopListening();
			  status.setText("Stopped");
			  status.setForeground(Color.red);
			  log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
		  }
	  }
	  public void closeHandler() throws IOException {
		  if (status.getText() != "Listening") {
			  log.append("Server Not Currently Started\n");
		  }
		  else{
			  server.close();
			  status.setText("Close");
			  status.setForeground(Color.red);
			  log.append("Server and all current clients are closed - Press Listen to Restart\n");
		  }
	  }
	  
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command.equals("Listen")) {
			try {
				ListenHandler();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (command.equals("Close")) {
			try {
				closeHandler();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (command.equals("Stop")) {
			stopHandler();
		}
		else if (command.equals("Quit")) {
			System.exit(0);;
		}
	}
	public static void main(String[] args) {
		new ServerGUI(args[0]);
	
	}
}
