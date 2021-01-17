package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Boardnew;

public class BoardnewDB {

	public static void insert(Boardnew boardnew) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(boardnew);
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
		String queryString = "Delete from Boardnew b where b.id = :id";
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

	public static void edit(Boardnew boardnew) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.merge(boardnew);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	public static Boardnew get(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT b FROM Boardnew b WHERE b.id= :id";
		TypedQuery<Boardnew> query = em.createQuery(queryString, Boardnew.class);
		query.setParameter("id", String.valueOf(id));
		
		Boardnew boardnew = null;
		try {
			boardnew = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return boardnew;
	}
	public static Boardnew get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Boardnew> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM Boardnew p";
	      Query query = em.createQuery(queryString);
	      
	      List<Boardnew> boardnews = null;
	      
	      try {
	    	  boardnews = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return boardnews;
	}

}
