package com.ns4finalproject.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import com.ns4finalproject.model.Catalog;
import com.ns4finalproject.data.CategoryDB;


/**
 * Servlet implementation class CategoryListController
 */

public class CategoryListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Catalog> cateList = CategoryDB.getAll();
		req.setAttribute("catelist", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-cate.jsp");
		dispatcher.forward(req, resp);
	}

}