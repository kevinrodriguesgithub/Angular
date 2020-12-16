package com.lti.service.flightDetails;

import java.util.List;
import com.lti.entity.flightDetails.FlightDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.flightDetails.FlightDetailsDao;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {
	
	@Autowired
	private FlightDetailsDao dao;

	@Override
	public List<FlightDetail> getFlightById(int id) {
		// TODO Auto-generated method stub
		return dao.getFlightById(id);
	}

	@Override
	public List<FlightDetail> getFlightDetailsById(int id) {
		// TODO Auto-generated method stub
		return dao.getFlightDetailsById(id);
	}

	@Override
	public List<FlightDetail> getFlightDetailsByTicket(String ticket) {
		// TODO Auto-generated method stub
		return dao.getFlightDetailsByTicket(ticket);
	}

	@Override
	public List<FlightDetail> getUserId(String ticket) {
		// TODO Auto-generated method stub
		return dao.getUserId(ticket);
	}

	@Override
	public List<FlightDetail> getBookingDate(String ticket) {
		// TODO Auto-generated method stub
		return dao.getBookingDate(ticket);
	}

	@Override
	public List<FlightDetail> getJourneyType(String ticket) {
		// TODO Auto-generated method stub
		return dao.getJourneyType(ticket);
	}

	@Override
	public List<FlightDetail> getSeatNo(String ticket) {
		// TODO Auto-generated method stub
		return dao.getSeatNo(ticket);
	}

}
