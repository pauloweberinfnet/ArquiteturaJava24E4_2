package br.edu.infnet.pauloweber.model.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class Trip {
    private float startingOdometer;
    private float endingOdometer;
    private float distance;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime tripDuration;
    private float averageSpeed;
    private float startingFuelLevel;
    private float endingFuelLevel;
    private float fuelConsumption;
    private float kilometersPerLiter;


    public float getStartingOdometer() {
      return startingOdometer;
    }
    public void setStartingOdometer(float startingOdometer) {
      this.startingOdometer = startingOdometer;
    }
    public float getEndingOdometer() {
      return endingOdometer;
    }
    public void setEndingOdometer(float endingOdometer) {
      this.endingOdometer = endingOdometer;
    }
    public float getDistance() {
      return distance;
    }
    public void setDistance(float startingOdometer, float endingOdometer) {
      this.distance = endingOdometer - startingOdometer;
    }
    public LocalDateTime getStartTime() {
      return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
      this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
      return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
      this.endTime = endTime;
    }
    public LocalTime getTripDuration() {
      return tripDuration;
    }
    public void setTripDuration(LocalDateTime startTime, LocalDateTime endTime) {
      this.tripDuration = endTime.toLocalTime().minusHours(startTime.getHour()).minusMinutes(startTime.getMinute());
    }
    public float getAverageSpeed() {
      return averageSpeed;
    }
    public void setAverageSpeed(float distance, LocalTime tripDuration) {
      this.averageSpeed = distance / tripDuration.getHour();
    }
    public float getStartingFuelLevel() {
      return startingFuelLevel;
    }
    public void setStartingFuelLevel(float startingFuelLevel) {
      this.startingFuelLevel = startingFuelLevel;
    }
    public float getEndingFuelLevel() {
      return endingFuelLevel;
    }
    public void setEndingFuelLevel(float endingFuelLevel) {
      this.endingFuelLevel = endingFuelLevel;
    }
    public float getFuelConsumption() {
      return fuelConsumption;
    }
    public void setFuelConsumption(float startingFuelLevel, float endingFuelLevel) {
      this.fuelConsumption = startingFuelLevel - endingFuelLevel;
    }
    public float getKilometersPerLiter() {
      return kilometersPerLiter;
    }
    public void setKilometersPerLiter(float fuelConsumption, float distance) {
      this.kilometersPerLiter = distance / fuelConsumption;
    }
}
