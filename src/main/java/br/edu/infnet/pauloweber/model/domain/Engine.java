package br.edu.infnet.pauloweber.model.domain;

public abstract class Engine extends Vehicle{
	private int id;
	private float odometer;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getOdometer() {
		return odometer;
	}
	public void setOdometer(float odometer) {
		this.odometer = odometer;
	}

}
