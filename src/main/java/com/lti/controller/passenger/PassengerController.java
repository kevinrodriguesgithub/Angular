package com.lti.controller.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.passenger.Passenger;
import com.lti.service.passenger.PassengerServiceImpl;

@RestController
@RequestMapping("/passengers")
@CrossOrigin("http://localhost:4200")
public class PassengerController {

	@Autowired
	PassengerServiceImpl serviceobj;

	// Create Passenger
	@PostMapping("/createPassenger")
	public ResponseEntity<String> SetPassenger(@RequestBody Passenger p) throws Exception {
		Passenger e = serviceobj.SetPassenger(p);
		if (e == null) {
			throw new Exception("Enter valid details");
		} else {
			return new ResponseEntity<String>("Passenger created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get passenger by Id
	@GetMapping("/GetPassengerById/{id}")
	private ResponseEntity<Passenger> getPassengerById(@PathVariable("id") int id) throws Exception {
		Passenger e = serviceobj.getPassengerById(id);
		if (e == null) {
			throw new Exception("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Passenger>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get passenger by User Id
	@GetMapping("/GetPassengerByUserId/{user_id}")
	private ResponseEntity<Passenger> getPassengerByUserId(@PathVariable("user_id") int user_id) throws Exception {
		Passenger e = serviceobj.getPassengerByUserId(user_id);
		if (e == null) {
			throw new Exception("User Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Passenger>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Delete Passenger(Cancel Ticket)
	@DeleteMapping("/deletePassenger/{id}")
	private ResponseEntity<String> delPassenger(@PathVariable("id") int id) throws Exception {
		Passenger e = serviceobj.deleteById(id);
		if (e == null) {
			throw new Exception("Can't delete the passenger");
		} else {
			return new ResponseEntity<String>("Passenger deleted", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Updating Passenger data
	@PutMapping("/UpdatePassenger")
	public ResponseEntity<String> UpdatePassenger(@RequestBody Passenger p) throws Exception {
		Passenger e = serviceobj.updatePassenger(p);

		if (e == null) {
			throw new Exception("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Passenger updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

}
