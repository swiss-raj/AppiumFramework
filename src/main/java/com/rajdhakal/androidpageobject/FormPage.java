package com.rajdhakal.androidpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rajdhakal.androidutils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@text='Male']")
	private WebElement maleOption;
	
	@FindBy(xpath = "//*[@text='Female']")
	private WebElement femaleOption;
	
	@FindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@FindBy(id = "android:id/text1")
	private WebElement selectCountry;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public void selectCountry(String countryName) {
		selectCountry.click();
		scrollToVewElement(countryName);
		driver.findElement(By.xpath("//*[@text='"+countryName+"']")).click();
	}
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female")) {
			femaleOption.click();
		}else {
			maleOption.click();
		}
	}
	
	public ProductCataloguePage submitForm() {
		shopButton.click();
		return new ProductCataloguePage(driver);
	}
	
	
	
	
	
	
	

}
