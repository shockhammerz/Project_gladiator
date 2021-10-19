package com.emt.pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emt.base.Base;

public class LoginPage extends Base {
	
	//PageFactory
	@CacheLookup
	@FindBy(className="newHeaderLogo") WebElement EMTlogo;
	@CacheLookup
	@FindBy(id="spnMyAcc") WebElement Myaccount;
	@CacheLookup
	@FindBy(id="shwlogn") WebElement login;
	@CacheLookup
	@FindBy(id="txtEmail") WebElement EmailorPhone;
	@CacheLookup
	@FindBy(id="shwotp") WebElement ContinueButn;
	@CacheLookup
	@FindBy(id="txtEmail2") WebElement Password;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input") WebElement LoginBtn;
	@CacheLookup
	@FindBy(id="RegValidEmail") WebElement InvalidString;
	
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEMTLogo() {
		return EMTlogo.isDisplayed();		
	}

	public void loginWithValidCredentials(String EPhone, String Pass) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(Myaccount).perform();
		login.click();
		EmailorPhone.sendKeys(EPhone);
		ContinueButn.click();
		Password.sendKeys(Pass);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginBtn.click();
	}
	public void loginWithInValidCredentials(String Ephone) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(Myaccount).perform();
		login.click();
		EmailorPhone.sendKeys(Ephone);
		ContinueButn.click();
		assertEquals("* Enter a valid Email", InvalidString.getText());
	}
}
