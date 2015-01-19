package ch.smarthome.bll.manager;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.dal.LampSocket;

public class LampManager {
	private LampSocket tc = new LampSocket();

	public LampManager() {
		super();
	}

	public Lamp get(int id) {
		return new Lamp(id, tc.startClient());
	}

	public Lamp set(Lamp lamp) {
		return new Lamp(42, true);
	}
}
