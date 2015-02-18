import java.io.*;
import java.net.*;
import java.util.*;

public final class proj1 {

	public static void main(String[] args) throws Exception{
		// Set the port number
		int port = 5750;
		
		// Establish the listen socket
		ServerSocket servSock = new ServerSocket(port);
		
		// Process HTTP service requests in an infinite loop
		while(true){
			// Listen for a TCP connection request
			Socket clientSock = servSock.accept();
			
			// Construct an object to process the HTTP request message
			HttpRequest request = new HttpRequest(clientSock);
			
			// Create a new thread to process the request
			Thread thread = new Thread(request);
			
			// Start the thread
			thread.start();
		}

	}

}

final class HttpRequest implements Runnable{
	
	final static String CRLF = "\r\n";
	Socket socket;
	
	// Constructor
	public HttpRequest (Socket socket) throws Exception {
		this.socket = socket;
	}
	
	// Implement the run() method of the Runnable interface
	public void run(){
		try {
			processRequest();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	private void processRequest() throws Exception {
		
	}
	
}
