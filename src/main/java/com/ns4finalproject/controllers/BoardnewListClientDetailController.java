package com.ns4finalproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.data.BoardnewDB;
import com.ns4finalproject.model.Boardnew;

public class BoardnewListClientDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Boardnew boardnew = BoardnewDB.get(Integer.parseInt(id));
		req.setAttribute("boardnew", boardnew);
		
		List<Boardnew> boardnewList = BoardnewDB.getAll();
		req.setAttribute("boardnewlist", boardnewList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/blog-single.jsp");
		dispatcher.forward(req, resp);
	}

}
