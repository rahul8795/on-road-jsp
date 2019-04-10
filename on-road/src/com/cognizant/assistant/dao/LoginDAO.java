package com.cognizant.assistant.dao;

import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Mechanic;

public interface LoginDAO {
	public boolean authenticate(int id, String password, String type);

	public int addLoginUser(int id, String password, String type);
}
