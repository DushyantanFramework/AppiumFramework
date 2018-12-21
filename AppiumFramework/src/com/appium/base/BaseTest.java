package com.appium.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.appium.iniparser.ParseINI;
import com.appium.setup.DriverFactory;
import com.appium.setup.SetupSession;
import com.test.perfecto.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AppiumDriver driver = null;
	
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		driver = DriverFactory.getDriver("Samsung Galaxy Tab2");
	}	
	
	
	
	@AfterClass
	public void AfterClass(ITestResult result) throws IOException 
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			PageFactory.homePage.takeScreenshot(result.getMethod().getMethodName());
		}
		driver.closeApp();
		System.out.println("After class ended");
	}
}
