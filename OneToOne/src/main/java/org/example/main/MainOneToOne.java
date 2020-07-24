package org.example.main;

import org.example.domain.Document;
import org.example.domain.Nationalitty;
import org.example.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class MainOneToOne {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		createDocumentAndPerson(entityManager);
		findDocumentById(entityManager, 152);
	}

	private static void findDocumentById(EntityManager entityManager, Integer id) {

		Document document = entityManager.find(Document.class, id);
		System.out.println(document);
	}


	public static void createDocumentAndPerson(EntityManager entityManager) {
		entityManager.getTransaction().begin();

		Document doc1 = Document.builder().serialNumber(UUID.randomUUID().toString()).build();
		Document doc2 = Document.builder().serialNumber(UUID.randomUUID().toString()).build();
		Document doc3 = Document.builder().serialNumber(UUID.randomUUID().toString()).build();

		Person person1 = Person.builder().dateOfBirth(LocalDate.now()).firstName("Ion").lastName("Isac").nationalitty(Nationalitty.ROU).document(doc1).build();
		Person person2 = Person.builder().dateOfBirth(LocalDate.now()).firstName("Cristina").lastName("Isac").nationalitty(Nationalitty.ROU).document(doc2).build();
		Person person3 = Person.builder().dateOfBirth(LocalDate.now()).firstName("Tom").lastName("McGregor").nationalitty(Nationalitty.EN).document(doc3).build();

		entityManager.persist(doc1);
		entityManager.persist(doc2);
		entityManager.persist(doc3);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);

		entityManager.getTransaction().commit();
	}
}
