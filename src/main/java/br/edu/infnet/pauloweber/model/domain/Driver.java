package br.edu.infnet.pauloweber.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TDriver", uniqueConstraints = @UniqueConstraint(columnNames = {"licenseId"}))
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "A CNH é obrigatória.")
	@Size(min = 9, max = 9, message = "A CNH deve ter 9 dígitos.")
	@Column(unique = true)
	private String licenseId;

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
	private String name;

// Removi a assoociação com Trip por não ter implementado a listagem de viagens por motorista.
/* 	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "driverId")
	//@JsonBackReference
	@JsonIgnore
	private List<Trip> trips;

	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	} */
	public Driver() {
		super();
	}

	public Driver(String licenseId, String name) {
		this.licenseId = licenseId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Motorista: CNH=" + licenseId + ", nome=" + name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
