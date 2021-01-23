package com.ns4finalproject.controllers.admin; 
 
import java.io.IOException; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import java.util.List; 
import com.ns4finalproject.model.Admin; 
import com.ns4finalproject.model.Catalog; 
import com.ns4finalproject.data.AdminDB; 

 
/** 
 * Servlet implementation class CategoryListController 
 */ 

public class AdminListController extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Admin> adminList = AdminDB.getAll(); 
		req.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp"); 
		dispatcher.forward(req, resp); 
	} 
}