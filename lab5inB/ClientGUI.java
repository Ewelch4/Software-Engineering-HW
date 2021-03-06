package lab5inB;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame
{
 
  
  // Constructor that creates the client GUI.
  public ClientGUI()
  {
    ChatClient chatClient = new ChatClient();
    chatClient.setHost("localhost");
    chatClient.setPort(8300);
    try {
		chatClient.openConnection();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // Set the title and default close operation.
    this.setTitle("Client");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    // Create the card layout container.
    CardLayout cardLayout = new CardLayout();
    JPanel container = new JPanel(cardLayout);
    
    //Create the Controllers next
    //Next, create the Controllers
    InitialControl ic = new InitialControl(container); 
    LoginControl lc = new LoginControl(container, chatClient); //Probably will want to pass in ChatClient here
    
    
    // Create the four views. (need the controller to register with the Panels
    JPanel view1 = new InitialPanel(ic);
    JPanel view2 = new LoginPanel(lc);
    
    
    // Add the views to the card layout container.
    container.add(view1, "1");
    container.add(view2, "2");
   
    
    // Show the initial view in the card layout.
    cardLayout.show(container, "1");
    
    // Add the card layout container to the JFrame.
    this.add(container, BorderLayout.CENTER);

    // Show the JFrame.
    this.setSize(550, 350);
    this.setVisible(true);
  }

  // Main function that creates the client GUI when the program is started.
  public static void main(String[] args)
  {
    new ClientGUI();
  }
}
