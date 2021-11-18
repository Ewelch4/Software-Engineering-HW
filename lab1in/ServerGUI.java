package lab1in;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ServerGUI extends JFrame implements ActionListener{
	 JLabel status;
	 JTextArea log;
	 JButton listen;
	 JButton close;
	 JButton stop;
	 JButton quit;
	 
	public ServerGUI(String title){
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
		
		JTextArea port = new JTextArea();
		port = new JTextArea("",1,10);
		//port.setEditable(false);
		JLabel portLabel = new JLabel("Port #");
		JTextArea timeoutArea = new JTextArea("", 1, 10);
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
		

		
		JTextArea serverlog = new JTextArea();
		JScrollPane serverScroll = new JScrollPane(serverlog);
		JLabel serverlogLabel = new JLabel("Server Log Below");
		serverlog.setEditable(false);
		serverlogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentHolder.add(serverlogLabel);
		contentHolder.add(serverScroll);
		
		this.add(contentHolder);
		this.pack();
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new ServerGUI(args[0]);
	}
	  public void EventHandler(String name) {
		  //Displays a message based on which button was pressed above.
		  System.out.println(name + " Button Pressed");
	  }
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command.equals("Listen")) {
			EventHandler("Listen");
		}
		else if (command.equals("Close")) {
			EventHandler("Close");
		}
		else if (command.equals("Stop")) {
			EventHandler("Stop");
		}
		else if (command.equals("Quit")) {
			System.exit(0);;
		}
	}

}
