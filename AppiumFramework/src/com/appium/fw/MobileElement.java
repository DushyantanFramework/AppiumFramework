package com.appium.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.appium.setup.DriverFactory;

import io.appium.java_client.AppiumDriver;

public class MobileElement {

	By by = null;
	AppiumDriver driver = DriverFactory.driver;
	
	public MobileElement(By by) {
		// TODO Auto-generated constructor stub
		this.by = by;
	}
	
	public void click() {
		driver.findElement(by).click();
	}
	
	public void sendKeys(CharSequence... data) {
		driver.findElement(by).sendKeys(data);
	}
	
	public void clearText() {
		driver.findElement(by).clear();
	}
	
	public String getText() {
		return driver.findElement(by).getText();
	}
	
	public boolean isDisplayed() {
		return driver.findElement(by).isDisplayed();
	}
	
	public boolean isEnabled() {
		return driver.findElement(by).isEnabled();
	}
	
	public boolean isSelected() {
		return driver.findElement(by).isSelected();
	}
	
	public By getBy() {
		return by;
	}
}
