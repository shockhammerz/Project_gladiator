package com.emt.pages;

import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.emt.base.Base;

public class FlightPage extends Base {
	
	//PageFactory
	@CacheLookup
	@FindBy(xpath="//a[contains(.,'Flights')]") WebElement Flights;
	@CacheLookup
	@FindBy(xpath="//li[contains(.,'One-Way')]") WebElement Oneway;
	@CacheLookup
	@FindBy(id="FromSector_show") WebElement From;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"fromautoFill\"]/div[2]/div/ul/li[1]") WebElement Fromdropdown;
	@CacheLookup
	@FindBy(id="Editbox13_show") WebElement To;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"toautoFill\"]/div/div/ul/li[2]") WebElement Todropdown;	
	@CacheLookup
	@FindBy(id="ddate") WebElement DepDate;
	@CacheLookup
	@FindBy(id="fiv_2_26/10/2021") WebElement DDate;
	@CacheLookup
	@FindBy(id="rdate") WebElement RetDate;
	@CacheLookup
	@FindBy(id="trd_3_17/11/2021") WebElement RDate;
	@CacheLookup
	@FindBy(className="src_btn") WebElement Srchbtn;
	@CacheLookup
	@FindBy(id="BtnBookNow") WebElement Booknowbtn;
	@CacheLookup
	@FindBy(className="countnbtn") WebElement ContinueBtn;
	@CacheLookup
	@FindBy(id="spnVerifyEmail") WebElement ContinuebookingBtn;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"chkInsurance\"]") WebElement Insuranceclick;
	@CacheLookup
	@FindBy(id="txtEmailId") WebElement EnterValidEmail;
	@CacheLookup
	@FindBy(id="txtCPhone") WebElement EnterValidPhoneNo;
	@CacheLookup
	@FindBy(id="titleAdult0") WebElement Dropdowntitle;
	@CacheLookup
	@FindBy(id="txtFNAdult0") WebElement Firstname;
	@CacheLookup
	@FindBy(id="txtLNAdult0") WebElement Lastname;
	@CacheLookup
	@FindBy(id="divContinueTransactionSCD") WebElement ContinueBooking;
	
	
	
	
	

	// Initializing the Page Objects
	public FlightPage() {
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	public void searchFlights(String fromCity, String toCity,String departureDate, String ReturnDate) 
			throws Exception {
		
		Flights.click();
		Oneway.click();
		
		From.click();
		Thread.sleep(5000);
		Fromdropdown.click();

		Thread.sleep(5000); 
	
		To.click();
		Todropdown.click();
		Thread.sleep(5000);
	  
		DepDate.click();
		DDate.click();
		Thread.sleep(5000);
		
		RetDate.click();
		RDate.click();

		Srchbtn.click();
		Thread.sleep(5000);
		
		assertEquals("RoundTrip Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com", 
				driver.getTitle());
	}
		
		public void flightlist() throws Exception {
		Thread.sleep(5000);
		Booknowbtn.click();
		}
		
		public void MoreFareOption() throws InterruptedException {
		Thread.sleep(5000);
		ContinueBtn.click();
		}
		
		public void Review(String Email) throws Exception {
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		
		Thread.sleep(5000);
		Insuranceclick.click();
		Thread.sleep(5000);
		
		EnterValidEmail.sendKeys(Email);
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		ContinuebookingBtn.click();
		}
		
		public void Travellers(String PhoneNo, String firstname, String lastname, String Titlename) throws Exception {
			
		Thread.sleep(5000);
		Dropdowntitle.click();
		
		Thread.sleep(2000);
		Select dropdown = new Select(Dropdowntitle);  
		
		Thread.sleep(2000);
		dropdown.selectByVisibleText(Titlename); 
		
		Thread.sleep(2000);
		Firstname.sendKeys(firstname);
		
		Thread.sleep(2000);
		Lastname.sendKeys(lastname);
		
		Thread.sleep(2000);
		EnterValidPhoneNo.sendKeys(PhoneNo);
		
		ContinueBooking.click();
		
		Thread.sleep(10000);
		
		}
	

	}
