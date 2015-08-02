package ch.smarthome.helper;

import java.util.HashMap;

import ch.smarthome.bll.entity.ESPInput;
import ch.smarthome.bll.entity.ESPOutput;
import ch.smarthome.bll.entity.Lamp;

public class SharedLampState {
	private static SharedLampState instance = null;
	private static HashMap<Integer, Lamp> lampState;
	
	public static SharedLampState getInstance(){
		if(instance == null){
			instance= new SharedLampState();
			lampState = new HashMap<Integer, Lamp>();
			initializeLampState();
		}
		return instance;
	}
	
	private static void initializeLampState(){
		lampState.put(0, new Lamp("10.0.0.40", 2, 0, new ESPInput(0,0), new ESPOutput(2, 0)));
	}
	
	public Lamp getLamp(int id){
		return lampState.get(id);
	}
}
