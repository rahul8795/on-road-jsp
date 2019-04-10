package com.cognizant.assistant.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Properties;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetGeocodeServiceImpl implements GetGeocodeService {

	private static GetGeocodeServiceImpl getGeocodeServiceImpl;
	public static GetGeocodeServiceImpl getInstance(){
		if(getGeocodeServiceImpl==null){
			getGeocodeServiceImpl = new GetGeocodeServiceImpl();
			return getGeocodeServiceImpl;
		}
		return getGeocodeServiceImpl;
	}
	private  GetGeocodeServiceImpl() {
		
	}
	@Override
	public String[] getGeocode(String area) throws IOException, JSONException {
		
		 String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=18.5971,73.7188&radius=1500&type=regions&key=AIzaSyDIT6TcATl_SOeXkPJes-8-WgmVe2zljFE",
			       proxy = "proxy.cognizant.com",
			       port = "6050";
			URL server = new URL(url);
			Properties systemProperties = System.getProperties();
			systemProperties.setProperty("http.proxyHost",proxy);
			systemProperties.setProperty("http.proxyPort",port);
			HttpURLConnection connection = (HttpURLConnection)server.openConnection();
			connection.connect();
			InputStream in = connection.getInputStream();
			 try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
			      StringBuilder sb = new StringBuilder();
			      int cp;
			      while ((cp = rd.read()) != -1) {
			        sb.append((char) cp);
			      }
			      String jsonText = sb.toString();
			      JSONObject json = new JSONObject(jsonText);
			      System.out.println(json.toString());
			 
			    }
			 catch (Exception e) {
				// TODO: handle exception
			}
			
			String [] geo = null;
			System.out.println("connected");
			return geo;
	}

}
