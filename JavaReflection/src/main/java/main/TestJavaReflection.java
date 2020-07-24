package main;

import model.Car;
import model.adnotation.Name;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestJavaReflection {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {

		Class<Car> carClass = Car.class;

		Field fieldNameCar = carClass.getDeclaredField("nameCar");

		Constructor<?>[] carClassConstructors = carClass.getDeclaredConstructors();

		Constructor<?> carClassConstructor = carClassConstructors[0];

		carClassConstructor.setAccessible(true);

		Car car = (Car) carClassConstructor.newInstance();
		System.out.println(car);

		fieldNameCar.setAccessible(true);

		Name annotation = fieldNameCar.getAnnotation(Name.class);

		fieldNameCar.set(car, annotation.name());

		car.printDetailsCar();

	}
}
