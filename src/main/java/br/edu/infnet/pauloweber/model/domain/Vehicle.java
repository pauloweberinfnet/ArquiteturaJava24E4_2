package br.edu.infnet.pauloweber.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "TVehicle", uniqueConstraints = @UniqueConstraint(columnNames = {"licensePlate"}))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicleType")
public abstract class Vehicle{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@NotBlank(message = "A placa é obrigatória.")
	@Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres.")
	private String licensePlate;
	private boolean archived;

	@Positive(message = "O odômetro não pode ser negativo.")
	private float odometer;

	@NotBlank(message = "A marca é obrigatória.")
	@Size(min = 3, max = 50, message = "A marca deve ter entre 3 e 50 caracteres.")
	private String brand;

	@NotBlank(message = "O modelo é obrigatório.")
	@Size(min = 3, max = 50, message = "O modelo deve ter entre 3 e 50 caracteres.")
	private String model;

	@NotBlank(message = "O ano é obrigatório.")
	@Size(min = 4, max = 4, message = "O ano deve ter 4 dígitos.")
	private int modelYear;

  /* @OneToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Trip> trips;

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	} */

	@Override
	public String toString() {
		return String.format("Veículo: Placa %s, Marca %s, Modelo %s, Ano %d", licensePlate, brand, model, modelYear);
	}

	public String getVehicleType() {
 		return this.getClass().getSimpleName();
 	}

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
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
