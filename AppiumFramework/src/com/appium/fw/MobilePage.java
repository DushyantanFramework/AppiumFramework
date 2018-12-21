package com.appium.fw;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.appium.setup.DriverFactory;

public class MobilePage{

	public void takeScreenshot(String name) throws IOException {
		File screenshot = ((TakesScreenshot)DriverFactory.driver).getScreenshotAs(OutputType.FILE).getAbsoluteFile();
		FileUtils.moveFile(screenshot, new File("C:\\Users\\sreddy6\\Desktop\\Framework\\AppiumFramework\\screenshots\\"+name+".png"));
	}	
}
