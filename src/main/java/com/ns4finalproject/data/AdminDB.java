package com.ns4finalproject.data; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Admin;
 
public class AdminDB{ 
 
	public static void insert(Admin admin) { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(admin);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	} 
 	
	public static void delete(String id) { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction trans = em.getTransaction();
		String queryString = "Delete from Admin a where a.id = :id";
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
	
	public static Admin get(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT a FROM Admin a WHERE a.id= :id";
		TypedQuery<Admin> query = em.createQuery(queryString, Admin.class);
		query.setParameter("id", String.valueOf(id));
		
		Admin admin = null;
		try {
			admin = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return admin;
	}
	public static Admin get(String name) { 
		return null; 
	} 
	
	public static void edit(Admin admin) { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.merge(admin);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	} 
	
	public static List<Admin> getAll() { 
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT a FROM Admin a";
	      Query query = em.createQuery(queryString);
	      
	      List<Admin> admins = null;
	      
	      try {
	         admins = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return admins;
		
	}
	
} 
