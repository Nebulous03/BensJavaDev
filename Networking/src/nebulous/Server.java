package nebulous;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
	
	private short  				port;
	private int					timeout;
	private ServerSocket 		server;
	private ArrayList<Client>	clients;
	
	public Server(short port){
		
		this.port 		= 	port;
		this.timeout	= 	4000;
		this.clients 	= 	new ArrayList<Client>();
		
		try {
			this.server = new ServerSocket(port);
			server.setSoTimeout(timeout);
		} catch (IOException e) {
			System.out.println("[Server] Error creating new ServerSocket!");
			e.printStackTrace();
		}
		
	}
	
	public void addClient(Client client){
		clients.add(client);
	}
	
	public void removeClient(Client client){
		clients.remove(client);
	}
	
	public Socket lookForConnection(){
		
		while(true){
			try {
				System.out.println("[Server] Waiting for client on port " + server.getLocalPort() + "...");
				for(Client c : clients) {
					System.out.println("Clients: " +  c);
				}
				return server.accept();
			} catch (IOException e) {
				System.out.println("[Server] Timed out. Retrying...");
			}
		}
		
	}
	
	public void start(){
		
		Thread searchThread = new Thread() {
		public void run() {
		while(true) {
			Socket socket = lookForConnection();
			if(socket != null){ 
				addClient(new Client(socket));
				System.out.println("[Server] Connected to client > " + socket.getRemoteSocketAddress());
			}
		}}}; 
		
		searchThread.start();
		
		Thread readThread = new Thread() {
		public void run() {
		while(true) {
			for(Client client : clients){
				try {
					int length = client.getInputStream().readInt();
					System.out.println(length);
					byte[] in = new byte[length];
					client.getInputStream().readFully(in);
					printBytes(in);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}}}; 

		readThread.start();
		
	}
	
	static void printBytes(byte[] bytes){
		for (int i = 0; i < bytes.length; i++){
			System.out.printf("0x%x ", bytes[i]);
		} System.out.println();
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		try { server.setSoTimeout(timeout);
		} catch (SocketException e) {
			e.printStackTrace();
		} this.timeout = timeout;
	}

	public short getPort() {
		return port;
	}

	public ServerSocket getServer() {
		return server;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

}
