package com.rajdhakal.endtoendandroid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SelectProduct extends MobileBaseTest {
	
	@Test
	public void selectProduct() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		scrollToVewElement("Angola");
		driver.findElement(By.xpath("//*[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Raj Dhakal");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		scrollToVewElement("Jordan 6 Rings");
		List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		wait.until((ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart")));
		
		String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(productName, "Jordan 6 Rings");
		String price = driver.findElement(By.id("com.androidsample.generalstore:id/productPrice")).getText();
		double price1 = getFormattedAmount(price);
		
		String amount1 = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double price2 = getFormattedAmount(amount1);
		Assert.assertEquals(price1, price2);
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(element);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(4000);
		
		
		
	}

}
