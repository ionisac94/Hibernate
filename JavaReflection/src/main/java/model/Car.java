package model;


import model.adnotation.Name;

import java.time.LocalDate;
import java.util.List;

public class Car {

	private CarType carType;

	private List<String> keys;

	@Name(name = "BMW")
	private String nameCar;

	private LocalDate dateConstruction;

	public void printDetailsCar() {
		System.out.println("Car name is " + nameCar + " and dateConstruction is " + dateConstruction);
	}

	private Car() {
	}
}
