package com.rajdhakal.endtoendIOStest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;

public class IOSScrollTest extends IOSBaseTest {
	
	
	public void iosScrollTest() {
		driver.findElement(AppiumBy.accessibilityId("")).click();
		WebElement element = driver.findElement(AppiumBy.iOSClassChain(""));
		Map<String, Object> map = new HashMap<>();
		map.put("direction", "down");
		map.put("element", ((RemoteWebElement)element).getId());
		driver.executeScript("mobile:scroll", map);
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
	}
	
	

}
