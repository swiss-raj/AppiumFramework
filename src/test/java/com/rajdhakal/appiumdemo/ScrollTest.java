package com.rajdhakal.appiumdemo;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollTest extends BaseTest {
	
	@Test
	public void scrollTest() throws InterruptedException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToVewElement("WebView");
		Thread.sleep(4000);
		
	}

}
