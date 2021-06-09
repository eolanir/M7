package com.vehicles.project;

public class Driver extends Person {
	
	public Driver(String name, String lastname, String birthday) {
		super(name, lastname, birthday);
	}
	
	public Driver(String name, String lastname, String birthday, License license) {
		super(name, lastname, birthday);
		this.license = license;
	}
	
	public void getPerson() {
		System.out.println("Conductor: " + this.name + " " + this.lastname + ".\nData de naixement: " + this.birthday + ".\nID llicencia: " + license.id + 
				".\nTipus de llicencia: " + license.type + ".\nData de expiració: " + license.expiration + ".\n");
	}
	
	/*public String getName() {
		return this.name;
	}*/
}
