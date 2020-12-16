package com.lti.service.flightDetails;

import java.util.List;
import com.lti.entity.flightDetails.FlightDetail;

public interface FlightDetailsService {
	public List<FlightDetail> getFlightById(int id); //returns Flight object
	public List<FlightDetail> getFlightDetailsById(int id); //returns Flight object
	public List<FlightDetail> getFlightDetailsByTicket(String ticket);
	public List<FlightDetail> getUserId(String ticket);
	public List<FlightDetail> getBookingDate(String ticket);
	public List<FlightDetail> getJourneyType(String ticket);
	public List<FlightDetail> getSeatNo(String ticket);
}
