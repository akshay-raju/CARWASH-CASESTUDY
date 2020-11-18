package com.payment.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.payment.model.Payment;
import com.payment.service.PaymentService;

public class PaymentControllerTest {
	
	@InjectMocks
	PaymentController paymentController;
	
	@Mock
	
	 PaymentService service;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void savePaymentDetailsTest() {
		Payment payment=new Payment();
		payment.setAmount(87.56);
		payment.setCardExpireDate("cardExpireDate");
		payment.setPaymentId("paymentId");
		
		when(service.savePaymentDetails(Mockito.any())).thenReturn(payment);
		Payment result=paymentController.savePaymentDetails(payment);
		
		assertThat(result,is(notNullValue()));
	}

}
