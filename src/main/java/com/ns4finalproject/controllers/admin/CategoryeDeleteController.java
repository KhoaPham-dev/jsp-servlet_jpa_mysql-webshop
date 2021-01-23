package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.data.CategoryDB;


/**
 * Servlet implementation class CatagoryDeleteController
 */
//@WebServlet(urlPatterns = { "/admin/cate/delete" })
public class CategoryeDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDB.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/admin/cate/list");
	}

}
