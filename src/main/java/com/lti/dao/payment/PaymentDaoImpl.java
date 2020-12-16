package com.lti.dao.payment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.payment.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@PersistenceContext
	private EntityManager manager; 
	
	
	@Override
	public Payment generatePayment(Payment p) {
		// TODO Auto-generated method stub
		/*LocalDate ld = LocalDate.now();
		String sql = "insert into payment(id, user_id, flight_id, payment_mode, date_of_payment, amount) values (1, 1, 1, 'Debit Card', "+ld+", 5000)";
		Query query = manager.createQuery(sql);
		int res = query.executeUpdate();*/
		Payment p1 = manager.merge(p);
		System.out.println(p1);
		return p1;
		/*Query query = manager.createNativeQuery("INSERT INTO payment (id, user_id, flight_id, payment_mode, date_of_payment, amount) VALUES (:id, :user_id, :flight_id, :payment_mode, :date_of_payment, :amount);");
		query.setParameter("id", p.getId());
		query.setParameter("user_id", p.getUser_id());
		query.setParameter("flight_id", p.getFlight_id());
		query.setParameter("payment_mode", p.getPayment_mode());
		query.setParameter("date_of_payment", p.getDate_of_payment());
		query.setParameter("amount", p.getAmount());
		query.executeUpdate();
		return p;*/

	}

}
