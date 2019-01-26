package com.birddoghr;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("How many parking slots does the parking lot have?");
		Scanner scan = new Scanner(System.in);
		int size = 0;
		if (scan.hasNext()) {
			size = Integer.parseInt(scan.nextLine());
		}
		
		ParkingLotClass parkingLot = new ParkingLotClass(size);
		
		while(size != 0) {
		System.out.println();
		System.out.println("Choose the vehicle type:");
		System.out.println("1. Compact");
		System.out.println("2. Full");
		System.out.println("3. Truck");
		System.out.println("4. Motorcycle");
		System.out.println("5. Electric");
		
		int vehicleOption = 0;
		int vehicleID = (int)((Math.random() * size)+1);
		int wheels = 0;
		double surcharge = 0.00;
		String vehicleType = "";
		if (scan.hasNext()) {
			vehicleOption = Integer.parseInt(scan.nextLine());
		}

		switch (vehicleOption) {
		case 1:
			vehicleType = "Compact";
			wheels = 4;
			break;
		case 2:
			vehicleType = "Full";
			surcharge = 2.00;
			wheels = 4;
			break;
		case 3:
			vehicleType = "Truck";
			surcharge = 3.00;
			wheels = 4;
			break;
		case 4:
			vehicleType = "Motorcycle";
			wheels = 2;
			break;
		case 5:
			vehicleType = "Electric";
			surcharge = 1.00;
			wheels = 4;
			break;
		default:
			vehicleType = "Compact";
			wheels = 4;
			break;
		}

		System.out.println();
		System.out.println("Choose an option:");
		System.out.println("1. Park");
		System.out.println("2. Unpark");
		System.out.println("3. List all vehicles");
		System.out.println("4. List vehicles by type");
		System.out.println("5. List vehicles by ID");
		System.out.println("6. Total money collection");
		System.out.println("7. Total money collected by vehice type");
		int task = 0;
		if (scan.hasNext()) {
			task = Integer.parseInt(scan.nextLine());
		}

		switch (task) {
		case 1:
			Vehicle vehicle = new Vehicle(vehicleType, vehicleID, surcharge, wheels);
			System.out.println(parkingLot.parkVehicle(vehicle));
			break;
		case 2:
			System.out.println("Provide ID of vehicle:");
			int id = 0;
			if (scan.hasNext()) {
				id = Integer.parseInt(scan.nextLine());
			}
			System.out.println(parkingLot.unparkVehicle(id));
			break;
		case 3:
			System.out.println("List of vehicles:");
			Set<Entry<Integer, String>> list = parkingLot.vehicleList();
			if (list != null) {
			for (Entry<Integer, String> item : list) {
				System.out.println(item.getKey()+" = "+item.getValue());
			}
			} else {
				System.out.println("No vehicles to display.");
			}
			break;
		case 4:
			System.out.println("List of vehicles by type:");
			Collection<String> listType = parkingLot.vehicleListByType();
			if (listType != null) {
			for (String item : listType) {
				System.out.println(item);
			}
			} else {
				System.out.println("No vehicles to display.");
			}
			break;
		case 5:
			System.out.println("List of vehicles by ID:");
			Set<Integer> listID = parkingLot.vehicleListByID();
			if (listID != null) {
			for (Integer item : listID) {
				System.out.println(item);
			}
			} else {
				System.out.println("No vehicles to display.");
			}
			break;
		case 6:
			System.out.println("Total Collection:");
			System.out.println(parkingLot.totalCollection());
			break;
		case 7:
			System.out.println("Provide vehicle type:");
			String type = "";
			if (scan.hasNext()) {
				type = scan.nextLine();
			}
			System.out.println("Total collection for vehicle type: "+type);
			System.out.println(parkingLot.totalCollectionByVehicleType(type));
			break;
		}
		System.out.println();
	}
	scan.close();
 }
}