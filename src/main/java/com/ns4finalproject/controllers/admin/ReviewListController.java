package com.ns4finalproject.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns4finalproject.model.Review;
import com.ns4finalproject.data.ReviewDB;


public class ReviewListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Review> reviewList = ReviewDB.getAll();
		req.setAttribute("reviewlist", reviewList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/show-review.jsp");
		dispatcher.forward(req, resp);
	}
}
