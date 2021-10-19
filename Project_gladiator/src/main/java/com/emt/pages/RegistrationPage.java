package com.emt.pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

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
		@FindBy(id="RegValidPhone") WebElement InvalidText;
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
		public void registrationWithValidCredentials(String EPhone) throws Exception {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(Myaccount).perform();
			login.click();
			EmailorPhone.sendKeys(EPhone);
			ContinueButn.click();
			Thread.sleep(10000);
			//Entering otp manually
			Actions action2 = new Actions(driver);
			action2.moveToElement(CreateMyAccount).perform();
			Thread.sleep(10000);
			
		}
		public void registrationWithInalidCredentials(String EPhone) throws Exception {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(Myaccount).perform();
			login.click();
			EmailorPhone.sendKeys(EPhone);
			//Thread.sleep(10000);
			ContinueButn.click();
			//Thread.sleep(4000);
			assertEquals("* Enter a valid Phone Number", InvalidText.getText());
		}
	}
