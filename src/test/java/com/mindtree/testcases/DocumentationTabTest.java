package com.mindtree.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

import com.mindtree.base.TestBas;

public class DocumentationTabTest extends TestBas {

	@Test
	public void ClickDocumentationTab() {
		log.debug("Inside DocumentationTabTest");
		driver.findElement(By.xpath(OR.getProperty("docTab"))).click();
		Assert.assertEquals(driver.getTitle(), "The Selenium Browser Automation Project :: Documentation for Selenium");
		driver.findElement(By.xpath(OR.getProperty("searchTextBox"))).sendKeys("Grid");
		driver.findElement(By.xpath(OR.getProperty("secondSelect"))).click();
		Assert.assertEquals(driver.getTitle(), "Grid 3 :: Documentation for Selenium");
		log.debug("DocumentationTabTest completed");
		Reporter.log("DocumentationTabTest completed");
		
	}

}
