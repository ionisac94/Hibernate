package main;

import model.Competition;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		createUserAndCompetition(entityManager);
		removeUserAndCompetition(entityManager);
		removeCompetition(entityManager);

	}

	private static void createUserAndCompetition(EntityManager entityManager) {

		entityManager.getTransaction().begin();

		List<Competition> competitionUser1 = new ArrayList<>();
		competitionUser1.add(Competition.builder().competitionName("fotbal").competitionDescription("good").build());
		competitionUser1.add(Competition.builder().competitionName("tenis").competitionDescription("good").build());
		competitionUser1.add(Competition.builder().competitionName("voleyball").competitionDescription("good").build());
		competitionUser1.add(Competition.builder().competitionName("swiming").competitionDescription("good").build());


		User user1 = User.builder().firstName("Ion").lastName("Isac").competitions(competitionUser1).build();
		entityManager.persist(user1);

		entityManager.getTransaction().commit();

		System.out.println("second transaction begin");

		entityManager.getTransaction().begin();

		List<Competition> competitionUser2 = new ArrayList<>();
		competitionUser2.add(Competition.builder().competitionName("fotbal").competitionDescription("good").build());
		competitionUser2.add(Competition.builder().competitionName("tenis").competitionDescription("good").build());
		competitionUser2.add(Competition.builder().competitionName("voleyball").competitionDescription("good").build());

		User user2 = User.builder().firstName("Gigel").lastName("Marcel").competitions(competitionUser2).build();
		entityManager.persist(user2);
		entityManager.getTransaction().commit();

	}

	private static void removeCompetition(EntityManager entityManager) {

		entityManager.getTransaction().begin();
		Competition competition = entityManager.find(Competition.class, 6);
		System.out.println("Remove Competition :" + competition);
		entityManager.remove(competition);
		entityManager.getTransaction().commit();
	}

	private static void removeUserAndCompetition(EntityManager entityManager) {

		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, 1);
		System.out.println("Remove User :" + user);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
}
