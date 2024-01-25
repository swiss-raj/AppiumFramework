package com.rajdhakal.androidpageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rajdhakal.androidutils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "com.androidsample.generalstore:id/productName")
	private WebElement productName;
	
	@FindBy(id = "com.androidsample.generalstore:id/productPrice")
	private WebElement productPrice;
	
	
	

		public String getProductNameAddedToCart() {
			return productName.getText();
		}
		
		public double getProductPrice() {
			String price = productPrice.getText();
			return getFormattedAmount(price);
		}
		
	
		
	
	
	
	
	
	
	

}
