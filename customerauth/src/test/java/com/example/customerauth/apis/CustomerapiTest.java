package com.example.customerauth.apis;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.customerauth.pojo.Car;
import com.example.customerauth.pojo.Card;
import com.example.customerauth.pojo.Customer;
import com.example.customerauth.service.CustomerService;

public class CustomerapiTest {

	@InjectMocks
	Customerapi customerapi;

	@Mock
	private CustomerService customerService;

	Customer customer = new Customer();

	@Before
	public void setUp() throws Exception {
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
	public void signUpTest() throws Exception {

		when(customerService.signup(Mockito.any())).thenReturn(customer);
		Customer result = customerapi.signup(customer);

		assertThat(result, is(notNullValue()));

	}

	@Test
	public void loginTest() throws Exception {

		when(customerService.login(Mockito.any())).thenReturn(customer);
		Customer result = customerapi.login(customer);

		assertThat(result, is(notNullValue()));

	}

	
	@Test
	public void deleteCarTest() throws Exception {
		
		Car car=new Car();
		when(customerService.deleteCar(Mockito.any())).thenReturn(customer);
		Customer result	=customerapi.deleteCar(car);
		assertThat(result, is(notNullValue()));
	}
	
	
	@Test
	public void updateProfileTest() throws Exception {
	 when(customerService.editProfile(Mockito.any())).thenReturn(customer);
		Customer result	=customerapi.updateProfile(customer);
		assertThat(result, is(notNullValue()));
}
	
	@Test
	public void getAllCustomersTest() throws Exception {
		
		List<Customer> result	=customerapi.getAllCustomers();
		assertThat(result, is(notNullValue()));
}
		
	
	@Test
	public void deleteCustomerTest() throws Exception {
		
		Customer result	=customerapi.deleteCustomer(customer);
		assertEquals(result, null);
}
		
		
	}

