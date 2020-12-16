package com.lti.entity.flightDetails;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_detail")
public class FlightDetail {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ticket")
	private String ticket;
	
	@Column(name="flight_id")
	private int flight_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="booking_date")
	private Date booking_date;
	
	@Column(name="journey_type")
	private String journey_type;
	
	@Column(name="seat_no")
	private String seat_no;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public String getJourney_type() {
		return journey_type;
	}
	public void setJourney_type(String journey_type) {
		this.journey_type = journey_type;
	}
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	@Override
	public String toString() {
		return "FlightDetails [id=" + id + ", ticket=" + ticket + ", flight_id=" + flight_id + ", user_id=" + user_id
				+ ", booking_date=" + booking_date + ", journey_type=" + journey_type + ", seat_no=" + seat_no + "]";
	}
	public FlightDetail(int id, String ticket, int flight_id, int user_id, Date booking_date, String journey_type,
			String seat_no) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.flight_id = flight_id;
		this.user_id = user_id;
		this.booking_date = booking_date;
		this.journey_type = journey_type;
		this.seat_no = seat_no;
	}
	
	public FlightDetail() {
		// TODO Auto-generated constructor stub
	}
	
}
