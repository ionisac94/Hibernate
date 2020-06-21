package main;

import model.Phone;
import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class DemoApplication {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();


		createStudentAndPhone(entityManager);
	}

	private static void createStudentAndPhone(EntityManager entityManager) {
		Phone phone1 = new Phone("123434");
		Phone phone2 = new Phone("12345");
		Phone phone3 = new Phone("34556");
		Phone phone4 = new Phone("124565433434");

		Set<Phone> phoneSet = new HashSet<Phone>();

		phoneSet.add(phone1);
		phoneSet.add(phone2);
		phoneSet.add(phone3);
		phoneSet.add(phone4);


//		Student student = new Student("John", "Isac", phoneSet);
		Student student2 = new Student(phoneSet);

		entityManager.getTransaction().begin();

		entityManager.persist(student2);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
