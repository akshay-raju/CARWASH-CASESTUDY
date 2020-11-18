package com.example.customerauth.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.customerauth.pojo.Car;
import com.example.customerauth.pojo.Card;
import com.example.customerauth.pojo.Customer;
import com.example.customerauth.repo.CustomerRepo;


public class CustomerServiceTest {
	
	@InjectMocks
	CustomerService customerService;
	
	@Mock
	private CustomerRepo customerRepo;
	
Customer customer = new Customer();
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		
		
		
	    ArrayList<Car> cars = new ArrayList<Car>();
	    ArrayList<Card> cards = new ArrayList<Card>();
		customer.setAddress("address");
		customer.setCards(cards);
		customer.setCars(cars);
		customer.setEmailId("emailId");
		customer.setMobileNumber("mobileNumber");
		customer.setName("name");
		customer.setPassword("password");
		
	}

	@Test
	public void signupTest() throws Exception {
		
	Customer result=	customerService.signup(customer);
		
		assertEquals(result,null);
		
		Optional<Customer> list= Optional.of(customer);
	    when(customerRepo.findById(Mockito.any())).thenReturn(list);
	   Customer value= customerService.signup(customer);
	   
		
	}

	
	@Test
	public void loginTest() throws Exception {
		
	Customer result=	customerService.login(customer);
		
		assertEquals(result,null);
		
		Optional<Customer> list= Optional.of(customer);
	    when(customerRepo.findById(Mockito.any())).thenReturn(list);
	  Customer value=  customerService.login(customer);
	    assertThat(value, is(notNullValue()));
		
	}
	
	
	@Test
	public void editProfileTest() throws Exception {
		
		Customer result=customerService.editProfile(customer);
		
		assertEquals(result,null);
		
		Optional<Customer> list= Optional.of(customer);
	    when(customerRepo.findById(Mockito.any())).thenReturn(list);
	  Customer value=  customerService.editProfile(customer);
	    
		
	}

	
	@Test
	public void getAllCustomersTest() throws Exception
	{
		List<Customer> list=new ArrayList<>();
		list.add(customer);
		when(customerRepo.findAll()).thenReturn(list);
	    List<Customer> result=	customerService.getAllCustomers();
	    assertThat(result, is(notNullValue()));
	
	}
	
	@Test
	public void deleteCustomerTest() throws Exception
	{
		
	    Customer result=	customerService.deleteCustomer(customer);
		assertEquals(result,null);
		Optional<Customer> list= Optional.of(customer);
	    when(customerRepo.findById(Mockito.any())).thenReturn(list);
		Customer value=customerService.deleteCustomer(customer);
	    assertThat(value, is(notNullValue()));
		
		
	}
	
	
	
	
}
