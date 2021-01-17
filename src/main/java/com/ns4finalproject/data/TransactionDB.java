package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Product;
import com.ns4finalproject.model.Transactions;

public class TransactionDB{
	
	public static void insert(Transactions transaction) { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
	      try {
	    	  trans.begin();
	         em.persist(transaction);
	         trans.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         trans.rollback();
	      } finally {
	         em.close();
	      }
	} 
	 
	public static void delete(String id) { 		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
		String queryString = "Delete from Transaction t where t.id = :id";
		Query query = em.createQuery(queryString);
	    query.setParameter("id", String.valueOf(id));
	    int count = 0;
		try {
			trans.begin();
			count = query.executeUpdate();
			trans.commit();
			} catch (Exception e) {
				trans.rollback();
			}finally {
				em.close();
			}
	} 
	
	public static Transactions get(int id) {		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT t FROM Transaction t WHERE t.id= :id";
		TypedQuery<Transactions> query = em.createQuery(queryString, Transactions.class);
		query.setParameter("id", String.valueOf(id));
		
		Transactions transaction = null;
		try {
			transaction = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return transaction;
	}
	 
	public static void edit(Transactions transaction) { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
	      try {
	    	  trans.begin();
	         em.merge(transaction);
	         trans.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         trans.rollback();
	      } finally {
	         em.close();
	      }
	} 
	 
	public static Transactions get(String name) { 
		return null; 
	} 
  
	public static List<Transactions> getAll() { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT t FROM Transaction t";
	      Query query = em.createQuery(queryString);
	      
	      List<Transactions> transactions = null;
	      
	      try {
	    	  transactions = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return transactions;
	}
}
