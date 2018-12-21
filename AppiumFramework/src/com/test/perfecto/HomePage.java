package com.test.perfecto;

import org.openqa.selenium.By;

import com.appium.fw.MobileElement;
import com.appium.fw.MobilePage;

public class HomePage extends MobilePage{

	public MobileElement acceptEULA = new MobileElement(By.id("com.wsandroid.suite:id/btn_next"));
	public MobileElement likeADS = new MobileElement(By.id("com.wsandroid.suite:id/btn_likes_ads"));
	public MobileElement cancelPermissions = new MobileElement(By.id("com.wsandroid.suite:id/img_actionbar_cancel"));
	public MobileElement coachMark = new MobileElement(By.id("com.wsandroid.suite:id/new_msg_title"));
	
}
