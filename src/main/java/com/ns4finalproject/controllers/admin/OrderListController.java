package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.model.Transactions;
import com.ns4finalproject.data.TransactionDB;


/**
 * Servlet implementation class OrderListController
 */

public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Transactions> transactionList = TransactionDB.getAll(); 
		req.setAttribute("order", transactionList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-order.jsp"); 
		dispatcher.forward(req, resp); 
	} 

}
