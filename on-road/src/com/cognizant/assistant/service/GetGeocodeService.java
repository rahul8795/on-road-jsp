package com.cognizant.assistant.service;

import java.io.IOException;

import java.text.ParseException;

import org.json.JSONException;

public interface GetGeocodeService {
	public String[] getGeocode(String area)throws IOException, JSONException;
}
