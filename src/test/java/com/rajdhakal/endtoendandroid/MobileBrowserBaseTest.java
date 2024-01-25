package com.rajdhakal.endtoendandroid;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void confifureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\swiss\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options(); //this is for android device coz everything we doing in android
		options.setDeviceName("Raj");
		//WebDriverManager.chromedriver().setup();
	
		//options.setChromedriverExecutable("C:\\Users\\chromedriver.exe"); //need to bring your driver path after downloading the chrome driver	
		options.setCapability("browserName", "chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
