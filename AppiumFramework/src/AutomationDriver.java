import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.appium.excel.ExcelReader;
import com.appium.setup.SetupSession;
import com.test.perfecto.PageFactory;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class AutomationDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		TestNG testNg = new TestNG();
		List<String> testcases = new ArrayList<String>();
		testcases.add("com.appium.tests.Tester.class");
		//testcases.add("com.appium.tests.AppiumTester.class");
		testNg.setTestClasses(new Class[] {com.appium.tests.Tester.class});
		testNg.setThreadCount(1);
		testNg.setParallel(XmlSuite.ParallelMode.CLASSES);
		testNg.setPreserveOrder(true);
		testNg.run();
		
		//System.out.println("Result is : "+getSum("1bc123 55a g"));
	}
	
}
