package com.rajdhakal.robustappiumframework;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajdhakal.androidpageobject.CartPage;
import com.rajdhakal.androidpageobject.ProductCataloguePage;
import com.rajdhakal.testutils.BaseTest;

public class FrontPage extends BaseTest{
	
	/*Note: this before annotation would keep your front page open so below test cases won't be affected
	@BeforeMethod
	public void preSetToHomeScreen() {
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		//we use this method just make sure our screen stay in home page so I can write many test cases here
	}
	*/
	
	@Test
	public void fillForm() throws InterruptedException {
		formPage.setNameField("Raj Dhakal");
		formPage.setGender("Female");
		formPage.selectCountry("Angola");
		ProductCataloguePage productCataloguePage = formPage.submitForm(); 
		productCataloguePage.scrollToVewElement("Jordan 6 Rings");
		productCataloguePage.addItemToCart("Jordan 6 Rings");
		CartPage cartPage = productCataloguePage.goToCartPage();
		String name = cartPage.getProductNameAddedToCart();
		double productPrice = cartPage.getProductPrice();
		System.out.println("ProductName : " + name);
		System.out.println("Price is : " + productPrice);
		
	}
	/*
	
	@Test(dataProvider = "getData")
	public void fillFormWithDataProvider(String name, String gender, String country) throws InterruptedException {
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.selectCountry(country);
		
		
	}
	*/
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{"Raj Dhakal","male","Angola"},
			{"Sarita Adhikari","female","Nepal"}
		};
	}

}
