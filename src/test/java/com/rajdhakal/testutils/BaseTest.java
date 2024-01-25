package com.rajdhakal.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajdhakal.androidpageobject.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void confifureAppium() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rajdhakal\\resources\\data.properties");
		prop.load(file);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Raj");
		options.setApp(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\appiumproject\\resources\\General-Store.apk");
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		formPage = new FormPage(driver);
	}
	
	
	public String getScreenShotPath(String testCaseName,AndroidDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
//Note:this is how you convert your test data from JSON to testNG data provider
//	Parse JSon file --> JSon String (Commons-IO)
//	JSon String --> HashMap (Jackson)
//	Hash Map --> Test Cases (TestNG data provider)
		
	
	public List<HashMap<String, String>> getJSonData(String jsonFilePath) throws IOException{
		
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}
	
	


	@AfterClass(alwaysRun=true)
	public void tearDown() {

		driver.quit();
		service.stop();

	}
	
	
	

}
