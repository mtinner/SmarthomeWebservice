package ch.smarthome.bll.manager;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.dal.ClientLampConnector;

public class LampManager {
	private ClientLampConnector tc = new ClientLampConnector();

	public LampManager() {
		super();
	}

	public Lamp get(int id) {
		return tc.getLamp(id);
	}

	public void set(Lamp lamp) {
		tc.setLamp(lamp);
	}
}
