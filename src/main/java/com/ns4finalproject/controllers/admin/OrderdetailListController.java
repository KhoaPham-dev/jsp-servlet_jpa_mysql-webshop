package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.model.Ordered;
import com.ns4finalproject.model.Product;
import com.ns4finalproject.data.OrderedDB;
import com.ns4finalproject.data.ProductDB;



public class OrderdetailListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Ordered> orderedList = OrderedDB.getAll(); 
		req.setAttribute("orderedlist", orderedList);
		List<Product> products = new ArrayList<Product>();
		for(Ordered ordered: orderedList)
		{
			Product product = new Product();
			product = ProductDB.get(Integer.parseInt(ordered.getProduct_id()));
			products.add(product);
		}
		req.setAttribute("products", products);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-orderdetail.jsp"); 
		dispatcher.forward(req, resp); 
	}
}
