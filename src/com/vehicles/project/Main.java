package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static Owner owner;
	public static Driver driver;
	public static ArrayList<Person> persons = new ArrayList<Person>();
	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	public static ArrayList<Owner> owners = new ArrayList<Owner>();
	
	public static void main(String[]args) {
		String opcio = "";
		
		System.out.println("Benvingut a la fàbrica de vehicles.");
		createOwner();
		while(opcio != "3") {
			System.out.println("Titular actual: " + owner.getName());
			System.out.println("Seleccioni la opciò desitjada. \n1.-Menú usuaris. \n2.-Menú vehicles. \n3.-Sortir.");
			opcio = sc.next();
			switch(opcio) {
			case "1":
				personMenu();
				break;
			case "2":
				vehicleFactory();
				break;
			case "3":
				opcio = "3";
				break;
			default:
				System.out.println("Opciò no vàlida.");
			}
			
		}
	}
		

	
	
	public static String checkPlate(String plate) {
		boolean check = false;
		boolean checkDigit = false;
		boolean checkLetter = false;
		
		while(check != true) {
			if(plate.length() >= 6 && plate.length() <= 7) {
				for(int i = 0; i <= 3; i++) {
					if(Character.isDigit(plate.charAt(i))) {
						checkDigit = true;
					} else {
						checkDigit = false;
						break;
					}
				}
				if (plate.length() < 7) {
					for(int i = 4; i <= 5; i++) {
						if(Character.isLetter(plate.charAt(i))) {
							checkLetter = true;
						} else {
							checkLetter = false;
							break;
						}
					}
				} else {
					for(int i = 4; i <= 6; i++) {
						if(Character.isLetter(plate.charAt(i))) {
							checkLetter = true;
						} else {
							checkLetter = false;
							break;
						}
					}
				}
				
				if(checkLetter == true && checkDigit == true) {
					check = true;
				} else {
					System.out.println("Format de la matricula erroni. Introdueix-la de nou.");
					plate = sc.next();
				}
			} else {
				System.out.println("Format de la matricula erroni. Introdueix-la de nou.");
				plate = sc.next();
			}
		}
		
		return plate;
	}
	
	public static double checkDiameter(String diameterStr) {
		double diameter = Double.parseDouble(diameterStr);
		boolean check = false;
		boolean checkDiameter = false;
		while(check!=true) {
			if(diameter >= 0.4 && diameter <= 4) {
				checkDiameter = true;
			}
			if(checkDiameter == true) {
				check = true;
			} else {
				System.out.println("El diametre ha de ser entre 0.4 i 4. Introdueix-lo de nou.");
				diameter = sc.nextDouble();
			}
		}
		return diameter;
	}
	
	public static void vehicleFactory() {
		String option = "";
		
		while(option != "6") {
			System.out.println("Introdueixi el número de la opciò. \n1.-Fabricar cotxe. \n2.-Fabricar moto. \n3.-Fabricar camió. \n4.-Mostrar vehicles \n5.-Afegir conductors. \n6.-Sortir.");
			option = sc.next();
			switch (option) {
			case "1":
				try {
					carBuilder();
				} catch (Exception e) {
					System.out.println("Tipus de carnet erroni.");
				}
				break;
				
			case "2":
				try {
					bikeBuilder();
				} catch (Exception e) {
					System.out.println("Tipus de carnet erroni.");
				}
				break;
				
			case "3":
				try {
					truckBuilder();
				} catch (Exception e) {
					System.out.println("Tipus de carnet erroni.");
				}
				break;
			case "4":
				showVehicles();
				break;
			case "5":
				addDrivers();
				break;
			case "6":
				option = "6";
				break;
			
			default:
				System.out.println("Ha de escollir una opciò correcta.");
			}
		}
	}
	
	public static void createOwner() {
		System.out.println("Introdueix el cognom del titular.");
		String lastname = sc.next();
		System.out.println("Introdueix el nom del titular.");
		String name = sc.next();
		System.out.println("Introdueix la data de naixement.");
		String birthday = sc.next();
		
		System.out.println("Disposa de garatge? Si/No");
		String gotGarage = sc.next();
		boolean garage;
		if(gotGarage.equalsIgnoreCase("Si")) {
			garage = true;
		} else {
			garage = false;
		}
		
		System.out.println("Disposa de assegurança? Si/No");
		String gotInsurance = sc.next();
		boolean insurance;
		if(gotInsurance.equalsIgnoreCase("Si")) {
			insurance = true;
		} else {
			insurance = false;
		}
		
		System.out.println("Introdueix l'id de la llicencia.");
		int licenseId = checkId();
		System.out.println("Introdueix el tipus de llicencia. (A/B/C)");
		String type = sc.next();
		System.out.println("Introdueix la data de expiració.");
		String expiration = sc.next();
		String licenseName = name + " " + lastname;
		
		License license = new License(licenseId, type, licenseName, expiration);
		
		owner = new Owner(name, lastname, birthday, license, insurance, garage);
		persons.add(owner);
		owners.add(owner);
		System.out.println("Titular creat satisfactoriament.");
	}
	
	public static int checkId() {
		String idString = sc.next();
		int licenseId;
		boolean check = false;
		while(check != true) {
			for(int i = 0; i < idString.length(); i++) {
				if(Character.isDigit(idString.charAt(i))) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if(check == false) {
				System.out.println("Format incorrecte. Introdueix la id de nou.");
				idString = sc.next();
			}
		}
		licenseId = Integer.parseInt(idString);
		return licenseId;
	}
	
	public static void carBuilder() throws Exception{
		if(!owner.license.getType().equalsIgnoreCase("B")) {
			throw new Exception();
		} else {
		
			String plate, brand, color, backWheelBrand, frontWheelBrand;
			double backWheelDiameter, frontWheelDiameter;
			
			System.out.println("Introdueix la matricula del cotxe.");
			plate = checkPlate(sc.next());
			System.out.println("Introdueix la marca del cotxe.");
			brand = sc.next();
			System.out.println("Introdueix el color del cotxe.");
			color = sc.next();
			
			Car car = new Car(plate, brand, color);
			
			System.out.println("Introdueix la marca dels neumatics darrers.");
			backWheelBrand = sc.next();
			System.out.println("Introdueix el diametre dels neumatics darrers.");
			backWheelDiameter = checkDiameter(sc.next());
			
			Wheel backWheel = new Wheel(backWheelBrand, backWheelDiameter);
			List<Wheel> backWheels = new ArrayList<Wheel>();
			backWheels.add(backWheel);
			backWheels.add(backWheel);
			
			System.out.println("Introdueix la marca dels neumatics frontals.");
			frontWheelBrand = sc.next();
			System.out.println("Introdueix el diametre dels neumatics frontals.");
			frontWheelDiameter = checkDiameter(sc.next());
	
			Wheel frontWheel = new Wheel(frontWheelBrand, frontWheelDiameter);
			List<Wheel> frontWheels = new ArrayList<Wheel>();
			frontWheels.add(frontWheel);
			frontWheels.add(frontWheel);
			
			try {
				car.addWheels(frontWheels, backWheels);
				System.out.println("Wheels added.");
			} catch (Exception e) {
				System.out.println("addWheels not working");
			}
			car.setOwner(owner);
			vehicles.add(car);
			System.out.println("Cotxe fabricat.");
			
			System.out.println("El titular serà el conductor? (Si/No)");
			String isDriver = sc.next();
			if(isDriver.equalsIgnoreCase("No")) {
				createDriver();
				if(driver.license.getType().equalsIgnoreCase("B")) {
					car.addDriver(driver);
					System.out.println("Conductor afegit.");
				} else {
					System.out.println("El conductor no pot conduir el vehicle.");
				}
			} else {
				car.addDriver(owner);
			}
		}
	}
	
	public static void bikeBuilder() throws Exception{
		if(!owner.license.getType().equalsIgnoreCase("A")) {
			throw new Exception();
		} else {
			String plate, brand, color, backWheelBrand, frontWheelBrand;
			double backWheelDiameter, frontWheelDiameter;
			
			System.out.println("Introdueix la matricula de la moto.");
			plate = checkPlate(sc.next());
			System.out.println("Introdueix la marca de la moto.");
			brand = sc.next();
			System.out.println("Introdueix el color de la moto.");
			color = sc.next();
			
			Bike bike = new Bike(plate, brand, color);
			
			System.out.println("Introdueix la marca del neumatic darrer.");
			backWheelBrand = sc.next();
			System.out.println("Introdueix el diametre del neumatic darrer.");
			backWheelDiameter = checkDiameter(sc.next());
			
			Wheel backBikeWheel = new Wheel(backWheelBrand, backWheelDiameter);
			
			System.out.println("Introdueix la marca del neumatic davanter.");
			frontWheelBrand = sc.next();
			System.out.println("Introdueix el diametre del neumatic davanter.");
			frontWheelDiameter = checkDiameter(sc.next());
			
			Wheel frontBikeWheel = new Wheel(frontWheelBrand, frontWheelDiameter);
			
			bike.addWheels(frontBikeWheel, backBikeWheel);
			
			bike.setOwner(owner);
			vehicles.add(bike);
			System.out.println("Moto fabricada.");
			
			System.out.println("El titular serà el conductor? (Si/No)");
			String isDriver = sc.next();
			if(isDriver.equalsIgnoreCase("No")) {
				createDriver();
				if(driver.license.getType().equalsIgnoreCase("A")) {
					bike.addDriver(driver);
					System.out.println("Conductor afegit.");
				} else {
					System.out.println("El conductor no pot conduir el vehicle.");
				}
			} else {
				bike.addDriver(owner);
			}
		}
	}
	
	public static void truckBuilder() throws Exception{
		if(!owner.license.getType().equalsIgnoreCase("C")) {
			throw new Exception();
		} else {
			String plate, brand, color, backWheelBrand, frontWheelBrand;
			double backWheelDiameter, frontWheelDiameter;
			
			System.out.println("Introdueix la matricula del camió.");
			plate = checkPlate(sc.next());
			System.out.println("Introdueix la marca del camió.");
			brand = sc.next();
			System.out.println("Introdueix el color del camió.");
			color = sc.next();
			
			Truck truck = new Truck(plate, brand, color);
			
			System.out.println("Introdueix la marca dels neumatics darrers.");
			backWheelBrand = sc.next();
			System.out.println("Introdueix el diametre dels neumatics darrers.");
			backWheelDiameter = checkDiameter(sc.next());
			
			Wheel backTruckWheel = new Wheel(backWheelBrand, backWheelDiameter);
			List<Wheel> backTruckWheels = new ArrayList<Wheel>();
			backTruckWheels.add(backTruckWheel);
			backTruckWheels.add(backTruckWheel);
			
			System.out.println("Introdueix la marca dels neumatics frontals.");
			frontWheelBrand = sc.next();
			System.out.println("Introdueix el diametre dels neumatics frontals.");
			frontWheelDiameter = checkDiameter(sc.next());
	
			Wheel frontTruckWheel = new Wheel(frontWheelBrand, frontWheelDiameter);
			List<Wheel> frontTruckWheels = new ArrayList<Wheel>();
			frontTruckWheels.add(frontTruckWheel);
			frontTruckWheels.add(frontTruckWheel);
			
			try {
				truck.addWheels(frontTruckWheels, backTruckWheels);
				System.out.println("Wheels added.");
			} catch (Exception e) {
				System.out.println("addWheels not working");
			}
			
			truck.setOwner(owner);
			vehicles.add(truck);
			System.out.println("Camió fabricat.");
			
			System.out.println("El titular serà el conductor? (Si/No)");
			String isDriver = sc.next();
			if(isDriver.equalsIgnoreCase("No")) {
				createDriver();
				if(driver.license.getType().equalsIgnoreCase("C")) {
					truck.addDriver(driver);
					System.out.println("Conductor afegit.");
				} else {
					System.out.println("El conductor no pot conduir el vehicle.");
				}
			} else {
				truck.addDriver(owner);
			}
		}
	}
	
	public static void createDriver() {
		System.out.println("Introdueix el cognom del conductor.");
		String lastname = sc.next();
		System.out.println("Introdueix el nom del conductor.");
		String name = sc.next();
		System.out.println("Introdueix la data de naixement.");
		String birthday = sc.next();
		
		System.out.println("Introdueix l'id de la llicencia.");
		int licenseId = checkId();
		System.out.println("Introdueix el tipus de llicencia. (A/B/C)");
		String type = sc.next();
		System.out.println("Introdueix la data de expiració.");
		String expiration = sc.next();
		String licenseName = name + " " + lastname;
		
		License license = new License(licenseId, type, licenseName, expiration);
		
		driver = new Driver(name, lastname, birthday, license);
		persons.add(driver);
		System.out.println("Conductor creat satisfactoriament.");
	}
	
	public static void personMenu() {
		String option = "";
		
		while(!option.equals("5")) {
			System.out.println("Menu d'usuaris, què vol fer? \n1.-Crear titular. \n2.-Crear conductor. \n3.-Veure llista d'usuaris. \n4.-Seleccionar titular. \n5.-Sortir.");
			option = sc.next();
			switch(option) {
			case "1":
				createOwner();
				break;
			case "2":
				createDriver();
				break;
			case "3":
				showPersons();
				break;
			case "4":
				selectOwner();
				break;
			case "5":
				option = "5";
				break;
			default:
				System.out.println("Opciò no vàlida.");
			}
		}
	}
	
	public static void showPersons() {
		for(Person i : persons) {
			i.getPerson();
		}
	}
	
	public static void showVehicles() {
		for(Vehicle i : vehicles) {
			i.getVehicle();
			System.out.println(" ");
		}
	}
	
	public static void selectOwner(){
		System.out.println("Selecciona un titular:");
		for(int i = 0; i < owners.size(); i++){
			System.out.println((i+1) + ".-" + owners.get(i).getName());
		}
		int select = sc.nextInt();
		owner = owners.get(select-1);
	}

	public static void addDrivers(){
		System.out.println("Selecciona el un vehicle per afegir conductors.");
		for(int i = 0; i < vehicles.size(); i++){
			System.out.println((i+1) + ".-" + vehicles.get(i).getBrand() + " " + vehicles.get(i).getPlate());
		}
		int selectVehicle = sc.nextInt();
		String option = "";
		while(!option.equalsIgnoreCase("No")){
			System.out.println("Selecciona el nou conductor.");
			for(int i = 0; i < persons.size(); i++){
				System.out.println((i+1) + ".-" + persons.get(i).getName());
			}
			int selectPerson = sc.nextInt();
			if(vehicles.get(selectVehicle-1).getClass() == Car.class && persons.get(selectPerson-1).license.getType().equalsIgnoreCase("B")) {
				vehicles.get(selectVehicle-1).addDriver(persons.get(selectPerson-1));
			} else if (vehicles.get(selectVehicle-1).getClass() == Bike.class && persons.get(selectPerson-1).license.getType().equalsIgnoreCase("A")) {
				vehicles.get(selectVehicle-1).addDriver(persons.get(selectPerson-1));
			} else if (vehicles.get(selectVehicle-1).getClass() == Truck.class && persons.get(selectPerson-1).license.getType().equalsIgnoreCase("C")) {
				vehicles.get(selectVehicle-1).addDriver(persons.get(selectPerson-1));
			} else {
				System.out.println("El conductor no te llicencia per conduir aquest vehicle.");
			}
			System.out.println("Vol afegir un altre conductor? (Si/No)");
			option = sc.next();
		}
	}
}
