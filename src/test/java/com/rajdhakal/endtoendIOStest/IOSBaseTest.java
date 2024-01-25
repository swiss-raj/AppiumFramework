package com.rajdhakal.endtoendIOStest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	
	IOSDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void confifureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\swiss\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13 pro");
		options.setApp("give path of app which is going to test");
		options.setPlatformName("15.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void iosLongPressTest(WebElement element, int noOfSecondToBeHold) {
		Map<String, Object> map = new HashMap<>();
		map.put("element",((RemoteWebElement) element).getId());
		map.put("duration", noOfSecondToBeHold);
		driver.executeScript("mobile:touchAndHold", map);
	}
	
	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();

	}
	

}
