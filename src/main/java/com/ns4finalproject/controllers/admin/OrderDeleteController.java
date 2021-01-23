package com.ns4finalproject.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.data.TransactionDB;



public class OrderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		TransactionDB.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/order/list");
	}
}
