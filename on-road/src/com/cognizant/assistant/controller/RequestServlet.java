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
import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.service.CustomerService;
import com.cognizant.assistant.service.CustomerServiceImpl;
import com.cognizant.assistant.service.RequestService;
import com.cognizant.assistant.service.RequestServiceImpl;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RequestServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession(false);
		
		int mechId = (int) session.getAttribute("mechid");
		
		Request requestM = new Request();
		
		CustomerService customerService = CustomerServiceImpl.getInstance();
		
		RequestService requestService = RequestServiceImpl.getInstance();
		
		Customer cust = (Customer) session.getAttribute("customer");
		
		requestM.setCustomerName(cust.getCustomerName());
		requestM.setCustomerId(cust.getCustomerId());
		requestM.setContact(cust.getContact());
		requestM.setEmail(cust.getEmail());
		requestM.setMechanicId(mechId);
		requestM.setLocation(request.getParameter("location"));
		requestM.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		requestM.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		requestM.setRequestId(requestService.getRequestId()+1);
		
		int result =requestService.addRequest(requestM);
		
		
		if(result > 0){
			List<Integer> mechanicIdList = new   ArrayList<>() ;
			mechanicIdList = customerService.getMechanicId(cust.getCustomerId());
			System.out.println("gdfg"+cust.getCustomerId());
			session.setAttribute("mechanicIdList", mechanicIdList);
			dispatcher = request.getRequestDispatcher("request.jsp");
			dispatcher.forward(request, response);
		}
	}

}
