package com.emt.pages;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emt.base.Base;


public class RegistrationPage extends Base {
		
		//PageFactory
		@CacheLookup
		@FindBy(id="spnMyAcc") WebElement Myaccount;
		@CacheLookup
		@FindBy(id="shwlogn") WebElement login;
		@CacheLookup
		@FindBy(id="txtEmail") WebElement EmailorPhone;
		@CacheLookup
		@FindBy(id="shwotp") WebElement ContinueButn;
		@CacheLookup
		@FindBy(id="shwlgnOTP") WebElement GetOTP;
		@CacheLookup
		@FindBy(id="txtEmail1") WebElement EnterOTP;
		@CacheLookup
		@FindBy(id="OtpLgnBtn") WebElement CreateMyAccount;
		
		
		//Initializing the Page Objects
		public RegistrationPage() {
			PageFactory.initElements(driver, this);
			
		}
		
		//Actions
		public void register(String EPhone,String OTP) throws Exception {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(Myaccount).perform();
			login.click();
			EmailorPhone.sendKeys(EPhone);
			ContinueButn.click();
			Thread.sleep(10000);
			//EnterOTP.sendKeys(OTP); //Entering otp manually
			Actions action1 = new Actions(driver);
			action1.moveToElement(CreateMyAccount).perform();
			String ActualURL = driver.getCurrentUrl();
			assertEquals("URL verified",prop.getProperty("url"), ActualURL);
			
		}
	}
