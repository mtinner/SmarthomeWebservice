package ch.smarthome.bll.manager;

import ch.smarthome.bll.entity.Lamp;

public class LampManager{
	
	public LampManager() {
		super();
	}

	public Lamp get(int id){
		return new Lamp(id, false);
	}
	
	public Lamp set(Lamp lamp){
		return new Lamp(42,true);
	}
}
