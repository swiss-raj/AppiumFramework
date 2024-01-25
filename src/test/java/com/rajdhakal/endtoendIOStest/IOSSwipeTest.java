package com.rajdhakal.endtoendIOStest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSwipeTest extends IOSBaseTest {
	
	@Test
	public void iosSwipe() {
		Map<String, String> params = new HashMap<String,String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
		driver.findElement(By.id("")).click();
		// here we are counting all photos in the apps or size
		List<WebElement> list = driver.findElements(By.xpath("//XCUIElementTypeCell"));
		driver.findElement(By.xpath("//XCUIElementTypeCell")).click();
		//Now below code will swipe the photo
		Map<String, Object> param1 = new HashMap<String,Object>();
		param1.put("direction", "left");
		driver.executeScript("mobile:swipe", param1);
		driver.navigate().back();
		
		driver.findElement(AppiumBy.accessibilityId("Albums")).click();// bringing the app in the initial page
		
		
	}

}
