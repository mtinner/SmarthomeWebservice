package ch.smarthome.bll.manager;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.dal.ClientLampSocket;

public class LampManager {
	private ClientLampSocket tc = new ClientLampSocket();

	public LampManager() {
		super();
	}

	public Lamp get(int id) {
		return new Lamp(id, tc.startClient(id));
	}

	public Lamp set(Lamp lamp) {
		return new Lamp(42, true);
	}
}
