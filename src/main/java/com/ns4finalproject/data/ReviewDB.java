package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Product;
import com.ns4finalproject.model.Review;

public class ReviewDB{

	public static void insert(Review review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(review);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}
	public static void edit(Review review) {
		// TODO Auto-generated method stub
		
	}

	public static void delete(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
		String queryString = "Delete from Review r where r.id = :id";
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

	public static Review get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Review get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Review> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT r FROM Review r";
	      Query query = em.createQuery(queryString);
	      
	      List<Review> reviews = null;
	      
	      try {
	    	  reviews = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return reviews;
	}
	
	public static List<Review> getReviewByProdId(int id)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT r FROM Review r WHERE r.product_id= :id";
	      Query query = em.createQuery(queryString);
	      query.setParameter("id", String.valueOf(id));
	      
	      List<Review> reviews = null;
	      
	      try {
	    	  reviews = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return reviews;
	}

}
