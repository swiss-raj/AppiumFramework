package com.rajdhakal.endtoendandroid;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest {
	
	@Test
	public void browserTest() {
		
		//Note: this is all selenium but we just configure with appium
		
		
		driver.get("http://google.com");
		//this is will open the google page and from here you can do action like you did in selenium
		
		// 
		driver.get("https:rahulshettyacademy.com/angularAppdemo/");
		
		// some time you see different screen between mobile or laptop about the web page for e.g.
		// you may not see hamburger menu in computer brower but you see in mobile browser so make sure you first
		//go to devtools and bring to mobile version menu and do operation
		
		//driver.findElement(By.id("")).click // hamburger menu
		driver.findElement(By.id("")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)",""); // scroll happen
		//and do performance
		
	}

}
