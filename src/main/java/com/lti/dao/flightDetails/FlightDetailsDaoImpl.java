package com.lti.dao.flightDetails;

import java.util.List;
import com.lti.entity.flightDetails.FlightDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class FlightDetailsDaoImpl implements FlightDetailsDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FlightDetail> getFlightById(int id) {
		// TODO Auto-generated method stub
//		String str = "select * from flight where id=(select flight_id from flight_details where id="+id+")";
		String str = "select fd from FlightDetail fd where flight_id="+id;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight = query.getResultList();
		return flight;
	}

	@Override
	public List<FlightDetail> getFlightDetailsById(int id) {
		// TODO Auto-generated method stub
		String str = "select fd from FlightDetail fd where id="+id;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

	@Override
	public List<FlightDetail> getFlightDetailsByTicket(String ticket) {
		// TODO Auto-generated method stub
		String str = "select fd from FlightDetail fd where ticket="+ticket;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

	@Override
	public List<FlightDetail> getUserId(String ticket) {
		// TODO Auto-generated method stub
		String str = "select user_id from FlightDetail where ticket="+ticket;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

	@Override
	public List<FlightDetail> getBookingDate(String ticket) {
		// TODO Auto-generated method stub
		String str = "select booking_date from FlightDetail where ticket="+ticket;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

	@Override
	public List<FlightDetail> getJourneyType(String ticket) {
		// TODO Auto-generated method stub
		String str = "select journey_type from FlightDetail where ticket="+ticket;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

	@Override
	public List<FlightDetail> getSeatNo(String ticket) {
		// TODO Auto-generated method stub
		String str = "select seat_no from FlightDetail where ticket="+ticket;
		Query query = manager.createQuery(str);
		List<FlightDetail> flight_det = query.getResultList();
		return flight_det;
	}

}
