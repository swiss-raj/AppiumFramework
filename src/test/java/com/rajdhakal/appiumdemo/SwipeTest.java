package com.rajdhakal.appiumdemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeTest extends BaseTest {
	
	@Test
	public void swipeTest() {
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'1. Photos\']")).click();
	
	WebElement element = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
	String name = element.getAttribute("focusable");
	Assert.assertEquals(name,"true");
	swipeAction(element,"left");
	String name2 = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
	Assert.assertEquals(name2,"false");
	}

}
