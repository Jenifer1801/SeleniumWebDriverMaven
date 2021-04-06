package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.mindtree.base.TestBase;

public class TestUtil extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		screenshotName="error.jpg";
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\"+screenshotName));

	}

}
