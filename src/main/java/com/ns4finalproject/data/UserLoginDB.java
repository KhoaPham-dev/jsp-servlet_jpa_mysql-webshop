package com.ns4finalproject.data;




import javax.persistence.EntityManager;

import javax.persistence.NoResultException;

import javax.persistence.TypedQuery;

import com.ns4finalproject.model.User;

public class UserLoginDB {
	
	public static User checkLogin(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryString = "SELECT u FROM User u WHERE u.username= :username AND u.password= :password";
		TypedQuery<User> query = em.createQuery(queryString, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
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
	
}
