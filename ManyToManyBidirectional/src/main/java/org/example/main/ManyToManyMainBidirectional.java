package org.example.main;

import org.example.domain.Department;
import org.example.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class ManyToManyMainBidirectional {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Map<String, Object> properties = entityManager.getProperties();

		System.out.println(properties);
//		createEmployeesAndDepartments(entityManager);

//		findDepartment(entityManager);
//		findEmployee(entityManager);

//		removeEmployee(entityManager);

//		removeDepartment(entityManager);

	}

	private static void createEmployeesAndDepartments(EntityManager entityManager) {

		Employee employee1 = new Employee();
		Employee employee2 = new Employee();

		Department department1 = new Department();
		Department department2 = new Department();

		employee1.setFirstName("Ion");
		employee1.setLastName("Isac");
		employee1.setDateEmployed(LocalDate.now());
		employee1.setDepartments(new ArrayList<>());
		employee1.getDepartments().add(department1);
		employee1.getDepartments().add(department2);

		employee2.setFirstName("Matei");
		employee2.setLastName("Florin");
		employee2.setDateEmployed(LocalDate.now());
		employee2.setDepartments(new ArrayList<>());
		employee2.getDepartments().add(department2);

		department1.setDepartmentCode("1234-444");
		department1.setDepartmentName("HR");
		department1.setEmployees(new ArrayList<>());
		department1.getEmployees().add(employee1);

		department2.setDepartmentCode("1234-333");
		department2.setDepartmentName("FINANCE");
		department2.setEmployees(new ArrayList<>());
		department2.getEmployees().add(employee1);
		department2.getEmployees().add(employee2);

		entityManager.getTransaction().begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(department1);
		entityManager.persist(department2);

		entityManager.getTransaction().commit();

	}

	private static void findDepartment(EntityManager entityManager) {

		Department department = entityManager.find(Department.class, 1);
		System.out.println(department);
	}

	private static void findEmployee(EntityManager entityManager) {
		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println(employee);
	}


	private static void removeEmployee(EntityManager entityManager) {

		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println(employee);
		entityManager.getTransaction().begin();

		entityManager.remove(employee);

		entityManager.getTransaction().commit();
	}

	private static void removeDepartment(EntityManager entityManager) {

		Department department = entityManager.find(Department.class, 2);
		System.out.println(department);
		entityManager.getTransaction().begin();

		entityManager.remove(department);
		for (Employee employee : department.getEmployees()) {
			employee.getDepartments().remove(department);
		}
		entityManager.getTransaction().commit();
	}
}
