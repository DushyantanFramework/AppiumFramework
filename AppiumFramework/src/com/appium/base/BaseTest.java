package com.appium.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import com.appium.iniparser.ParseINI;
import com.appium.setup.DriverFactory;
import com.appium.setup.SetupSession;

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
	public void AfterClass() throws IOException 
	{
		driver.closeApp();
		System.out.println("After class ended");
	}
}
