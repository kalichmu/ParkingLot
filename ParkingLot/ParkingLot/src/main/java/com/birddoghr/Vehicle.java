package com.birddoghr;

public class Vehicle {

	private String vehicleType;
	private int vehicleID;
	private double surcharge;
	private int numberOfWheels;

	public Vehicle(String vehicleType, int vehicleID, double surcharge, int numberOfWheels) {
		this.vehicleType = vehicleType;
		this.vehicleID = vehicleID;
		this.surcharge = surcharge;
		this.numberOfWheels = numberOfWheels;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public double getSurcharge() {
		return surcharge;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public boolean parkVehicle() {
		return false;
	}

	public boolean unparkVehicle() {
		return false;
	}

}
