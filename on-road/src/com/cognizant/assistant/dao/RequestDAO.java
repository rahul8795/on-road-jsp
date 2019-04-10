package com.cognizant.assistant.dao;

import java.util.List;

import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.RequestAccept;
import com.cognizant.assistant.bean.RequestRejected;

public interface RequestDAO {
	public int addRequest(Request request);

	public int getRequestId();

	public int deleteRequest(int id);

	public List<Request> getDetails();

	public Request getDetails(int id);

	public int addAcceptedRequest(RequestAccept accept);

	public int getAcceptId();

	public int addRejectedRequest(RequestRejected rejected);
	
	public int getCustomerId(int reqId);
	
	public int getMechanicId(int reqId);
}
