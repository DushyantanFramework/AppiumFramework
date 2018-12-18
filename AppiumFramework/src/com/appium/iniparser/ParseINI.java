package com.appium.iniparser;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;

public class ParseINI {

	public static Section getSection(String sectionName) throws InvalidFileFormatException, IOException {
		Ini ini = new Ini(new File(System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Device.INI"));
		return ini.get(sectionName);
	}
}
