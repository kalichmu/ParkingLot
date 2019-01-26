package com.birddoghr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ParkingLotClass {
	private int numberOfSlots;
	private ArrayList<Integer> vehiclesParked = new ArrayList<Integer>();
	private int slotsEmpty;
	private double wheelRate = 5.00;
	private Map<String, Double> collection = new HashMap<String, Double>();
	private Map<Integer, String> vehicleList = new HashMap<Integer, String>();

	public ParkingLotClass(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
		slotsEmpty = numberOfSlots;
	}

	public double totalCollection() {
		double sum = 0.00;
		for (double val : collection.values()) {
			sum += val;
		}
		return sum;
	}

	public double totalCollectionByVehicleType(String vehicleType) {
		if (collection.get(vehicleType) != null) {
		return collection.get(vehicleType);
		} else {
			return 0.00;
		}
	}

	public Set<Entry<Integer, String>> vehicleList() {
		return vehicleList.entrySet();
	}

	public Collection<String> vehicleListByType() {
		return vehicleList.values();
	}

	public Set<Integer> vehicleListByID() {
		return vehicleList.keySet();
	}

	public String parkVehicle(Vehicle vehicle) {
		double totalPayable = 0.00;
		String vehicleType = vehicle.getVehicleType();
		if (slotsEmpty != 0) {
			totalPayable = (wheelRate * vehicle.getNumberOfWheels()) + vehicle.getSurcharge();
			vehicleList.put(vehicle.getVehicleID(), vehicle.getVehicleType());
			vehiclesParked.add(vehicle.getVehicleID());
			if (collection.containsKey(vehicleType)) {
				collection.put(vehicleType, collection.get(vehicleType) + totalPayable);
			} else {
				collection.put(vehicleType, totalPayable);
			}
			slotsEmpty--;
		}
		if (totalPayable != 0.00) {
			return "Amount payable for " + vehicleType + " is " + totalPayable;
		} else {
			return "No Parking!!";
		}
	}

	public String unparkVehicle(int id) {
		if (vehiclesParked.remove(vehiclesParked.indexOf(id)) != null) {
			vehicleList.remove(id);
			slotsEmpty++;
			return "Vehicle has been unparked.";
		} else {
			return "Could not unpark vehicle.";
		}
	}

}