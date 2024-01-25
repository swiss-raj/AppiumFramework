package com.rajdhakal.androidpageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rajdhakal.androidutils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class ProductCataloguePage extends AndroidActions {
	
	AndroidDriver driver;
	
	public ProductCataloguePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> list;
	
	@FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement button;
	
	
	public void addItemToCart(String itemName) throws InterruptedException {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getText().equalsIgnoreCase(itemName)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			
			}
		}

	}
	
	public CartPage goToCartPage() throws InterruptedException {
		button.click();
		Thread.sleep(6000);
		return new CartPage(driver);
	}

		
	

	
	
	
	
	
	
	

}
