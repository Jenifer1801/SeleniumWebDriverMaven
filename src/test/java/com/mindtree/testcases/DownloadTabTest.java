package com.mindtree.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.base.TestBas;

public class DownloadTabTest extends TestBas {

	@Test
	public void clickDownloadTab() {
		log.debug("Inside DownloadTabTest");

		driver.findElement(By.xpath(OR.getProperty("downloadTab"))).click();
		Assert.assertEquals(driver.getTitle(), "Downloads");

		log.debug("DownloadTabTest completed");

	}

}
