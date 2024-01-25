package com.rajdhakal.appiumdemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class TestDesignatedPage extends BaseTest {
	
	@Test
	public void testSpecificPage() {
		
		//if you want to jump into specific page rather then going from home and click click then follow these steps
		//open your emulator to specific page and copy paste this line of code to cmd
		// adb shell dumpsys window | find "mCurrentFocus"
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("ABCDEF");
		driver.findElement(By.id("android:id/button1")).click();
	}

}
