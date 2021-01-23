package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.data.CategoryDB;

import com.ns4finalproject.model.Catalog;

/**
 * Servlet implementation class CategoryAddController
 */
//@WebServlet(urlPatterns = { "" })
public class CategoryAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addcate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
	    String cate_name = req.getParameter("cate-name");
		String cate_parent_id = req.getParameter("parent-id");
		Catalog category = new Catalog();
		category.setName(cate_name);
		category.setParent_id(cate_parent_id);
		CategoryDB.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
	}

}
