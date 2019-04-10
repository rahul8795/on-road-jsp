package com.cognizant.assistant.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.service.CustomerService;
import com.cognizant.assistant.service.CustomerServiceImpl;
import com.cognizant.assistant.service.LoginService;
import com.cognizant.assistant.service.LoginServiceImpl;



@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Customer customer = new Customer();
		CustomerService customerService = CustomerServiceImpl.getInstance();
		
		customer.setCustomerName(request.getParameter("customerName"));
		
		customer.setPassword(request.getParameter("password"));
		
		String gender = request.getParameter("gender");
		gender = gender.toLowerCase();
		if("male".equals(gender)){
			customer.setGender(0);
		}
		else{
			customer.setGender(1);
		}
		
		String DOB = request.getParameter("dob");
		customer.setDateOfBirth(DOB);
		
		customer.setContact(request.getParameter("customerContact"));
		
		customer.setEmail(request.getParameter("customerEmail"));
		
		int id = Integer.parseInt(request.getParameter("customerId"));
		customer.setCustomerId(id);
		String type = "C";
		String password = request.getParameter("password");
		int result = customerService.addCustomerDetails(customer);
		if(result > 0){
			LoginService loginService = LoginServiceImpl.getInstance();
			loginService.addLoginUser(id, password, type);
			System.out.print("Record upadated");
		}
	}

}
