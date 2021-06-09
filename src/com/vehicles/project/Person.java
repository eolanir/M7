package com.vehicles.project;

public abstract class Person {
	
	protected String name;
	protected String lastname;
	protected String birthday;
	protected License license;
	
	public Person(String name, String lastname, String birthday) {
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
	}
	
	public void getPerson() {
		
	}
	
	public String getName() {
		return this.name + " " + this.lastname;
	}
}
