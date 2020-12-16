package com.lti.service.passenger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.passenger.PassengerDaoImpl;
import com.lti.entity.passenger.Passenger;

@Service
@Transactional
public class PassengerServiceImpl {

	@Autowired
	PassengerDaoImpl dao;
	
	public Passenger SetPassenger(Passenger p){
		return dao.SetPassenger(p);
	}
	
	public Passenger getPassengerById(int id){
		return dao.getPassengerById(id);
	}
	
	public Passenger getPassengerByUserId(int user_id){
		return dao.getPassengerByUserId(user_id);
	}
	
	
	public Passenger deleteById(int id){
		return dao.deleteById(id);
	}
	
	public Passenger updatePassenger(Passenger p){
		return dao.updatePassenger(p);
	}
}
