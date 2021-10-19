package com.emt.testcases;

import static org.junit.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emt.base.Base;
import com.emt.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new LoginPage();

	}
	@Test(enabled=true,priority=1)
	public void validateLoginpageTitleTest() {
		loginPage.validateLoginpageTitle();
		assertEquals("Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com", driver.getTitle());

	}
	@Test(enabled=true,priority=2)
	public void validateEMTLogoTest() {
		loginPage.validateEMTLogo();

	}

	@Test(enabled=true,priority=3)
	public void loginPageTest() {
		loginPage.loginWithValidCredentials(prop.getProperty("user"), prop.getProperty("pass"));

	}
	@Test(enabled=true,priority=4)
	public void invalidlogintest() {
		loginPage.loginWithInValidCredentials(prop.getProperty("invaliduser"));
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
