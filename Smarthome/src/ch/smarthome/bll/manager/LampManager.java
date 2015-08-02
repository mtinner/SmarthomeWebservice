package ch.smarthome.bll.manager;

import java.net.SocketException;

import ch.smarthome.bll.entity.ESPOutput;
import ch.smarthome.dal.ClientLampConnector;
import ch.smarthome.helper.SharedLampState;

public class LampManager {
	private ClientLampConnector connector = new ClientLampConnector();

	public LampManager() {
		super();
	}

	public void set(int id, ESPOutput output) {
			connector.setLamp(SharedLampState.getInstance().getLamp(id).getIp(),
					output);
	}

}
