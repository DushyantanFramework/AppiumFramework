import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.appium.excel.ExcelReader;
import com.appium.setup.SetupSession;

public class AutomationDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		TestNG testNg = new TestNG();
//		List<String> testcases = new ArrayList<String>();
//		testcases.add("com.appium.tests.Tester.class");
//		//testcases.add("com.appium.tests.AppiumTester.class");
//		testNg.setTestClasses(new Class[] {com.appium.tests.Tester.class});
//		testNg.setThreadCount(1);
//		testNg.setParallel(XmlSuite.ParallelMode.CLASSES);
//		testNg.setPreserveOrder(true);
//		testNg.run();
		ExcelReader reader = new ExcelReader("C:\\Users\\sreddy6\\Desktop\\Framework\\AppiumFramework\\Resources\\Test.xlsx");
		reader.ReadExcel("test", "TestCase");
	}
}
