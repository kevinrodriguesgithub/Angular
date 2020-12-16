package com.lti.service.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.flight.FlightDaoImpl;
import com.lti.entity.flight.Flight;

@Service
@Transactional
public class FlightServiceImpl {
	@Autowired
	FlightDaoImpl dao;

	public Flight addFlight(Flight fly) {
		return dao.addFlight(fly);
	}

	public List<Flight> getAllFlight() {
		return dao.getAllFlight();

	}

	public Flight deleteFlightById(int id) {
		return dao.deleteFlightByID(id);
	}
	public List<Flight> viewFlight(String from_loc, String to_loc) {
		return dao.viewFlight(from_loc, to_loc);
	}
	
	public List<Flight> searchFlight(Flight f){
		return dao.searchFlight(f);
	}
	
}
