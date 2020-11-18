package com.service.admilogin.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.service.admilogin.model.Admin;
import com.service.admilogin.repo.AdminRepo;

public class AdminServiceMainTest {

	
	@InjectMocks
	AdminServiceMain adminServiceMain;
	
	@Mock
	 private AdminRepo adminRepo;
	
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void test() throws Exception{
		
		
		Admin admin=new Admin();
		admin.setAddress("address");
		admin.setEmailId("emailId");
		admin.setMobileNumber("mobileNumber");
		admin.setName("name");
		admin.setPassword("password");
		
		Admin result=adminServiceMain.adminLogin(admin);
		
		assertEquals(result, null);
		
		Optional<Admin> existedUser= Optional.of(admin);
		
		when(adminRepo.findById(Mockito.any())).thenReturn(existedUser);
		
		adminServiceMain.adminLogin(admin);
		
		
		

	}

//@Test	
//	public void adminLoginTest() throws Exception
//	{
//		Admin admin =new Admin();
//		
//		admin.setAddress("address");
//		admin.setEmailId("emailId");
//		
//
//		Optional<Admin> value=Optional.of(admin);
//		
//		adminServiceMain.adminLogin(admin);
//		
//		when(adminRepo.findById(Mockito.any())).thenReturn(value);
//		
//		adminServiceMain.adminLogin(admin);
//		
//		
//	}
	
	@Test
	public void signupTest() throws Exception
	{
		Admin admin=new Admin();
		admin.setAddress("address");
		admin.setEmailId("emailId");
		admin.setMobileNumber("mobileNumber");
		admin.setName("name");
		admin.setPassword("password");
		
		 Admin result=adminServiceMain.signup(admin);
			
		 assertEquals(result, null);

		
		Optional<Admin> findExisted= Optional.of(admin);
		
		when(adminRepo.findById(Mockito.any())).thenReturn(findExisted);
		
		adminServiceMain.signup(admin);
		
		
			
		
	}
}
