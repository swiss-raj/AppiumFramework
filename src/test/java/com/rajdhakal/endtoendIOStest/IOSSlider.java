package com.rajdhakal.endtoendIOStest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseTest {
	
	
	public void iosSlideTest() {
		
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain(""));
		slider.sendKeys("0%");
		
		
	}

}
