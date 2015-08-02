package ch.smarthome.bll.entity;

public class Lamp {
	private String ip;
	private int floor;
	private int internalId;
	private ESPInput input;
	private ESPOutput output;

	public Lamp() {
		super();
	}
	
	public Lamp(String ip, int floor, int internalId, ESPInput input,
			ESPOutput output) {
		super();
		this.ip = ip;
		this.floor = floor;
		this.internalId = internalId;
		this.setInput(input);
		this.setOutput(output);
	}

	public int getId() {
		return internalId;
	}

	public void setId(int id) {
		this.internalId = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public ESPInput getInput() {
		return input;
	}

	public void setInput(ESPInput input) {
		this.input = input;
	}

	public ESPOutput getOutput() {
		return output;
	}

	public void setOutput(ESPOutput output) {
		this.output = output;
	}



}
