package com.mindtree.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.base.TestBase;

public class DownloadTabTest extends TestBase {

	@Test
	public void clickDownloadTab() {
		log.debug("Inside DownloadTabTest");

		driver.findElement(By.xpath(OR.getProperty("downloadTab"))).click();
		Assert.assertEquals(driver.getTitle(), "Downloads");

		log.debug("DownloadTabTest completed");

	}

}
