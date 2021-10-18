package com.emt.testcases;

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

	@Test
	public void loginPageTest() {
		loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));

	}
	@Test
	public void invalidlogintest() {
		loginPage.invalidlogin(prop.getProperty("invaliduser"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
