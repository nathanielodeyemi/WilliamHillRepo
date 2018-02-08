package com.williamhill.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.williamhill.util.TestUtil;

import common.files.WebDriverFactory;
import pageObjects.HomePage;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(final WebDriver driver) {
		
		if (driver != null) {
			this.driver = driver;
		} else {
			this.driver = WebDriverFactory.getWebDriverInstance();
		}
		
		PageFactory.initElements(this.driver, this);
	}
	
	public static void loadWebProperties() {
		try {
			prop = new Properties();
			//new FileInputStream(System.getProperty("C:\\Users\\opic21\\TheAcademy\\WilliamHill\\src\\main\\resources\\config.properties"));
			prop.load(TestBase.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HomePage navigateToWebsite() {
		this.driver.get("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
		return new HomePage(driver);
	}
 
	public static WebDriver initialization() {
		loadWebProperties();
		String browserName = prop.getProperty("browers");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}