package main;

import model.Competition;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Application {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		createPost(entityManager);

//		deletePost(entityManager);
	}

	private static void deletePost(EntityManager entityManager) {

		entityManager.getTransaction().begin();

	}

	private static void createPost(EntityManager entityManager) {

		entityManager.getTransaction().begin();

		Competition footbalCompetiotion = new Competition();

		footbalCompetiotion.setCompetitionName("Fotbal Competition");
		footbalCompetiotion.setCompetitionDescription("best fotbal competition");

		Competition voleyCompetition = new Competition();

		voleyCompetition.setCompetitionName("Voley Competition");
		voleyCompetition.setCompetitionDescription("best voley competition");

		Competition tenisCompetiotion = new Competition();

		tenisCompetiotion.setCompetitionName("tenis Competition");
		tenisCompetiotion.setCompetitionDescription("best tenis competition");

		Competition swimingCompetition = new Competition();

		swimingCompetition.setCompetitionName("swiming Competition");
		swimingCompetition.setCompetitionDescription("best swiming competition");

		Set<Competition> competitionSet = new HashSet<Competition>();
		competitionSet.add(swimingCompetition);
		competitionSet.add(tenisCompetiotion);


		User user1 = new User();
		user1.setFirstName("User1");
		user1.setLastName("User1");
		user1.setPassword("pass1");

		user1.setManagedCompetitions(competitionSet);

		entityManager.persist(user1);

		entityManager.getTransaction().commit();


		entityManager.getTransaction().begin();

		Set<Competition> competitionSetUser2 = new HashSet<Competition>();
		competitionSetUser2.add(footbalCompetiotion);
		competitionSetUser2.add(voleyCompetition);

		User user2 = new User();
		user2.setFirstName("User22");
		user2.setLastName("User22");
		user2.setPassword("pass22");

		user2.setManagedCompetitions(competitionSetUser2);

//		entityManager.remove(user1);
		entityManager.persist(user2);
		entityManager.getTransaction().commit();


	}


}
