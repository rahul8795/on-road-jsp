package com.cognizant.assistant.service;

import java.util.List;

import com.cognizant.assistant.bean.Request;
import com.cognizant.assistant.bean.RequestAccept;
import com.cognizant.assistant.bean.RequestRejected;
import com.cognizant.assistant.dao.RequestDAO;
import com.cognizant.assistant.dao.RequestDAOImpl;

public class RequestServiceImpl implements RequestService {

	private static RequestServiceImpl requestServiceImpl;
	private static RequestDAO dao = RequestDAOImpl.getInstance();

	public static RequestServiceImpl getInstance() {
		if (requestServiceImpl == null) {
			requestServiceImpl = new RequestServiceImpl();
			return requestServiceImpl;
		}
		return requestServiceImpl;
	}

	private RequestServiceImpl() {

	}

	@Override
	public int addRequest(Request request) {
		return dao.addRequest(request);
	}

	@Override
	public int addAcceptedRequest(RequestAccept accept) {
		return dao.addAcceptedRequest(accept);
	}

	@Override
	public int getRequestId() {
		return dao.getRequestId();
	}

	@Override
	public int deleteRequest(int id) {
		return dao.deleteRequest(id);
	}

	@Override
	public List<Request> getDetails() {
		return dao.getDetails();
	}

	@Override
	public Request getDetails(int id) {
		return dao.getDetails(id);
	}

	@Override
	public int getAcceptId() {
		return dao.getAcceptId();
	}

	@Override
	public int addRejectedRequest(RequestRejected rejected) {
		return dao.addRejectedRequest(rejected);
	}

	@Override
	public int getCustomerId(int reqId) {
		return dao.getCustomerId(reqId);
	}

	@Override
	public int getMechanicId(int reqId) {
		return dao.getMechanicId(reqId);
	}


}
