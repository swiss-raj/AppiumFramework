package com.rajdhakal.realdevicetext;

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

public class RealDeviceBaseTestForAndroid {
	
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
		//options.setDeviceName("Raj"); in real device we don't use emulator anymore
		options.setDeviceName("Android Device");
		// find build number in android device: System->About Phone -> Build Number
		// once you find that build number than tap build number 7 times, when you do this then developer option is enable
		// you can now cmd adb devices then you see how many devices you have in your computer
		
		
		
		
		options.setApp(
				"C:\\Users\\swiss\\eclipse-workspace\\AppiumProject\\src\\test\\java\\com\\appiumproject\\resources\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();

	}

}
