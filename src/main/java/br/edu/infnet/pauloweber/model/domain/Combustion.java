package br.edu.infnet.pauloweber.model.domain;

public class Combustion extends Engine{
	private String fuelType;
  private float fuelTankCapacity;

  public String getFuelType() {
    return fuelType;
  }
  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }
  public float getFuelTankCapacity() {
    return fuelTankCapacity;
  }
  public void setFuelTankCapacity(float fuelTankCapacity) {
    this.fuelTankCapacity = fuelTankCapacity;
  }

}
