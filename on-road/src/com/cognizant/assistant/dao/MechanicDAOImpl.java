package com.cognizant.assistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Rating;
import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.utils.DBUtil;

public class MechanicDAOImpl implements MechanicDAO {

	private static MechanicDAOImpl daoImpl;

	public static MechanicDAOImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new MechanicDAOImpl();
			return daoImpl;
		}
		return daoImpl;
	}

	private MechanicDAOImpl() {

	}

	// Adding the mechanic details into the database
	@Override
	public int addMechanicDetails(Mechanic mechanic) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into mechanic (id,name,password,gender,dob,contact,email,latitude,longitude)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		int result = 0;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, mechanic.getMechanicId());
			preparedStatement.setString(2, mechanic.getMechanicName());
			preparedStatement.setString(3, mechanic.getPassword());
			preparedStatement.setInt(4, mechanic.getGender());
			preparedStatement.setString(5, mechanic.getDateOfBirth());
			preparedStatement.setString(6, mechanic.getContact());
			preparedStatement.setString(7, mechanic.getEmail());
			preparedStatement.setDouble(8, mechanic.getLatitude());
			preparedStatement.setDouble(9, mechanic.getLongitude());
			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	// Fetching individual mechanic information by mechanicId from the database
	@Override
	public Mechanic getMechanic(int id) {

		Mechanic mechanic = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select *from mechanic where id = ?";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String mechanicName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int gender = resultSet.getInt("gender");
				String dateOfBirth = resultSet.getString("dob");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				double latitude = resultSet.getDouble("latitude");
				double longitude = resultSet.getDouble("longitude");
				int mechanicId = resultSet.getInt("id");
				mechanic = new Mechanic(mechanicName, password, gender, dateOfBirth, contact, email, latitude,
						longitude, mechanicId);

			}
			return mechanic;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Fetching all mechanic information
	@Override
	public List<Mechanic> getMechanicDetails() {
		ArrayList<Mechanic> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select *from mechanic";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String mechanicName = resultSet.getString("name");
				String password = resultSet.getString("password");
				int gender = resultSet.getInt("gender");
				String dateOfBirth = resultSet.getString("dob");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				double latitude = resultSet.getInt("latitude");
				double longitude = resultSet.getInt("longitude");
				int mechanicId = resultSet.getInt("id");
				Mechanic mech = new Mechanic(mechanicName, password, gender, dateOfBirth, contact, email, latitude,
						longitude, mechanicId);
				list.add(mech);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Fetching all data from rating table into sorted order
	@Override
	public List<Rating> getMechanicSorted() {

		ArrayList<Rating> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select *from rating order by rating desc";
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int mechanicId = resultSet.getInt("mechanicId");
				int customerId = resultSet.getInt("customerId");
				double rating = resultSet.getDouble("rating");
				Rating rate = new Rating(mechanicId, customerId, rating);
				list.add(rate);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Adding rating of mechanic given by customer
	@Override
	public int addMechanicRating(Rating rat) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "insert into rating (mechanicId,customerId,rating)" + "values(?,?,?)";
		connection = DBUtil.getConnection();
		int result = 0;
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, rat.getMechanicId());
			preparedStatement.setInt(2, rat.getMechanicId());
			preparedStatement.setDouble(3, rat.getRating());
			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public double getLatitude(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select latitude from mechanic where id = ?";
		Request cust = null;
		double lat = 0 ;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				 lat = resultSet.getDouble("latitude");

			}
			return lat;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lat;
	}

	@Override
	public double getLongitude(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertStatement = "select longitude from mechanic where id = ?";
		Request cust = null;
		double lng = 0;
		connection = DBUtil.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				 lng = resultSet.getDouble("longitude");

			}
			return lng;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lng;
	}

}
