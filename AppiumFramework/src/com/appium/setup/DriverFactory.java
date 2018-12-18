package com.appium.setup;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.iniparser.ParseINI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {

	public static AppiumDriver getDriver(String deviceName) throws InvalidFileFormatException, IOException {
		AppiumDriver driver = null;
		Section section = ParseINI.getSection(deviceName);
		String user = section.get("user");
		String password = section.get("password");
		String file = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"mms.apk";
		String platformName = section.get("platformName");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("udid", section.get("udid"));
		capabilities.setCapability("platformVersion", section.get("platformVersion"));
		if(platformName.equals("Android"))
			capabilities.setCapability("appPackage", section.get("appPackage"));
		else if(platformName.equals("iOS"))
			capabilities.setCapability("bundleId", section.get("appPackage"));
		capabilities.setCapability("user", user);
		capabilities.setCapability("password", password);
		capabilities.setCapability("autoLaunch",true);
		capabilities.setCapability("newCommandTimeout", 60);
		PerfectoLabUtils.uploadMedia("mobilecloud.perfectomobile.com", user, password, file, "PRIVATE:apps/mms.apk");
		capabilities.setCapability("app", "PRIVATE:apps/mms.apk");
		String host = section.get("host");
		String url = "https://" + host + "/nexperience/perfectomobile/wd/hub";
		if(platformName.equals("Android"))
			driver = new AppiumDriver<>(new URL(url),capabilities);
		else if(platformName.equals("iOS"))
			driver = new IOSDriver<>(new URL(url),capabilities);
		return driver;
	}
}
