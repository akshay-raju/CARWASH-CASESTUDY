package com.payment.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.payment.model.Payment;
import com.payment.model.WashOrder;
import com.payment.repo.PaymentRepo;
import com.payment.repo.WashOrderRepo;

public class PaymentServiceTest {
	
	@InjectMocks
	PaymentService paymentService;
	
	@Mock
	private WashOrderRepo orderRepo;
	
	
	@Mock
	private PaymentRepo paymentRepo;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		Payment payment=new Payment();
		payment.setAmount(90.03);
		payment.setCardExpireDate("cardExpireDate");
		payment.setPaymentId("paymentId");
		
	   Payment result=	paymentService.savePaymentDetails(payment);
	   assertEquals(result,null);
		
		WashOrder washOrder=new WashOrder();
		Optional<WashOrder> order=Optional.of(washOrder);
		when(orderRepo.findById(Mockito.any())).thenReturn(order);
		when(paymentRepo.save(Mockito.any())).thenReturn(payment);
		
	   Payment value=	paymentService.savePaymentDetails(payment);
		assertThat(value,is(notNullValue()));
		
		
		
		
	}

}
