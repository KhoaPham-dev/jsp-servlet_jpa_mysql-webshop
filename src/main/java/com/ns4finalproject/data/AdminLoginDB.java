package com.ns4finalproject.data;




import javax.persistence.EntityManager;

import javax.persistence.NoResultException;

import javax.persistence.TypedQuery;

import com.ns4finalproject.model.Admin;

public class AdminLoginDB {
	
	public static boolean checkAdminLogin(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT a FROM Admin a WHERE a.username= :username AND a.password= :password";
		TypedQuery<Admin> query = em.createQuery(queryString, Admin.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		boolean exist = false;
		Admin user = null;
		try {
			user = query.getSingleResult();
			exist = true;
		} catch (NoResultException e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return exist;
	}
	
}
