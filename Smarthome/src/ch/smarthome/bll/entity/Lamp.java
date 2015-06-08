package ch.smarthome.bll.entity;

public class Lamp {


	private int id;
	private int status;

	public Lamp() {
		super();
	}

	public Lamp(int id, int status) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
