package main;

import model.User;
import model.UserCompetition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class OneToMany2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		createUserAndCompetition(entityManager);
//		removeUser(entityManager);
//		findUser(entityManager);
//		removeCompetition(entityManager);
//		findUserCompetition(entityManager);
	}

	private static void createUserAndCompetition(EntityManager entityManager) {

		entityManager.getTransaction().begin();

		List<UserCompetition> userCompetitionUser1 = new ArrayList<>();


		User user1 = User.builder()
				.firstName("Ion")
				.lastName("Isac")
				.userCompetitions(userCompetitionUser1)
				.build();

		UserCompetition userCompetition1 = UserCompetition.builder()
				.competitionDescription("newDescriptionCompetition")
				.competitionName("newNameCompetition")
				.user(user1)
				.build();

		UserCompetition userCompetition2 = UserCompetition.builder()
				.competitionDescription("newDescriptionCompetition2")
				.competitionName("newNameCompetition2")
				.user(user1)
				.build();

		UserCompetition userCompetition3 = UserCompetition.builder()
				.competitionDescription("newDescriptionCompetition3")
				.competitionName("newNameCompetition3")
				.user(user1)
				.build();

		UserCompetition userCompetition4 = UserCompetition.builder()
				.competitionDescription("newDescriptionCompetition4")
				.competitionName("newNameCompetition4")
				.user(user1)
				.build();

		entityManager.persist(user1);
		entityManager.persist(userCompetition1);
		entityManager.persist(userCompetition2);
		entityManager.persist(userCompetition3);
		entityManager.persist(userCompetition4);

		entityManager.getTransaction().commit();

//		System.out.println("second transaction begin");
//
//		entityManager.getTransaction().begin();
//
//		List<UserCompetition> userCompetitionUser2 = new ArrayList<>();
//		userCompetitionUser2.add(UserCompetition.builder().competitionName("fotbal").competitionDescription("good").build());
//		userCompetitionUser2.add(UserCompetition.builder().competitionName("tenis").competitionDescription("good").build());
//		userCompetitionUser2.add(UserCompetition.builder().competitionName("voleyball").competitionDescription("good").build());
//
//		User user2 = User.builder().firstName("Gigel").lastName("Marcel").userCompetitions(userCompetitionUser2).build();
//		entityManager.persist(user2);
//		entityManager.getTransaction().commit();

	}

	private static void removeUser(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, 52);
		System.out.println("Remove User: " + user);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}

	private static void findUser(EntityManager entityManager) {
		User user = entityManager.find(User.class, 1);
		System.out.println("Find User: " + user);
	}

	private static void removeUserCompetition(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		UserCompetition userCompetition = entityManager.find(UserCompetition.class, 56);
		System.out.println("Remove UserCompetition :" + userCompetition);
		entityManager.remove(userCompetition);
		entityManager.getTransaction().commit();
	}

	private static void findUserCompetition(EntityManager entityManager) {
		UserCompetition userCompetition = entityManager.find(UserCompetition.class, 1);
		System.out.println("Find UserCompetition: " + userCompetition);
	}
}
