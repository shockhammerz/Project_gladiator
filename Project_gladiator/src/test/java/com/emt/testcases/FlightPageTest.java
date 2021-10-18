package com.emt.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emt.base.Base;
import com.emt.pages.FlightPage;

public class FlightPageTest extends Base {

	FlightPage flightPage;

	public FlightPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		flightPage = new FlightPage();

	}

	@Test(priority = 1)
	public void flightPageTest() throws Exception {
		flightPage.searchFlights(prop.getProperty("fromcity"), prop.getProperty("tocity"),
				prop.getProperty("departuredate"), prop.getProperty("returndate"));
		flightPage.flightlist();
		flightPage.MoreFareOption();
		flightPage.Review(prop.getProperty("user"));
		flightPage.Travellers(prop.getProperty("phno"),prop.getProperty("firstname"),
				prop.getProperty("lastname"),prop.getProperty("title"));
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}