package com.emt.testcases;

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
		@Test(priority=2)
		public void registrationPageTest() throws Exception {
			registrationPage.register(prop.getProperty("newuser"),prop.getProperty("otp"));

		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	}