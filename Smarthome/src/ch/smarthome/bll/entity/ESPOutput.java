package ch.smarthome.bll.entity;

public class ESPOutput {
	private int internalPort;
	private int status;
	
	public ESPOutput(){super();}
	
	public ESPOutput(int internalPort, int status) {
		super();
		this.setInternalPort(internalPort);
		this.setStatus(status);
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
