package com.cognizant.assistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.RequestAccept;
import com.cognizant.assistant.bean.RequestRejected;
import com.cognizant.assistant.utils.DBUtil;

public class RequestDAOImpl  implements RequestDAO {

	private static RequestDAOImpl daoImpl;
	public static RequestDAOImpl getInstance(){
		if(daoImpl==null){
			daoImpl = new RequestDAOImpl();
			return daoImpl;
		}
		return daoImpl;
	}
	private RequestDAOImpl() {
		
	}
	@Override
	public int addRequest(Request request) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into request(requestId,customerId,customerName,contact,email,location ,latitude ,longitude ,mechanicId)"
		+" values(?,?,?,?,?,?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, request.getRequestId());
			preparedStatement.setInt(2, request.getCustomerId());
			preparedStatement.setString(3, request.getCustomerName());
			preparedStatement.setString(4, request.getContact());
			preparedStatement.setString(5, request.getEmail());
			preparedStatement.setString(6, request.getLocation());
			preparedStatement.setDouble(7, request.getLatitude());
			preparedStatement.setDouble(8, request.getLongitude());
			preparedStatement.setInt(9, request.getMechanicId());
			result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int addAcceptedRequest(RequestAccept accept) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into accept(mechanicId ,customerId ,machanicLatitude,mechanicLongitude ,customerLatitude,customerLongitude ,requestId, acceptId)"
		+" values(?,?,?,?,?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accept.getMechanicId());
			preparedStatement.setInt(2, accept.getCustomerId());
			preparedStatement.setDouble(3, accept.getMechanicLatitude());
			preparedStatement.setDouble(4, accept.getMechanicLongitude());
			preparedStatement.setDouble(5, accept.getCustomerlatitude());
			preparedStatement.setDouble(6, accept.getCustomerLongiude());
			preparedStatement.setInt(7, accept.getRequestId());
			preparedStatement.setInt(8, accept.getAcceptId());
			result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int getRequestId() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select requestId from (select requestId from request order by requestId desc) WHERE rownum <= 1";
		Request cust = null;
		int id=-1;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				 id = resultSet.getInt("requestId");

			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
		
	}
	@Override
	public int deleteRequest(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "delete request where requestId = ?";
		Request cust = null;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			int i = preparedStatement.executeUpdate();
			return i;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Request> getDetails() {
		ArrayList<Request> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select * from request";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int requestId = resultSet.getInt("requestId");
				int customerId = resultSet.getInt("customerId");
				String customerName = resultSet.getString("customerName");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				String location = resultSet.getString("location");
				double latitude = resultSet.getDouble("latitude");
				double longitude = resultSet.getDouble("longitude");
				int mechanicId = resultSet.getInt("mechanicId");
				Request custReq = new Request(customerId,customerName,contact,email,location ,latitude ,longitude ,requestId,mechanicId);
				list.add(custReq);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Request getDetails(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select * from request where requestId = ? ";
		Request cust = null;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int requestId = resultSet.getInt("requestId");
				int customerId = resultSet.getInt("customerId");
				String customerName = resultSet.getString("customerName");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				String location = resultSet.getString("location");
				double latitude = resultSet.getDouble("latitude");
				double longitude = resultSet.getDouble("longitude");
				int mechanicId = resultSet.getInt("mechanicId");
				cust = new Request(customerId,customerName,contact,email,location ,latitude ,longitude ,requestId,mechanicId);

			}
			return cust;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getAcceptId() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select acceptId from (select acceptId from accept order by acceptId desc) WHERE rownum <= 1";
		Request cust = null;
		int id=-1;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				 id = resultSet.getInt("acceptId");

			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int addRejectedRequest(RequestRejected rejected) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into reject(mechanicId ,customerId,requestId)"
		+" values(?,?,?)";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rejected.getMechanicId());
			preparedStatement.setInt(2, rejected.getCustomerId());
			preparedStatement.setInt(3, rejected.getRequestId());
			result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int getCustomerId(int reqId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select customerId from request where requestId = ? ";
		Request cust = null;
		int id = 0;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("customerId");

			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int getMechanicId(int reqId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select mechanicId from request where requestId = ? ";
		Request cust = null;
		int id = 0;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("mechanicId");

			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
