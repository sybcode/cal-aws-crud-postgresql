package com.example.demo.entities;

/*Mapeo relacional de objetos ORM-JPA*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Amazoncal")
public class Amazoncal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idamazoncal;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameInstance", nullable = false, length = 45)
	private String nameInstance;

	@NotNull(message = "Ingrese CPUS")
	@DecimalMax("32")
	@Column(name = "cpus", nullable = false, length = 11)
	private double cpus;

	@NotNull(message = "Ingrese Memoria Gb")
	@DecimalMax("128")
	@Column(name = "memory", nullable = false, length = 11)
	private double memory;
	
	@NotNull(message = "Ingrese storage Gb")
	@DecimalMax("2000")
	@Column(name = "storage", nullable = false, length = 11)
	private double storage;
	
	/*//for int or number
	@NotEmpty(message = "Ingrese RUC")
	@Size(min = 11, max = 11)
	@Digits(integer = 11, fraction = 0)
	@Column(name = "rucDepartamentortamento", nullable = false, length = 11)
	private String rucDepartamentortamento;
	*/

	public Amazoncal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amazoncal(int idamazoncal, String nameInstance, double cpus, double memory, double storage) {
		super();
		this.idamazoncal = idamazoncal;
		this.nameInstance = nameInstance;
		this.cpus = cpus;
		this.memory = memory;
		this.storage = storage;
	}

	public int getIdamazoncal() {
		return idamazoncal;
	}

	public void setIdamazoncal(int idamazoncal) {
		this.idamazoncal = idamazoncal;
	}

	public String getNameInstance() {
		return nameInstance;
	}

	public void setNameInstance(String nameInstance) {
		this.nameInstance = nameInstance;
	}

	public double getCpus() {
		return cpus;
	}

	public void setCpus(double cpus) {
		this.cpus = cpus;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}
	
}
