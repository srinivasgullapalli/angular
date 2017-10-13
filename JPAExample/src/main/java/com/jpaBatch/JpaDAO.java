package com.jpaBatch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrderUnit");
	private  EntityManager em= emf.createEntityManager();
	int entityCount = 100000;
	int batchSize = 100;
	int i=0;
/*	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("OrderUnit");
		em = emf.createEntityManager();
    JpaDAO dao = new JpaDAO();
		dao.createOrder(3, "IRNR", "AEDD", "22",500);
		dao.createOrder(4, "INRR", "USSD", "23",600);

	}*/

	public  void createOrder(int id, String orderingCurrency,
			String toCurrency, String timeStamp,Integer dealAmount) {
		em.getTransaction().begin();
		Order order = new Order(id, orderingCurrency, toCurrency, timeStamp,dealAmount);
		em.persist(order);
		 em.flush();
		//em.getTransaction().commit();
/*	    for ( int i = 0; i < entityCount; ++i ) {
	        if ( i > 0 && i % batchSize == 0 ) {
	            em.flush();
	            em.clear();
	 
	            em.getTransaction().commit();
	            em.getTransaction().begin();
	        }
	 
	        Order order = new Order(id, orderingCurrency, toCurrency, timeStamp,dealAmount);
	        em.persist( order);
	        order=null;
	    }*/
	 
	    em.getTransaction().commit();
	}
}
