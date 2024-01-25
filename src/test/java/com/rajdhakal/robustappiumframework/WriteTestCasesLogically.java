package com.rajdhakal.robustappiumframework;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rajdhakal.testutils.BaseTest;

import io.appium.java_client.android.Activity;

public class WriteTestCasesLogically extends BaseTest {
	
	
	
// write all the test cases logically that so you do not run @BeforeClass method every time you execute any test 
// example if you write the error validation of the Form Page, write another positive test cases in the same
// class so you no need to run Before class again and use BeforMethod so stay in same screen/ remain open in home screen for e.g.
	
	@BeforeMethod
	public void preSetToHomeScreen() {
		//Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);
		System.out.println("I am Before Method called");
	}
	
	
	@Test
	public void fillFormErrorValidation() {
		//write code so you see error message, please make sure down test cases can be written because home screen must stay open for
		//second test in this case before method help you
		//AssertJUnit.assertEquals("raj", "Raju");
		System.out.println("I am fillFormErrorValidation called");
	}
	
	@Test
	public void fillFormWithCorrectInfo() {
		// You can write another test case in this class so no Before class run again and again
		
		System.out.println("I am fillFormWithCorrectInfo called");
	}
	
	

}
