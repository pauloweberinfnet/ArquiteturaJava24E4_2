package br.edu.infnet.pauloweber.model.domain;

public abstract class Vehicle{
	private String licensePlate;
	private boolean archived;
	private float odometer;
	private String brand;
	private String model;
	private int year;

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getOdometer() {
		return odometer;
	}
	public void setOdometer(float odometer) {
		this.odometer = odometer;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public boolean isArchived() {
		return archived;
	}
	public void setArchived(boolean archived) {
		this.archived = archived;
	}

}
