package com.payment.config;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PaymentConfigTest {
	
	@InjectMocks
	PaymentConfig paymentConfig;

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		paymentConfig.postsApi();
	}

}
