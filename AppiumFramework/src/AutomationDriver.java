
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.appium.iniparser.ParseINI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AutomationDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		TestNG testNg = new TestNG();
		List<String> testcases = new ArrayList<String>();
		//testcases.add("com.appium.tests.Tester.class");
		//testcases.add("com.appium.tests.AppiumTester.class");
		testNg.setTestClasses(new Class[] {com.appium.tests.AppiumTester.class});
		testNg.setThreadCount(1);
		testNg.setParallel(XmlSuite.ParallelMode.METHODS);
		testNg.setPreserveOrder(true);
		testNg.run();
		
//		int count = 4;
//		int l = 0;
//		String s = "L,D,D,L";
//		String[] arr = s.split(",");
//		for(int i = 0;i<count;i++)
//		{
//			if(arr[i].equals("D"))
//			{
//				arr[i]="L";
//				l++;
//			}
//		}
//		
//		System.out.println("Result is : "+l);
//		PerfectoLabUtils.uploadMedia("mobilecloud.perfectomobile.com", "Chiranjeevi_Veeramreddy@McAfee.com", "Mcafee@123", "C:\\Users\\sreddy6\\MMS\\MMS_builds\\MMS_vpn_13_12.apk", "PRIVATE:apps/mms.apk");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("user", "Chiranjeevi_Veeramreddy@McAfee.com");
//		capabilities.setCapability("password", "Mcafee@123");
//		//capabilities.setCapability("browser", "chrome");
//		String host = "mobilecloud.perfectomobile.com";
//		String url = "https://" + host + "/nexperience/perfectomobile/wd/hub";
//		capabilities.setCapability("deviceName", "330044B1985082CB");
//		capabilities.setCapability("platformVersion", "7.0");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("manufacturer", "Samsung");
//		capabilities.setCapability("app", "PRIVATE:apps/mms.apk");
//		capabilities.setCapability("appPackage", "com.wsandroid.suite");
////		capabilities.setCapability("appWaitActivity", "com.mcafee.app.SplashActivity,com.mcafee.activation.WelcomeActivity,com.mcafee.app.MainActivity");
////		capabilities.setCapability("appActivity", "com.mcafee.app.LauncherDelegateActivity");
//		capabilities.setCapability("autoLaunch",true);
//		capabilities.setCapability("newCommandTimeout", 60);
//		AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL(url),capabilities);
//		//driver.launchApp();
//		
////		Map<String, Object> params = new HashMap<>();
////		params.put("file", "PRIVATE:apps/demo.apk");SUPPORTED
//
////		params.put("instrument", "noinstrument");
////		driver.executeScript("mobile:application:install", params);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.id("com.wsandroid.suite:id/btn_next")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.wsandroid.suite:id/btn_likes_ads"))).click();
//		driver.findElement(By.id("com.wsandroid.suite:id/img_actionbar_cancel")).click();
//		org.testng.Assert.assertTrue(driver.findElement(By.id("com.wsandroid.suite:id/new_msg_title")).isDisplayed());
	}
	
}
