package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected Owner owner;
	protected List<Person> drivers = new ArrayList<Person>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void addDriver(Person driver) {
		drivers.add(driver);
	}
	
	public void getWheels() {
		for(Wheel i : wheels) {
			System.out.println(i.getWheel());
		}
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getPlate() {
		return this.plate;
	}
	public void getVehicle() {
	}
}
