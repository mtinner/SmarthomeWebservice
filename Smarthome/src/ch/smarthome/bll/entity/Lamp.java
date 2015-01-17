package ch.smarthome.bll.entity;

public class Lamp {
	private int id;
	private boolean status;

	public Lamp() {
		super();
	}

	public Lamp(int id, boolean status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
