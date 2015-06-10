package ch.smarthome.bll.entity;

import java.util.Map.Entry;

import ch.smarthome.bll.manager.LampManager;
import ch.smarthome.dal.ClientLampConnector;

public class LampPoller extends Thread {
	LampManager lampManager;
	private ClientLampConnector tc = new ClientLampConnector();

	public LampPoller() {
	}
	
	public void setLampManager(LampManager lampManager){
		this.lampManager = lampManager;
	}

	public void run() {
		while (true) {
			for (String ip : lampManager.getIpList()) {
				Station oldStation = lampManager.getResultList().get(ip);
				Station newStation = new Station(oldStation);
				for (Entry<Integer, Lamp> lamp : oldStation.getLamps().entrySet()) {
					Lamp newLamp = tc.getLamp(ip, lamp.getKey());
					if(newLamp==null){continue;}
					if(lamp.getValue().getStatus()!=newLamp.getStatus()){
						System.out.println("IP: "+ip+" Lamp: "+newLamp.getId()+"\n"+lamp.getValue().getStatus() +" --> "+newLamp.getStatus());
						newStation.setLamp(lamp.getKey(), newLamp);
					}
				}
				lampManager.setStation(ip, newStation);
			}
			try {
				Thread.currentThread().sleep(1000);

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
