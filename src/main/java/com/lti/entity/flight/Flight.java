package com.lti.entity.flight;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String from_loc;
	private String to_loc;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private String arrive;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private String depart;
	private float base_price;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private String duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom_loc() {
		return from_loc;
	}
	public void setFrom_loc(String from_loc) {
		this.from_loc = from_loc;
	}
	public String getTo_loc() {
		return to_loc;
	}
	public void setTo_loc(String to_loc) {
		this.to_loc = to_loc;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public float getBase_price() {
		return base_price;
	}
	public void setBase_price(float base_price) {
		this.base_price = base_price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public Flight() {
		super();
	}
	public Flight(int id, String name, String from_loc, String to_loc, String arrive, String depart,
			float base_price, String duration) {
		super();
		this.id = id;
		this.name = name;
		this.from_loc = from_loc;
		this.to_loc = to_loc;
		this.arrive = arrive;
		this.depart = depart;
		this.base_price = base_price;
		this.duration = duration;
	}
	
	public Flight(String from_loc, String to_loc) {
		super();
		this.from_loc = from_loc;
		this.to_loc = to_loc;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", from_loc=" + from_loc + ", to_loc=" + to_loc + ", arrive="
				+ arrive + ", depart=" + depart + ", base_price=" + base_price + ", duration=" + duration + "]";
	}
	
	
	
	

	

}
