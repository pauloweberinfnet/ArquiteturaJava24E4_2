package br.edu.infnet.pauloweber.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TCombustion")
public class Combustion extends Vehicle{
	private String fuelType;
  private float fuelTankCapacity;
  private float fuelLevel;

  public float getFuelLevel() {
    return fuelLevel;
  }
  public void setFuelLevel(float fuelLevel) {
    this.fuelLevel = fuelLevel;
  }
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
