package com.lti.controller.flightDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.flightDetails.FlightDetail;
import com.lti.service.flightDetails.FlightDetailsService;

@CrossOrigin(origins= "http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("/fd")
public class FlightDetailsController {

	@Autowired
	private FlightDetailsService service;

	@GetMapping("/flight/{id}")
	public List<FlightDetail> getFlightById(@PathVariable int id) {
		return service.getFlightById(id);
	}

	@GetMapping("/fdetail/{id}")
	public List<FlightDetail> getFlightDetailsById(@PathVariable int id) {
		return service.getFlightDetailsById(id);
	}

	@GetMapping("/fdetailticket")
	public List<FlightDetail> getFlightDetailsByTicket(@RequestParam(value = "ticket") String ticket) {
		return service.getFlightDetailsByTicket(ticket);
	}

	@GetMapping("/fUid")
	public List<FlightDetail> getUserId(@RequestParam(value = "ticket") String ticket) {
		return service.getUserId(ticket);
	}

	@GetMapping("/fBookD")
	public List<FlightDetail> getBookingDate(@RequestParam(value = "ticket") String ticket) {
		return service.getBookingDate(ticket);
	}

	@GetMapping("/fJType")
	public List<FlightDetail> getJourneyType(@RequestParam(value = "ticket") String ticket) {
		return service.getJourneyType(ticket);
	}

	@GetMapping("/fSeat")
	public List<FlightDetail> getSeatNo(@RequestParam(value = "ticket") String ticket) {
		return service.getSeatNo(ticket);
	}

}
