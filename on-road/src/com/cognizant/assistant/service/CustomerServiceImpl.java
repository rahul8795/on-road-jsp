package com.cognizant.assistant.service;

import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.dao.CustomerDAO;
import com.cognizant.assistant.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerServiceImpl serviceImpl;
	private static CustomerDAO customerDAO = CustomerDAOImpl.getInstance();

	public static CustomerServiceImpl getInstance() {
		if (serviceImpl == null) {
			serviceImpl = new CustomerServiceImpl();
			return serviceImpl;
		}
		return serviceImpl;
	}

	private CustomerServiceImpl() {

	}

	@Override
	public int addCustomerDetails(Customer customer) {
		return customerDAO.addCustomerDetails(customer);
	}

	@Override
	public List<Customer> getCustomerDetails() {
		return customerDAO.getCustomerDetails();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}


	@Override
	public List<Integer> getMechanicId(int custId) {
		return customerDAO.getMechanicId(custId);
	
	}


}
