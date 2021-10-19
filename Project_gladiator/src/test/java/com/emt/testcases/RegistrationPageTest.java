package com.emt.testcases;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emt.base.Base;
import com.emt.pages.RegistrationPage;

public class RegistrationPageTest extends Base {
	
		RegistrationPage registrationPage; 

		public RegistrationPageTest() {
			super();
		}

		@BeforeMethod
		public void setup() {
			intialization();
			registrationPage = new RegistrationPage();
			
		}
		@Test(enabled=true,priority=1)
		public void registrationValidCredentialsTest() throws Exception {
			registrationPage.registrationWithValidCredentials(prop.getProperty("validphoneno"));
			assertEquals("URL not verified",prop.getProperty("url"), driver.getCurrentUrl());

		}
		@Test(priority=2)
		public void registrationInvalidCredentialsTest() throws Exception {
			registrationPage.registrationWithInalidCredentials(prop.getProperty("inavlidphno"));
			
		}
		

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	}