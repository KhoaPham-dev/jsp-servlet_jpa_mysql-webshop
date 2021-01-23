package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Product;
import com.ns4finalproject.model.User;

public class UserDB{
	
	public static void insert(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(user);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	public static void delete(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
		String queryString = "Delete from User u where u.id = :id";
		Query query = em.createQuery(queryString);
	    query.setParameter("id", id);
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
	
	public static User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static User get(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT u FROM User u WHERE u.id= :id";
		TypedQuery<User> query = em.createQuery(queryString, User.class);
		query.setParameter("id", id);
		
		User user = null;
		try {
			user = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return user;
	}
	
	public static void edit(User user) {	
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.merge(user);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
		
	}
	
	public static List<User> getAll() {		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT u FROM User u";
	      Query query = em.createQuery(queryString);
	      
	      List<User> users = null;
	      
	      try {
	    	  users = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return users;
	}

}


