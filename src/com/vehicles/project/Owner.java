package com.vehicles.project;

public class Owner extends Person {
	
	protected boolean insurance;
	protected boolean garage;
	
	public Owner(String name, String lastname, String birthday) {
		super(name, lastname, birthday);
	}
	
	public Owner(String name, String lastname, String birthday, License license, boolean insurance, boolean garage) {
		super(name, lastname, birthday);
		this.license = license;
		this.insurance = insurance;
		this.garage = garage;
	}
	
	public void getPerson() {
		System.out.println("Titular: " + this.name + " " + this.lastname + ".\nData de naixement: " + this.birthday + ".\nID llicencia: " + license.id + 
				".\nTipus de llicencia: " + license.type + ".\nData de expiració: " + license.expiration + ".\n");
	}
	
	/*public String getName() {
		return this.name;
	}*/
}
