package com.mindtree.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.mindtree.base.TestBas;

public class AboutTabTest extends TestBas {

	@Test
	public void clickAboutTab() {

		log.debug("Inside DownloadTabTest");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath(OR.getProperty("aboutTab"))).click();
		driver.findElement(By.xpath(OR.getProperty("governanceTab"))).click();
		Assert.assertEquals(driver.getTitle(), "Selenium Project Structure & Governance");

		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath(OR.getProperty("learnMoreBtn"))).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/sponsors/");
		log.debug("AboutTabTest completed");
		Reporter.log("AboutTabTest completed");

	}

}