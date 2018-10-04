package com.appium.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.appium.setup.SetupSession;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		System.out.println("Before class started");
		List<String> deviceList = new ArrayList<>();//SetupSession.getInstance().getDeviceList();
//		deviceList.add("ZL522255X4");
	deviceList.add("47b608f8");
		for (String device : deviceList) {
			SetupSession.getInstance().startSession(device);
			SetupSession.getInstance().startService();
			DesiredCapabilities cap =  SetupSession.getInstance().getCapability();
			cap.setCapability("deviceName", device);
			driver = SetupSession.getInstance().getDriver(cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}	
	}
	
	
	
	@AfterClass
	public void AfterClass() throws IOException 
	{
		SetupSession.getInstance().stopService();
		Runtime.getRuntime().exec(new String[] { "taskkill", "/F", "/IM", "node.exe" });
		System.out.println("After class ended");
	}
}
