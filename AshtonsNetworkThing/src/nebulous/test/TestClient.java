package nebulous.test;

import java.io.IOException;
import java.net.Socket;

import org.duckdns.crackedcrafters.zaneoblaneo.clientServerAPI.Client;

public class TestClient extends Client{

	public TestClient(Socket s) throws IOException, NoSuchMethodException, SecurityException {
		super(s);
	}

	@Override
	public void onClientRecievedData(Object data) {
		System.out.println((String)data);
	}

	@Override
	public void onClientSentData(Object data) {
		
	}

}
