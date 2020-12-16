package com.lti.controller.flight;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.flight.Flight;
import com.lti.service.flight.FlightServiceImpl;

@CrossOrigin(origins= "http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("/flights")
public class FlightController {
	@Autowired
	FlightServiceImpl flightService;

	@PostMapping("/AddFlight")
	public ResponseEntity<String> addFlight(@RequestBody Flight fly) throws Exception {
		Flight f = flightService.addFlight(fly);
		if (f == null) {
			throw new Exception("Enter valid id");
		} else {
			return new ResponseEntity<String>("Flight added Successfully", new HttpHeaders(), HttpStatus.OK);
		}

	}

	@GetMapping("/GetAllFlights")
	private ResponseEntity<List<Flight>> getAllFlight() {
		List<Flight> flylist = flightService.getAllFlight();
		return new ResponseEntity<List<Flight>>(flylist, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping("/ViewFlight")
	private ResponseEntity<List<Flight>> viewFlight(@RequestBody Map<String, String> map) {
		List<Flight> f = flightService.viewFlight(map.get("from_loc"), map.get("to_loc"));

		return new ResponseEntity<List<Flight>>(f, new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/DeleteFlight/{id}")
	private ResponseEntity<String> deleteFlightById(@PathVariable("id") int id) throws Exception {
		Flight f = flightService.deleteFlightById(id);
		if (f == null) {
			throw new Exception("Delete not possible");
		} else {
			return new ResponseEntity<String>("Flight Deleted ", new HttpHeaders(), HttpStatus.OK);

		}
	}
	
	@PostMapping(value="/search",consumes="application/json")
	public List<Flight> search(@RequestBody Flight f) {
		boolean check = false;
		List<Flight> resultantFlights = flightService.searchFlight(f);
		return resultantFlights;
	}
	
}
