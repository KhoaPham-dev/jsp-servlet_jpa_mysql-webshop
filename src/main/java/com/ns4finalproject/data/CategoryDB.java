package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Admin;
import com.ns4finalproject.model.Catalog;

public class CategoryDB {

	public static void insert(Catalog category) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(category);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	public static void edit(Catalog category) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.merge(category);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
		
	}

	public static Catalog get(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT c FROM Catalog c WHERE c.id= :id";
		TypedQuery<Catalog> query = em.createQuery(queryString, Catalog.class);
		query.setParameter("id", String.valueOf(id));
		
		Catalog catalog = null;
		try {
			catalog = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return catalog;
	}
	public static Catalog get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Catalog> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT c FROM Catalog c";
	      Query query = em.createQuery(queryString);
	      
	      List<Catalog> catalogs = null;
	      
	      try {
	    	  catalogs = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return catalogs;
	}

	public static void delete(String id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
		String queryString = "Delete from Catalog c where c.id = :id";
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
	
	public static List<Catalog> getCateByProduct(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT c FROM Catalog c, Product p WHERE c.id = p.catalog_id and p.id= :id";
		TypedQuery<Catalog> query = em.createQuery(queryString, Catalog.class);
		query.setParameter("id", String.valueOf(id));
		
		List<Catalog> catalogs = null;
		try {
			catalogs = query.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return catalogs;
	}
	
}
