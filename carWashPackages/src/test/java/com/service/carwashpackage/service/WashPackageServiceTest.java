package com.service.carwashpackage.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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

import com.service.carwashpackage.model.WashPackage;
import com.service.carwashpackage.repo.WashPackageRepo;

public class WashPackageServiceTest {

	@InjectMocks
	WashPackageService washPackageService;

	@Mock
	private WashPackageRepo packageRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllPackagesTest() throws Exception {

		List<WashPackage> list = new ArrayList<>();
		WashPackage washPackage = new WashPackage();
		washPackage.setPackageCost(23.43);
		washPackage.setPackageDescription("packageDescription");
		washPackage.setPackageID("packageID");
		washPackage.setPackageName("packageName");
		list.add(washPackage);

		when(packageRepo.findAll()).thenReturn(list);
		List<WashPackage> result = washPackageService.getAllPackages();

		assertThat(result, is(notNullValue()));

	}

	@Test
	public void savePackageTest() throws Exception {
		WashPackage washPackage = new WashPackage();
		washPackage.setPackageCost(23.43);
		washPackage.setPackageDescription("packageDescription");
		washPackage.setPackageID("packageID");
		washPackage.setPackageName("packageName");

		when(packageRepo.save(Mockito.any())).thenReturn(washPackage);
		WashPackage result = washPackageService.savePackage(washPackage);
		assertThat(result, is(notNullValue()));
	}

	@Test
	public void deletePackageTest() throws Exception {

		WashPackage washPackage = new WashPackage();
		washPackage.setPackageID("packageID");
		Boolean result = washPackageService.deletePackage(washPackage);

		assertFalse(result);

		Optional<WashPackage> list = Optional.of(washPackage);
		when(packageRepo.findById(Mockito.any())).thenReturn(list);
		Boolean value = washPackageService.deletePackage(washPackage);

		assertTrue(value);
	}

}
