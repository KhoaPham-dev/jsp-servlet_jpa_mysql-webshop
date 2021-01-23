package com.ns4finalproject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ns4finalproject.model.User;

public class RegisterUserDB {

	public static boolean RegisterUser (User user)
    {
		
		boolean set = false;     
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	      try {
	         transaction.begin();
	         em.persist(user);
	         transaction.commit();
	         set = true;
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
   
        return set;  // On failure, send a message from here.
    }
}
