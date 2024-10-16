package br.edu.infnet.pauloweber.model.domain;

public class Engine extends Vehicle{
	private int id;
	private float odometer;
	private String type;
	private String power;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	

}
