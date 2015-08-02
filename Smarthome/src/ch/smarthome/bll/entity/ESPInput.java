package ch.smarthome.bll.entity;

public class ESPInput {
	int internalPort;
	int status; //0 off; 1 on
	
	public ESPInput(){super();}

	
	public ESPInput(int internalPort, int status) {
		super();
		this.internalPort = internalPort;
		this.status = status;
	}
	
	public int getInternalPort() {
		return internalPort;
	}
	public void setInternalPort(int internalPort) {
		this.internalPort = internalPort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
