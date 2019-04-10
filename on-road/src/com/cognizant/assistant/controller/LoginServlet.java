package com.cognizant.assistant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Rating;
import com.cognizant.assistant.service.CustomerService;
import com.cognizant.assistant.service.CustomerServiceImpl;
import com.cognizant.assistant.service.LoginService;
import com.cognizant.assistant.service.LoginServiceImpl;
import com.cognizant.assistant.service.MechanicService;
import com.cognizant.assistant.service.MechanicServiceImpl;
import com.cognizant.assistant.service.RequestService;
import com.cognizant.assistant.service.RequestServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = null;
		RequestDispatcher dispatcher = null;

		// Creating variable which hold the value from page
		int id = Integer.parseInt(request.getParameter("userId"));
		String pass = request.getParameter("userPassword");
		String type = request.getParameter("type");

		LoginService loginService = LoginServiceImpl.getInstance();
		CustomerService customerService = CustomerServiceImpl.getInstance();
		MechanicService mechanicService = MechanicServiceImpl.getInstance();
		RequestService requestService = RequestServiceImpl.getInstance();
		session = request.getSession();
		if ("C".equals(type)) {
			if (loginService.authenticate(id, pass, type)) {
				
				//taking individual data of customer
				Customer customer = customerService.getCustomer(id);
				session.setAttribute("customer", customer);
				
				// taking all data of mechanic
				ArrayList<Mechanic> mechanicList = new   ArrayList<Mechanic>() ;
				List<Rating> mechanicRate = mechanicService.getMechanicSorted();
				for(Rating rate : mechanicRate){
					int mechId = rate.getMechanicId();
					Mechanic m = mechanicService.getMechanic(mechId);
					mechanicList.add(m);
				}
				
				session.setAttribute("mechanicList", mechanicList);
				
				List<Integer> mechanicIdList = new   ArrayList<>() ;
				mechanicIdList = customerService.getMechanicId(id);
				session.setAttribute("mechanicIdList", mechanicIdList);
			
				dispatcher = request.getRequestDispatcher("request.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} else if ("M".equals(type)) {
			if (loginService.authenticate(id, pass, type)) {
				// taking individual data of mechanic
				Mechanic mechanic = mechanicService.getMechanic(id);
				session.setAttribute("mechanic", mechanic);
				
				// taking all data of customerRequest
				List<Request> customerRequest = requestService.getDetails();
				session.setAttribute("customerRequest",customerRequest);
				
				dispatcher = request.getRequestDispatcher("mechanic.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
