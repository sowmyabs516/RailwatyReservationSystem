package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;
import dto.TrainTicket;

public class TrainDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void saveTrain(Train train) {
		entityTransaction.begin();
		entityManager.persist(train);
		entityTransaction.commit();
	}
	
	public List<Train> fetchAllTrain() {
		return entityManager.createQuery("select x from Train x").getResultList();

	}

	

	public void save(TrainTicket ticket) {
		entityTransaction.begin();
		entityManager.persist(ticket);
		entityTransaction.commit();
	}

	public void update(Train train) {
		entityTransaction.begin();
		entityManager.merge(train);
		entityTransaction.commit();
		
	}

	public Train fetch(int tnumber) {
		return entityManager.find(Train.class, tnumber);
	}

	public Train fetchTrain(int tnumber) {
		return entityManager.find(Train.class, tnumber);
		
	}
}
