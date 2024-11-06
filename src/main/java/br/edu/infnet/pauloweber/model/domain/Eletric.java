package br.edu.infnet.pauloweber.model.domain;

public class Eletric extends Vehicle{
	private String batteryNominalCapacity;
  private float batteryCurrentCapacity;
  private float batteryHealth;

  public String getBatteryNominalCapacity() {
    return batteryNominalCapacity;
  }
  public void setBatteryNominalCapacity(String batteryNominalCapacity) {
    this.batteryNominalCapacity = batteryNominalCapacity;
  }
  public float getBatteryCurrentCapacity() {
    return batteryCurrentCapacity;
  }
  public void setBatteryCurrentCapacity(float batteryCurrentCapacity) {
    this.batteryCurrentCapacity = batteryCurrentCapacity;
  }
	public float getBatteryHealth() {
    return batteryHealth;
  }
  public void setBatteryHealth(float batteryHealth) {
    this.batteryHealth = batteryHealth;
  }

}
