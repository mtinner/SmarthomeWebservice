package ch.smarthome.dal;

import java.net.ConnectException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.helper.PropertyHelper;

public class ClientLampConnector {

	public Lamp getLamp(String ip, int id) {
		ClientResponse response = null;
		Lamp lamp = null;

		try {
			Client client = Client.create();
			String s = String.format("%s%s%s%d", "http://", ip, "/led/", id);
			client.getExecutorService();
			WebResource webResource = client.resource(s);
			response = webResource.get(ClientResponse.class);

			lamp = response.getEntity(Lamp.class);
		} catch (Exception e) {
			System.err.println("IP: " + ip);
			System.err.println("Message: " + e.getMessage());
		}
		return lamp;
	}

	public void setLamp(Lamp lamp) {
		PropertyHelper property = new PropertyHelper();
		String host = property.getProperty("ESP");

		Client client = Client.create();
		String s = String.format("%s%s", host, "led/");
		client.getExecutorService();
		WebResource webResource = client.resource(s);
		ClientResponse response = webResource.post(ClientResponse.class, lamp);
	}
}
