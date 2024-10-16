package br.edu.infnet.pauloweber.model.domain;

import java.util.List;

public abstract class Vehicle{
	private String licensePlate;
	private boolean archived;
	private List<Driver> drivers;

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
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

}
