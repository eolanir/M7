package com.vehicles.project;

public class License {
	
	protected int id;
	protected String type;
	protected String name;
	protected String expiration;
	
	public License(int id, String type, String name, String expiration) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.expiration = expiration;
	}
	
	public String getType() {
		return type;
	}
}
