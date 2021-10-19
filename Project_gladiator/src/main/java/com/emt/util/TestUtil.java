package com.emt.util;

import org.openqa.selenium.Alert;

import com.emt.base.Base;

public class TestUtil extends Base {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT = 10;
	
	public String Alert() {
		// Alert
				driver.switchTo().alert();
				// Extract alert message.
				return  driver.switchTo().alert().getText();
			
	}
	public void Alert1() {
		/// Alert
		   Alert a = driver.switchTo().alert();
		   // Extract alert message.
		   driver.switchTo().alert().getText();
		   // alert accept
		   a.accept();
		   // alert dismiss
		     a.dismiss();
	}
	

}
