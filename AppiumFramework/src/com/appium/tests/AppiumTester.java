package com.appium.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;
import com.test.perfecto.PageFactory;

public class AppiumTester extends BaseTest{

	@Test
	public void testMMS() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.homePage.acceptEULA.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(PageFactory.homePage.likeADS.getBy())).click();
		PageFactory.homePage.cancelPermissions.click();
		Assert.assertTrue(PageFactory.homePage.coachMark.isDisplayed());
	}
}
