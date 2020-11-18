package com.service.admilogin.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdminConfigTest {
	
	AdminConfig adminConfig=new AdminConfig();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception{
		adminConfig.postsApi();
	}

}
