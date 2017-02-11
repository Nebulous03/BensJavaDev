package nebulous;

import java.io.IOException;
import java.net.Socket;

public class NetworkTesting {
	
	public static final short PORT = 25565;
	
	public static void main(String[] args) {
		Server server = new Server(PORT);
		server.start();
		
//		try {
//			Client client = new Client(new Socket("localhost", PORT));
//			client.send("HelloWorld");
//			client.send("HelloWorld2");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
