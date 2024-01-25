package com.rajdhakal.endtoendandroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBaseTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void confifureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\swiss\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Raj");
		//options.setChromedriverExecutable("C:\\Users\\chromedriver.exe"); //need to bring your driver path after downloading the chrome driver
		options.setApp(
				"C:\\Users\\swiss\\eclipse-workspace\\AppiumProject\\src\\test\\java\\com\\appiumproject\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration",2000
			));
	}
	
	public void scrollToVewElement(String name) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"));")); 
	}
	
	public void scrollToEnd() {
		boolean canScrollMore;
		do {
		canScrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public double getFormattedAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}
	
	
	

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();

	}
	
	
	

}
