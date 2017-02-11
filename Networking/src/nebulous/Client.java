package nebulous;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket socket;
	private String username;
	private short uuid;
	
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	
	public Client(Socket socket){
		this.socket = socket;
		try {
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TEMP - Will be added to dependent client class
	public void send(String message){
		try {
			byte[] bytes = message.getBytes();
			outputStream.writeInt(bytes.length);
			outputStream.write(bytes);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Socket getSocket(){
		return socket;
	}

	public String getUsername() {
		return username;
	}

	public DataInputStream getInputStream() {
		return inputStream;
	}

	public DataOutputStream getOutputStream() {
		return outputStream;
	}


}
