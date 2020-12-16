package com.lti.service.payment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.payment.PaymentDao;
import com.lti.entity.payment.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao dao;
	
	@Override
	@Transactional
	public Payment generatePayment(Payment p) {
		// TODO Auto-generated method stub
		Payment p1 = dao.generatePayment(p);
		return p1;
	}

}
