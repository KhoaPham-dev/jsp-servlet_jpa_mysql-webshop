package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.model.Catalog;
import com.ns4finalproject.model.Product;
import com.ns4finalproject.data.CategoryDB;


/**
 * Servlet implementation class CatagoryEditController
 */
public class CategoryEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Catalog catelist = CategoryDB.get(Integer.parseInt(id));
		req.setAttribute("catelist", catelist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editcate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		Catalog category = new Catalog();
		category.setName(req.getParameter("name"));
		category.setParent_id(req.getParameter("parent-id"));
		category.setId(req.getParameter("id"));
		CategoryDB.edit(category);
		
		resp.sendRedirect(req.getContextPath()+"/admin/cate/list");

	}
}