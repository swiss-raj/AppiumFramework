package com.rajdhakal.endtoendandroid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FillForm extends MobileBaseTest {
	
	@Test
	public void fillForm() {
		driver.findElement(By.id("android:id/text1")).click();
		scrollToVewElement("Angola");
		driver.findElement(By.xpath("//*[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Raj Dhakal");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		
		
	}

}
