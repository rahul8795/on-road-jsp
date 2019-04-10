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
import com.cognizant.assistant.bean.Mechanic;

import com.cognizant.assistant.service.LoginService;
import com.cognizant.assistant.service.LoginServiceImpl;

import com.cognizant.assistant.service.MechanicService;
import com.cognizant.assistant.service.MechanicServiceImpl;

@WebServlet("/MechanicServlet")
public class MechanicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MechanicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Mechanic mechanic = new Mechanic();
		MechanicService mechanicService = MechanicServiceImpl.getInstance();
		
		mechanic.setMechanicName(request.getParameter("mechanicName"));
		
		mechanic.setPassword(request.getParameter("password"));
		
		String gender = request.getParameter("gender");
		gender = gender.toLowerCase();
		if("male".equals(gender))
			mechanic.setGender(0);
		else
			mechanic.setGender(1);
		
		String DOB = request.getParameter("dob");
		mechanic.setDateOfBirth(DOB);
		
		mechanic.setContact(request.getParameter("mechanicContact"));
		
		mechanic.setEmail(request.getParameter("mechanicEmail"));
		
		mechanic.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		
		mechanic.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		
		mechanic.setMechanicId(Integer.parseInt(request.getParameter("mechanicId")));

		int res = mechanicService.addMechanicDetails(mechanic);
		int id = Integer.parseInt(request.getParameter("mechanicId"));
		String password = request.getParameter("password");
		String type = "M";
		if(res > 0){
			LoginService loginService = LoginServiceImpl.getInstance();
			loginService.addLoginUser(id, password, type);
		}
		else{
			System.out.print("not upadated");
		}
	}

}
