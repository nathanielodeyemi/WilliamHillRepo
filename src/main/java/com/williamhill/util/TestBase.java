package com.williamhill.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.williamhill.util.WebDriverFactory;

/*
 * Selenium page object to represent Test Base. 
 * 
 * @author Nathaniel Odeyemi
 */
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	/*
	 * Default Constructor.
	 * 
	 * @param webDriver
	 * 				<code>org.openqa.selenium.WebDriver</code>
	 */
	public TestBase(final WebDriver driver) {
		
		if (driver != null) {
			this.driver = driver;
		} else {
			this.driver = WebDriverFactory.getWebDriverInstance();
		}
		
		PageFactory.initElements(this.driver, this);
	}
	
	/*
	 * Method to load properties from config file
	 * 
	 */
	public static void loadWebProperties() {
		try {
			prop = new Properties();
			prop.load(TestBase.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Method to initiate driver.
	 * 
	 * @return driver
	 * 
	 */
	public static WebDriver initialization() {
		loadWebProperties();
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "target/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "target/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Section commented out because some of the test steps are fail and I couldn't get it to work
		//Mobile Emulation code
		
		/*Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Nexus 5");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		driver = new ChromeDriver(chromeOptions);*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}