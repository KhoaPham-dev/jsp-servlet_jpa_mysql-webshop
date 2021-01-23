package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Product;

public class ProductDB {

	public static void insert(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(product);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	
	public static void edit(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.merge(product);
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
		String queryString = "Delete from Product p where p.id = :id";
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

	public static Product get(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT p FROM Product p WHERE p.id= :id";
		TypedQuery<Product> query = em.createQuery(queryString, Product.class);
		query.setParameter("id", String.valueOf(id));
		
		Product product = null;
		try {
			product = query.getSingleResult();

		
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return product;
	}
	public static Product get(String name) {
		return null;
	}

	public static List<Product> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM Product p";
	      Query query = em.createQuery(queryString);
	      
	      List<Product> products = null;
	      
	      try {
	    	  products = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return products;
	}

	public static List<Product> getProductsByCateId(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT p FROM Product p WHERE p.catalog_id= :id";
		TypedQuery<Product> query = em.createQuery(queryString, Product.class);
		query.setParameter("id", String.valueOf(id));
		
		List<Product> products = null;
		try {
			products = query.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return products;
	}
	

	public static List<Product> searchByName(String keyword) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT p FROM Product p WHERE p.name LIKE :keyword";
		TypedQuery<Product> query = em.createQuery(queryString, Product.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Product> products = null;
		try {
			products = query.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return products;
	}

	
	

}
