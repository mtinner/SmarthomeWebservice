package ch.smarthome.bll.manager;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.bll.entity.LampPoller;
import ch.smarthome.bll.entity.Station;
import ch.smarthome.dal.ClientLampConnector;

public class LampManager {
	private static LampPoller lp = new LampPoller();
	private ClientLampConnector tc = new ClientLampConnector();
	private static ConcurrentHashMap<String, Station> resultList = new ConcurrentHashMap<String, Station>(); //Ip, Station
	private final String[] ipArray = {"10.0.0.2"};
	private final int[] floorArray = {2};
	private int[][] ioArray = new int[][] {{0,2}};
	private static HashMap<Integer,String> globalIdToIpMapping = new HashMap<Integer, String>(); //Id, IP
	private static HashMap<Integer,Integer> globalIdToLocalIdMapping = new HashMap<Integer, Integer>(); //Id, IP
	
	
	public LampManager() {
		super();
		System.out.println(Thread.currentThread().getId());
		if(!lp.isAlive())
		{
			lp.setLampManager(this);
			initializeAvailableStations();
			lp.start();
		}
	}

	public Lamp get(int globalId) {
		//String ip =idToIp(globalId);		
		return resultList.get(idToIp(globalId)).getLamps().get(idToLocalId(globalId));//tc.getLamp(idToIp(globalId),idToLocalId(globalId));
	}

	public void set(Lamp lamp) {
		tc.setLamp(lamp);
	}
	
	private void initializeAvailableStations(){
		//cant throw error when ip-array and io-Array got not the same size
		for (int actualEspId = 0; actualEspId < ipArray.length; actualEspId++) {
			resultList.put(ipArray[actualEspId], new Station(ipArray[actualEspId], floorArray[actualEspId], ioArray[actualEspId]));
			for (int localId : ioArray[actualEspId]) {
				globalIdToIpMapping.put(buildId(actualEspId, localId), ipArray[actualEspId]);
				globalIdToLocalIdMapping.put(buildId(actualEspId, localId), localId);
				System.out.println(buildId(actualEspId, localId));
			}
		}
	}
	
	public String[] getIpList(){
		return ipArray;
	}
	
	public ConcurrentHashMap<String, Station> getResultList(){
		return resultList;
	}
	
	public void setStation(String ip, Station station){
		resultList.put(ip, station);
	}
	
	public int idToLocalId(int globalId){
		
		return globalIdToLocalIdMapping.get(globalId);
	}
	
	public String idToIp(int globalId){
		return globalIdToIpMapping.get(globalId);
	}
	

	public int buildId(int actualEspId, int localLampId){
		int n = (actualEspId+1)*10+floorArray[actualEspId];
		//append localLampId to 
		if(localLampId==0){
			n = n*10;
		}
		else if(localLampId<10){
			n = n*10+localLampId;
		}
		else{//locallampId
			n = n*100+ localLampId;
		}
		return n; //
	}
}
