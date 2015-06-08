package ch.smarthome.bll.manager;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.dal.ClientLampConnector;

public class LampManager {
	private ClientLampConnector tc = new ClientLampConnector();

	public LampManager() {
		super();
	}

	public Lamp get(int id) {
		return tc.getLed(id);
	}

	public void set(Lamp lamp) {
		/*if(lamp.getStatus()==1){
			lamp.setStatus(tc.getLed(lamp.getId()*10+1));
		}
		else{
			lamp.setStatus(tc.getLed(lamp.getId()*10));
		}
		return lamp;*/
	}
}
