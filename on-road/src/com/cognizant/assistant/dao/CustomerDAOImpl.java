package com.cognizant.assistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.assistant.bean.Customer;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.utils.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {

	private static CustomerDAOImpl daoImpl;

	public static CustomerDAOImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new CustomerDAOImpl();
			return daoImpl;
		}
		return daoImpl;
	}

	private CustomerDAOImpl() {
	}

	@Override
	public int addCustomerDetails(Customer customer) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into customer (id,name,password,gender,dob,contact,email)"
				+ " values(?,?,?,?,?,?,?)";
		int result = 0;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setInt(4, customer.getGender());
			preparedStatement.setString(5, customer.getDateOfBirth());
			preparedStatement.setString(6, customer.getContact());
			preparedStatement.setString(7, customer.getEmail());

			result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			DBUtil.closeConnection(connection);
		}
		return result;
	}

	

	@Override
	public List<Customer> getCustomerDetails() {

		ArrayList<Customer> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select * from customer";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String customerName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int gender = resultSet.getInt("gender");
				String dateOfBirth = resultSet.getString("dob");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				int customerId = resultSet.getInt("id");
				Customer cust = new Customer(customerName, password, gender, dateOfBirth, contact, email, customerId);
				list.add(cust);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select * from customer where id = ? ";
		Customer cust = null;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String customerName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int gender = resultSet.getInt("gender");
				String dateOfBirth = resultSet.getString("dob");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				int customerId = resultSet.getInt("id");
				cust = new Customer(customerName, password, gender, dateOfBirth, contact, email, customerId);

			}
			return cust;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Integer> getMechanicId(int custId) {
		List<Integer> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select distinct mechanicId from request where customerId = ?";
		Request cust = null;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, custId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("mechanicId");
				list.add(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return list;
	}

}
