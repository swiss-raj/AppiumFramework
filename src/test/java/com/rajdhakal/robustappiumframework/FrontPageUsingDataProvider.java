package com.rajdhakal.robustappiumframework;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajdhakal.androidpageobject.CartPage;
import com.rajdhakal.androidpageobject.ProductCataloguePage;
import com.rajdhakal.testutils.BaseTest;

public class FrontPageUsingDataProvider extends BaseTest{	

	
	@Test(dataProvider = "getData")
	public void fillFormWithDataProvider(String name, String gender, String country) throws InterruptedException {
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.selectCountry(country);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{"Raj Dhakal","male","Angola"},
			{"Sarita Adhikari","female","Nepal"}
		};
	}

}
