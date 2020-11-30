package server;

import java.net.*;

import motors.ClawController;
import motors.TreadController;

import java.io.*;

public class Server {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream instream = null;
	
	public Server(int port, TreadController myTreads, ClawController myClaw) {
		try {
			server = new ServerSocket(port);
			System.out.println("server starting");
			
			System.out.println("Waiting for client.");
			
			socket = server.accept();
			System.out.println("client connected");
			
			instream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String nextLine = "";
			
			while(!nextLine.equalsIgnoreCase("done")) {
				try {
					nextLine = instream.readUTF();
					
					switch(nextLine) {
					case "forward":
						myTreads.goForward();
						break;
					case  "backward":
						myTreads.goBackwards();
						break;
					case "left":
						myTreads.turnLeft();
						break;
					case  "right":
						myTreads.turnRight();
						break;
					case  "close":	
						myClaw.close();
						break;
					case  "open":
						myClaw.open();
						break;
					case "":
						break;
					case "done":
						System.out.println("shutting down");
					default: 
						System.out.println("Invalid command");
						
					}
					
				}
				catch(Exception e) {
					if(e.getMessage() != null) {
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
		catch(Exception e) {
			if(e.getMessage() != null) {
				System.out.println(e.getMessage());
			}
		}
	}

}
