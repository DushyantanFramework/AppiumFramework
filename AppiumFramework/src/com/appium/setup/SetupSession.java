package com.appium.setup;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty9.server.handler.StatisticsHandler;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class SetupSession {

	private static SetupSession setupSession = null;
	private String service_url;
	private AppiumDriverLocalService service= null;
	protected static String nodeJSExecutable = System.getenv("ProgramFiles")+File.separator+"nodejs"+File.separator+"node.exe";
	protected static String appiumJS = System.getenv("APPDATA")+File.separator+"npm" +File.separator+"node_modules"+ File.separator + "appium" + File.separator + "build" + File.separator + "lib" + 
		      File.separator + "main.js";
	
	public AppiumDriverLocalService startSession(String device) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("udid", device);
		cap.setCapability("noReset", true);
		 AppiumServiceBuilder builder = new AppiumServiceBuilder().
				 usingDriverExecutable(new File(nodeJSExecutable)).withAppiumJS(new File(appiumJS)).withCapabilities(cap)
				 .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
			      .withArgument(GeneralServerFlag.LOG_LEVEL, "debug").withIPAddress("127.0.0.1").usingAnyFreePort().withLogFile(new File(device+"_"+new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime())+"_log.txt"));
		 service = builder.build();
//		//AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(0).usingDriverExecutable(new File(nodeJSExecutable)).withAppiumJS(new File(appiumJS)));
		return service;
	       
	}
	
	private SetupSession() {}
	
	public static SetupSession getInstance() {
		
		if (setupSession == null) {
			setupSession = new SetupSession();
		}
		return setupSession;
	}
	
	public void startService() {
		service_url = service.getUrl().toString();
		service.start();
	}
	
	public AndroidDriver<MobileElement> getDriver(DesiredCapabilities capability) throws MalformedURLException 
	{
		AndroidDriver<MobileElement> driver = null;
			driver = new AndroidDriver<MobileElement>(new URL(service_url), capability);
			System.out.println(" Device time : "+driver.getDeviceTime());
			return driver;
	}
	
	public DesiredCapabilities getCapability() {
		DesiredCapabilities cap = new DesiredCapabilities();
		File file = new File("C:\\Users\\sreddy6\\base.apk");
		//File file = new File("C:\\Users\\sreddy6\\MMS\\MMS_builds\\McafeeMobileSecuirty_Android_5.0_LD_bld_1597\\release\\mms-5.0.2.1597-production-release.apk");
		cap.setCapability("app", file.getAbsolutePath());
		cap.setCapability("appPackage", "com.bigbasket.mobileapp");
	    cap.setCapability("appWaitActivity", "com.bigbasket.mobileapp.activity.HomeActivity");
	    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    return cap;
	}
	
	public void stopService() {
		if(service.isRunning()) {
			service.stop();
			System.out.println("Server stopped");
		}
		
	}
	
	public List<String> getDeviceList() {
		List<String> deviceList = new ArrayList<>();
		String line = null;
		
		try {
			Process process =  Runtime.getRuntime().exec("adb devices");
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line=in.readLine()) != null) {
				if (!line.contains("attached")) {
					deviceList.add(line.split("\t")[0]);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return deviceList;
	}
}
