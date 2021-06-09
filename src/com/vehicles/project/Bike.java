package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(Wheel frontWheel, Wheel backWheel) {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
	
	public void getVehicle() {
		System.out.println("Moto amb matricula: " + this.plate + ".\nMarca: " + this.brand + ".\nColor: " + this.color + ".\nRodes:");
		getWheels();
		System.out.println("Propietari: " + owner.getName() + ".\nConductors:");
		for(Person i : drivers) {
			System.out.println(i.getName());
		}
	}
	

}
