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

public class AppiumTester extends BaseTest{

	@Test
	public void testMMS() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.wsandroid.suite:id/btn_next")).click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.wsandroid.suite:id/btn_likes_ads"))).click();
		driver.findElement(By.id("com.wsandroid.suite:id/img_actionbar_cancel")).click();
		org.testng.Assert.assertTrue(driver.findElement(By.id("com.wsandroid.suite:id/new_msg_title")).isDisplayed());
	}
}
