package com.lti.entity.payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int user_id;
	private int flight_id;
	private String payment_mode;
	private String date_of_payment;
	private float amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getDate_of_payment() {
		return date_of_payment;
	}
	public void setDate_of_payment(String date_of_payment) {
		this.date_of_payment = date_of_payment;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", user_id=" + user_id + ", flight_id=" + flight_id + ", payment_mode="
				+ payment_mode + ", date_of_payment=" + date_of_payment + ", amount=" + amount + "]";
	}
	public Payment(int id, int user_id, int flight_id, String payment_mode, String date_of_payment, float amount) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.flight_id = flight_id;
		this.payment_mode = payment_mode;
		this.date_of_payment = date_of_payment;
		this.amount = amount;
	}
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
}
