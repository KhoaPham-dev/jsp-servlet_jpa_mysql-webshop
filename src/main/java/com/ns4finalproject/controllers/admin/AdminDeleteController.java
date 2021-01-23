package com.ns4finalproject.controllers.admin;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.data.AdminDB;


public class AdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	   
		String admin_id = req.getParameter("admin-id");
		AdminDB.delete(admin_id);	
		req.setAttribute("adminlist", AdminDB.getAll());   
		RequestDispatcher dispatcherUser  = req.getRequestDispatcher("/view/admin/admin.jsp");
		dispatcherUser.forward(req, resp);
	}
}

