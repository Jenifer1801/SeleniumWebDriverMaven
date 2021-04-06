package com.mindtree.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mail
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() {
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			}
			try {
				config.load(fis);
				log.debug("Config file loaded!!");
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded!!");
			} catch (IOException e) {

				e.printStackTrace();
			}
			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.firefox.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox browser launched!!");

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome browser launched!!");
			} else if (config.getProperty("browser").equals("IE")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("IE browser launched!!");
			}
			driver.get(config.getProperty("testurlsite"));
			log.debug("	User navigated to https://www.selenium.dev/ site ");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {

		}
		return false;
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();

		}

		log.debug("Test execution completed sucessfully!!!");

	}

}
