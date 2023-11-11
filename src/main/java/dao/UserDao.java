package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;
import dto.User;

public class UserDao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
public void saveUser(User user) {
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
}
public User find(int id) {
	return entityManager.find(User.class, id);
}
public List<Train> fetchAllTrain() {
	return entityManager.createQuery("select x from Train x").getResultList();
}
public void update(User user) {
	entityTransaction.begin();
	entityManager.merge(user);
	entityTransaction.commit();
}

}
