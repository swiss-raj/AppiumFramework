package com.rajdhakal.endtoendIOStest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseTest {
	
	
	public void iosLongPress() {
		
		driver.findElement(AppiumBy.accessibilityId("")).click();
		WebElement element = driver.findElement(AppiumBy.iOSClassChain(""));
//		Map<String, Object> map = new HashMap<>();
//		map.put("element",((RemoteWebElement) element).getId());
//		map.put("duration", 5);
//		driver.executeScript("mobile:touchAndHold", map);
		iosLongPressTest(element,5);
	}

}
