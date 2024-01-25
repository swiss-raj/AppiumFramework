package com.rajdhakal.robustappiumframework;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajdhakal.testutils.BaseTest;

public class FrontPageJsonInputData extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void fillFormWithDataProvider(HashMap<String, String> input) throws InterruptedException {
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String, String>> data = getJSonData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\rajdhakal\\testdata\\Ecommerce.json");
		
		return new Object[][] {
			{data.get(0)},
			{data.get(1)}
		};
	}

}
