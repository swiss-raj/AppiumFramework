package com.rajdhakal.testutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ExtentTest tests;
	public AndroidDriver driver; // this may take out if not works
	
	  @Override		
	    public void onFinish(ITestContext arg0) {					
	        extent.flush();			
	        		
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        tests.fail(result.getThrowable());
	        try {
	       driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	        } catch(Exception e1) {
	        	e1.printStackTrace();
	        }
	        try {
	        	tests.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
	        	
	        }catch(IOException e) {
	        	e.printStackTrace();
	        }
	    		   
	    		   
	    		   
	    		   
	        		
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	      tests =  extent.createTest(result.getMethod().getMethodName());		
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        tests.log(Status.PASS, "Test Passed");			
	        		
	    }
	
	
	

}
