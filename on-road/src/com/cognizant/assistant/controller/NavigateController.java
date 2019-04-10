package com.cognizant.assistant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.RequestAccept;
import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.service.CustomerService;
import com.cognizant.assistant.service.CustomerServiceImpl;
import com.cognizant.assistant.service.MechanicService;
import com.cognizant.assistant.service.MechanicServiceImpl;
import com.cognizant.assistant.service.RequestService;
import com.cognizant.assistant.service.RequestServiceImpl;


@WebServlet("/NavigateController")
public class NavigateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NavigateController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestService requestService = RequestServiceImpl.getInstance();
		
		int id = Integer.parseInt(request.getParameter("requestId"));
		
		MechanicService mechanicService =  MechanicServiceImpl.getInstance();

		Request requestDetails = new Request();
		requestDetails =  requestService.getDetails(id);
		
		RequestAccept accept = new RequestAccept();
		
		accept.setRequestId(id);
		accept.setCustomerId(requestDetails.getCustomerId());
		accept.setCustomerlatitude(requestDetails.getLatitude());
		accept.setCustomerLongiude(requestDetails.getLongitude());
		accept.setMechanicId(requestDetails.getMechanicId());
		
		double mechanicLatitude = mechanicService.getLatitude(requestDetails.getMechanicId()) ;
		double mechanicLongitude = mechanicService.getLongitude(requestDetails.getMechanicId());
		
		accept.setMechanicLatitude(mechanicLatitude);
		accept.setMechanicLongitude(mechanicLongitude);
		
		int acceptId = requestService.getAcceptId() + 1;
		
		accept.setAcceptId(acceptId);
		
		requestService.addAcceptedRequest(accept);
		
		HttpSession session = request.getSession(false); ;
		session.setAttribute("accept", accept);	
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("mechanicTrack.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
