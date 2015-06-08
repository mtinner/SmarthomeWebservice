package ch.smarthome.dal;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.helper.PropertyHelper;

public class ClientLampConnector {

	public Lamp getLed(int id) {
		PropertyHelper property = new PropertyHelper();
		String host = property.getProperty("ESP");

		Client client = Client.create();
		String s = String.format("%s%s%d", host, "led/", id);
		client.getExecutorService();
		WebResource webResource = client.resource(s);
		ClientResponse response = webResource.get(ClientResponse.class);
		try {
			response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			e.getMessage();
		}

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		return response.getEntity(Lamp.class);
	}
}
