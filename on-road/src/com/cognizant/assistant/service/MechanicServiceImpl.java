package com.cognizant.assistant.service;

import java.util.List;

import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Rating;
import com.cognizant.assistant.dao.MechanicDAO;
import com.cognizant.assistant.dao.MechanicDAOImpl;

public class MechanicServiceImpl implements MechanicService {

	private static MechanicServiceImpl serviceImpl;
	private static MechanicDAO dao = MechanicDAOImpl.getInstance();

	public static MechanicServiceImpl getInstance() {
		if (serviceImpl == null) {
			serviceImpl = new MechanicServiceImpl();
			return serviceImpl;
		}
		return serviceImpl;
	}

	private MechanicServiceImpl() {

	}

	// Adding the mechanic details into the database
	@Override
	public int addMechanicDetails(Mechanic mechanic) {

		return dao.addMechanicDetails(mechanic);
	}

	// Fetching individual mechanic information by mechanicId from the database
	@Override
	public Mechanic getMechanic(int id) {

		return dao.getMechanic(id);
	}

	// Fetching all mechanic information
	@Override
	public List<Mechanic> getMechanicDetails() {

		return dao.getMechanicDetails();
	}

	// Fetching all data from rating table into sorted order
	@Override
	public List<Rating> getMechanicSorted() {

		return dao.getMechanicSorted();
	}

	// Adding rating of mechanic given by customer
	@Override
	public int addMechanicRating(Rating rat) {
		return dao.addMechanicRating(rat);
	}

	@Override
	public double getLatitude(int id) {
		return dao.getLatitude(id);
	}

	@Override
	public double getLongitude(int id) {
		return dao.getLongitude(id);
	}

}
