package com.cognizant.assistant.service;

import java.util.List;

import com.cognizant.assistant.bean.Mechanic;
import com.cognizant.assistant.bean.Rating;

public interface MechanicService {
	public int addMechanicDetails(Mechanic mechanic);

	public Mechanic getMechanic(int id);

	public List<Mechanic> getMechanicDetails();
	
	public List<Rating> getMechanicSorted();
	
	public int addMechanicRating(Rating rat);
	
	public double getLatitude(int id);
	
	public double getLongitude(int id);
}
