package com.cognizant.assistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.utils.DBUtil;

public class LoginDAOImpl implements LoginDAO {

	private static LoginDAOImpl daoImpl;

	public static LoginDAOImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new LoginDAOImpl();
			return daoImpl;
		}
		return daoImpl;
	}

	private LoginDAOImpl() {

	}

	@Override
	public boolean authenticate(int id, String password, String type) {
		String query = "select * from login where id=? and password=? and type=?";
		boolean status = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, type);
			resultSet = preparedStatement.executeQuery();
			status = resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int addLoginUser(int id, String password, String type) {
		int result = 0;
		String query = "insert into login(id,password,type) values (?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, type);
			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
