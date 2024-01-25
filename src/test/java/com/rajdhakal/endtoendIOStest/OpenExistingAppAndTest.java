package com.rajdhakal.endtoendIOStest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class OpenExistingAppAndTest extends IOSBaseTest {
	
	
	@Test
	public void openExistingTest() {
		
		//Note: when they asked you test the existing App, which mean already download and ready to use App for
		// example like photos app in apple in that case you need to ass either BUNDLE ID from developer or .app file
		// you get bundle id of apple app in google
		
		Map<String, String> params = new HashMap<String,String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
		
	}

}
