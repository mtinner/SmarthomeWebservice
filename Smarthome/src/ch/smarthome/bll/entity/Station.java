package ch.smarthome.bll.entity;

import java.util.HashMap;

public class Station {
	private String ip;
	private int floor;

	private HashMap<Integer, Lamp> lamps; //localId, Lamp

	public Station(String ip, int floor, int[] usedIO) {
		super();
		this.ip = ip;
		this.floor = floor;
		this.lamps = new HashMap<Integer, Lamp>();
		initializeAllIO(usedIO);
	}
	
	public Station(Station newStation){
		ip = newStation.ip;
		floor = newStation.floor;
		lamps = newStation.lamps;
	}

	public void addLamp(int localId, Lamp lamp) {
		lamps.put(localId, lamp);
	}
	
	public void setLamp(int localId, Lamp lamp){
		lamps.put(localId, lamp);
	}
	
	public int getFloor() {
		return floor;
	}


	public HashMap<Integer, Lamp> getLamps() {
		return lamps;
	}

	private void initializeAllIO(int[] usedIO) {
		for (int localId : usedIO) {
			addLamp(localId, new Lamp(localId, 0));
		}
	}
}
