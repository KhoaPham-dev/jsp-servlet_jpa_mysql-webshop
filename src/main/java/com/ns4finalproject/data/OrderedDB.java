package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ns4finalproject.model.Ordered;

public class OrderedDB{


	public static void insert(Ordered ordered) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(ordered);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}


	public static void edit(Ordered ordered) {
		// TODO Auto-generated method stub
		
	}


	public static void delete(String id) {
		// TODO Auto-generated method stub
		
	}


	public static Ordered get(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public static Ordered get(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public static List<Ordered> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT o FROM Ordered o";
	      Query query = em.createQuery(queryString);
	      
	      List<Ordered> ordereds = null;
	      
	      try {
	    	  ordereds = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return ordereds;
	}

}
