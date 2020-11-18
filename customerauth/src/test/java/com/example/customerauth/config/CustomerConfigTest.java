package com.example.customerauth.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CustomerConfigTest {

	
	@InjectMocks
	CustomerConfig customerConfig;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		customerConfig.postsApi();
	}

}
