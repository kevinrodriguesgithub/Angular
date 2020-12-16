package com.lti.dao.flight;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.flight.Flight;

@Repository
@SuppressWarnings("unchecked")
public class FlightDaoImpl implements FlightDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Flight addFlight(Flight fly) {
		Flight f = em.merge(fly);

		return f;
	}

	
	@Override
	public List<Flight> getAllFlight() {
		Query q = em.createQuery("select flights from Flight flights ");
		List<Flight> flylist = q.getResultList();
		return flylist;

	}

	@Override
	public Flight deleteFlightByID(int id) {
		Flight f = em.find(Flight.class, id);
		if (f != null) {
			em.remove(f);
		}
		return f;
	}

	@Override
	public List<Flight> viewFlight(String from_loc, String to_loc) {

		return em.createQuery(
				"SELECT flights FROM Flight flights WHERE flights.from_loc LIKE :from_loc and flights.to_loc LIKE:to_loc")

				.setParameter("from_loc", from_loc).setParameter("to_loc", to_loc)

				.setMaxResults(10).getResultList();
	}

	public List<Flight> searchFlight(Flight f){

		String from=f.getFrom_loc();
		String to=f.getTo_loc();
		Flight fl;
		System.out.println("e-from:"+from);
		System.out.println("to-"+to);
		try{
		String sql = "select u from Flight u where from_loc ='"+from+"' and to_loc='"+to+"'";
		
		boolean check = false;
		
		Query query = em.createQuery(sql);
		List<Flight> usr = query.getResultList();
		if(usr!=null || !usr.isEmpty()){
			String fromLoc = usr.get(0).getFrom_loc();
			String toLoc = usr.get(0).getTo_loc();
			System.out.println("db fromLoc:"+fromLoc);
			System.out.println("db toLoc:"+toLoc);
			fl = usr.get(0);
			System.out.println(usr);
		}
		else{
			System.out.println("no flights for specified locations"); //checking reachability
		}
		return usr;
		
		
	}
		catch(Exception e1){
			System.out.println("Invalid locations");
		}
		return null;
	}
}
