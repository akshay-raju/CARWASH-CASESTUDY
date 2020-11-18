package com.service.carwashpackage.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.service.carwashpackage.model.WashPackage;
import com.service.carwashpackage.service.WashPackageService;

public class WashPackageControllerTest {
	
	@InjectMocks
	WashPackageController washPackageController;
	
	@Mock
	private WashPackageService packageService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllPackagesTest() {
		washPackageController.getAllPackages();
	}
	
	@Test
	public void savePackageTest() {
		WashPackage washPackage=new WashPackage();
		washPackage.setPackageCost(65.45);
		washPackage.setPackageDescription("packageDescription");
		washPackage.setPackageID("packageID");
		washPackage.setPackageName("packageName");
		assertNotNull(washPackage);
		 when(packageService.savePackage(Mockito.any())).thenReturn(washPackage);
		 WashPackage result=	washPackageController.savePackage(washPackage);
		assertNotNull(result);
	}
	
	@Test
	public void deletePackageTest() throws Exception {
		WashPackage washPackage=new WashPackage();
		washPackage.setPackageCost(65.45);
		washPackage.setPackageDescription("packageDescription");
		washPackage.setPackageID("packageID");
		washPackage.setPackageName("packageName");
		assertNotNull(washPackage);
		 when(packageService.deletePackage(Mockito.any())).thenReturn(true);
		 Boolean result=	washPackageController.deletePackage(washPackage);
		assertTrue(result);
	}

}
