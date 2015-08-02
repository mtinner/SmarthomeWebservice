package ch.smarthome.dal;

import java.net.SocketException;






import org.glassfish.jersey.client.ClientResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import ch.smarthome.bll.entity.ESPOutput;
import ch.smarthome.bll.entity.Lamp;

public class ClientLampConnector {

	public void setLamp(String ip, ESPOutput output) {
		try{
		Client client = Client.create();
		String s = String.format("%s%s%s","http://", ip, "/output");
		client.getExecutorService();
		WebResource webResource = client.resource(s);
		webResource.header("Content-Type", "application/json;charset=UTF-8");
		webResource.post(ClientResponse.class, output);}
		catch(Exception e){}
		
	}
}
