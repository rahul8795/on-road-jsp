package com.cognizant.assistant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.RequestRejected;
import com.cognizant.assistant.service.CustomerService;
import com.cognizant.assistant.service.CustomerServiceImpl;
import com.cognizant.assistant.service.RequestService;
import com.cognizant.assistant.service.RequestServiceImpl;


@WebServlet("/DeleteRequestController")
public class DeleteRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteRequestController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//deleting from the request table using request id
		RequestService requestService = RequestServiceImpl.getInstance();
		int requestId = Integer.parseInt(request.getParameter("rId"));
		RequestRejected rejected = new RequestRejected();
		rejected.setCustomerId(requestService.getCustomerId(requestId));
		rejected.setMechanicId(requestService.getMechanicId(requestId));
		rejected.setRequestId(requestId);
		int re = requestService.addRejectedRequest(rejected);
		
		int result = requestService.deleteRequest(requestId);
		
		
		
		//updating the available request after rejection request
		HttpSession session = request.getSession(false);
		List<Request> customerRequest = requestService.getDetails();
		session.setAttribute("customerRequest",customerRequest);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mechanic.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
