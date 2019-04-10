package com.cognizant.assistant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Rating;
import com.cognizant.assistant.service.MechanicService;
import com.cognizant.assistant.service.MechanicServiceImpl;

@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RatingServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Rating rat = new Rating();
		rat.setMechanicId(Integer.parseInt( request.getParameter("mechanicId")));
		HttpSession session = request.getSession(false);
		Customer cust = (Customer) session.getAttribute("customer");
		rat.setCustomerId(cust.getCustomerId());
		rat.setRating(Double.parseDouble(request.getParameter("rate")));
		MechanicService mechanicService = MechanicServiceImpl.getInstance();
		int result = mechanicService.addMechanicRating(rat);
		RequestDispatcher dispatcher ;
		dispatcher = request.getRequestDispatcher("request.jsp");
		dispatcher.forward(request, response);
	}

}
