package com.service.admilogin.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service.admilogin.model.Admin;
import com.service.admilogin.service.AdminServiceMain;

public class AdminControllerTest {
	
	@InjectMocks
	AdminController adminController;
	
	@Mock
	private AdminServiceMain adminService;
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loginTest() throws Exception {
		
		
		Admin admin=new Admin();
		admin.setAddress("address");
		admin.setEmailId("emailId");
		admin.setMobileNumber("mobileNumber");
		admin.setName("name");
		admin.setPassword("password");
		
		Admin result=adminController.login(admin);
		
	    assertNotNull(admin);
		
	}

	
	@Test
	public void signUpTest() {
		
		
		Admin admin=new Admin();
		admin.setAddress("address");
		admin.setEmailId("emailId");
		admin.setMobileNumber("mobileNumber");
		admin.setName("name");
		admin.setPassword("password");
		
		adminController.signUp(admin);
		 assertNotNull(admin);
	}

}
