package nebulous.test;

import java.net.Socket;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ClientWindow window = new ClientWindow();
		window.setVisible(true);

		String ip = "10.1.15.254";
		short port = 31415;

		Socket s = new Socket(ip, port);
		TestClient client = new TestClient(s);
		client.start();

		client.send("HelloWorld!");

	}

}
