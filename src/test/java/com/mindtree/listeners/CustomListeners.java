package com.mindtree.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.Reporter;

import com.mindtree.utilities.TestUtil;

public class CustomListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestContext arg0) {

	}

	public void onTestFailure(ITestContext arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+">height=200 width=200></img>s</a>");

	}

	public void onTestSkipped(ITestContext arg0) {

	}

	public void onTestStart(ITestContext arg0) {

	}

	public void onTestSuccess(ITestContext arg0) {

	}

}
