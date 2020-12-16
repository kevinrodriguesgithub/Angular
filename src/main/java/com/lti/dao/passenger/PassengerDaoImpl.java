package com.lti.dao.passenger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.passenger.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao {

	@PersistenceContext
	EntityManager em;
	
	// Creating Passenger
	@Override
	public Passenger SetPassenger(Passenger p) {
		Passenger passenger = em.merge(p);
		return passenger;
	}

	@Override
	public Passenger getPassengerById(int id) {
		return em.find(Passenger.class, id);
	}

	@Override
	public Passenger getPassengerByUserId(int user_id) {
		
		Passenger passenger = em.createQuery("Select t from Passenger t where t.user_id like:user_id",Passenger.class)
				.setParameter("user_id", user_id).getSingleResult();
		return passenger;
		
	}
	
	

	@Override
	public Passenger deleteById(int id) {
		Passenger p = em.find(Passenger.class, id);
		if (p!=null) {
			em.remove(p);
		}
		return p;
	}

	@Override
	public Passenger updatePassenger(Passenger p) {
		Passenger passenger = em.find(Passenger.class, p.getId());
		if(passenger != null){
			passenger.setName(p.getName());
			passenger.setDate_of_birth(p.getDate_of_birth());
		/*	passenger.setUser_id(p.getUser_id());
			passenger.setGender(p.getGender());
			passenger.setFlight_id(p.getFlight_id());*/
			
		}
		return passenger;
	}

}
