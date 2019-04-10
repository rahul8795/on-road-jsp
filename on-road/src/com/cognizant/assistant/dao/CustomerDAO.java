package com.cognizant.assistant.dao;

import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Request;

public interface CustomerDAO {
	public int addCustomerDetails(Customer customer);

	public List<Customer> getCustomerDetails();

	public Customer getCustomer(int id);
	
	public List<Integer> getMechanicId(int custId);
}
