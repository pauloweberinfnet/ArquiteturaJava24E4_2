package br.edu.infnet.pauloweber.model.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TTrip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float startingOdometer;
    private float endingOdometer;
    private float distance;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration tripDuration;
    private float averageSpeed;
    private float startingFuelLevel;
    private float endingFuelLevel;
    private float fuelConsumption;
    private float averageConsumption;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "driverId")
    @JsonManagedReference
    private Driver driver;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    @Override
    public String toString() {
      final String vehiclePlate = vehicle.getLicensePlate();
      return String.format("Viagem: Distância %.2f km, Veículo %s, Duração %s, Velocidade Média %.2f km/h, Consumo médio %.2f", distance, vehiclePlate , tripDuration, averageSpeed, averageConsumption);
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public Vehicle getVehicle() {
      return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
    }
    public Driver getDriver() {
      return driver;
    }
    public void setDriver(Driver driver) {
      this.driver = driver;
    }
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
    public Duration getTripDuration() {
      return tripDuration;
    }
    public void setTripDuration(LocalDateTime startTime, LocalDateTime endTime) {
      this.tripDuration = Duration.between(startTime, endTime);
    }
    public float getAverageSpeed() {
      return averageSpeed;
    }
    public void setAverageSpeed(float distance, Duration tripDuration) {
      this.averageSpeed = distance / (tripDuration.toMinutes() / 60.0f);
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
    public float getAverageConsumption() {
      return averageConsumption;
    }
    public void setAverageConsumption(float fuelConsumption, float distance) {
      this.averageConsumption = distance / fuelConsumption;
    }
}
