package com.lti.service.passenger;

import com.lti.entity.passenger.Passenger;

public interface PassengerService {
	Passenger SetPassenger(Passenger p);
	Passenger getPassengerById(int id);
	Passenger getPassengerByUserId(int user_id);
	
	Passenger deleteById(int id);
	Passenger updatePassenger(Passenger p);
}
