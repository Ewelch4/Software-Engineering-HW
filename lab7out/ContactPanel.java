package lab7out;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ContactPanel extends JPanel{

	public ContactPanel() {
	  // Constructor for the login panel.

	    // Create the controller and set it in the chat client.
	    //LoginControl controller = new LoginControl(container, client);
	    //client.setLoginControl(controller);
	        
	    // Create a panel for the labels at the top of the GUI.
	    JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    JLabel instructionLabel = new JLabel("Contacts", JLabel.CENTER);
	    labelPanel.add(instructionLabel);

	    // Create a panel for the login information form.
	    JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	   
	    JScrollPane contacts = new JScrollPane();
	    loginPanel.add(contacts);
	    
	    // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton deleteButton = new JButton("Delete Contact");
	    //deleteButton.addActionListener();
	    JButton addButton = new JButton("Cancel");
	    //addButton.addActionListener(); 
	    JButton logoutButton = new JButton("Logout");
	    //addButton.addActionListener();   
	    buttonPanel.add(deleteButton);
	    buttonPanel.add(addButton);
	    buttonPanel.add(logoutButton);
	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
	    grid.add(labelPanel);
	    grid.add(loginPanel);
	    grid.add(buttonPanel);
	    this.add(grid);
	    
	    
	}	
	  
	}



