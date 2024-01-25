package com.rajdhakal.endtoendandroid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToastMessage extends MobileBaseTest {
	
	@Test
	public void toastMessage() {
		driver.hideKeyboard();
		driver.findElement(By.id("android:id/text1")).click();
		scrollToVewElement("Angola");
		driver.findElement(By.xpath("//*[@text='Angola']")).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
