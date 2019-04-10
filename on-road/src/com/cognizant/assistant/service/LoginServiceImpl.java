package com.cognizant.assistant.service;

import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.dao.LoginDAO;
import com.cognizant.assistant.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private static LoginServiceImpl impl;
	private static LoginDAO dao = LoginDAOImpl.getInstance();

	public static LoginServiceImpl getInstance() {
		if (impl == null) {
			impl = new LoginServiceImpl();
			return impl;
		}
		return impl;
	}

	private LoginServiceImpl() {

	}

	@Override
	public boolean authenticate(int id, String password, String type) {
		return dao.authenticate(id, password, type);
	}

	@Override
	public int addLoginUser(int id, String password, String type) {
		return dao.addLoginUser(id, password, type);
	}

}
