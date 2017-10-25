package com.jpaBatch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrderUnit");
	//private  EntityManager em= emf.createEntityManager();
	int batchSize = 10000;
	int i=0;
/*	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("OrderUnit");
		em = emf.createEntityManager();
    JpaDAO dao = new JpaDAO();
		dao.createOrder(3, "IRNR", "AEDD", "22",500);
		dao.createOrder(4, "INRR", "USSD", "23",600);

	}*/

	public  void createOrder(List<Order> orders) {
		  EntityManager em= emf.createEntityManager();
		  em.getTransaction().begin();
			int i=0;
			for(Order o:orders)
			{
				i++;
			Order order = (Order)o;
			em.persist(order);
			if(i> 0 && i % batchSize ==0) 
			{
				 em.flush();em.clear();
				 em.getTransaction().commit();
				 em.getTransaction().begin();
			}
			}
			em.getTransaction().commit();
			em.close();
		}
}
