package lab3in;

import ocsf.client.AbstractClient;

public  class ChatClient extends AbstractClient {
		
		public ChatClient() {
				super("localhost", 8300);
			
			}
			
			public void handleMessageFromServer(Object msg) {
				System.out.println("Server Message sent to Client" + msg);
				
			}
			
			public void connectionException(Throwable exception) {
				System.out.println("Conncection exception occurred");
				System.out.println(exception.getMessage());
				exception.printStackTrace();
			}
			public void connectionEstablished(){
				System.out.println("Client Connected");
			}
			
	}
