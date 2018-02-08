package cucumberTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import junit.framework.Assert;
//import org.openqa.selenium.remote.service.*;



public class SportTest {
	
	public WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		String successful_Log = "Deposit";
		
	/*	//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		*/
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\opic21\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the website
		driver.get("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
		
		//Click Login button
		driver.findElement(By.xpath("//*[@id='accountTabButton']/span[2]/span")).click();
		
		//Enter Username
		driver.findElement(By.id("loginUsernameInput")).sendKeys("WHITA_nlongley");
		
		//Enter Password
		driver.findElement(By.id("loginPasswordInput")).sendKeys("barcelonatest");
		
		//Click Login button
		driver.findElement(By.id("loginButton")).click();
		
		//Verify that user has successfully logged in
				WebElement successfulLogText = driver.findElement(By.xpath("//a[@class='account_deposit']/span"));			
				if (successfulLogText.getText().contains(successful_Log)){
					System.out.println("Login Successful");
					}
				else{
					System.out.println("Login Failed");
				}
				
		//Get current account balance
		WebElement account_Balance = driver.findElement(By.xpath("//div[@class='account-tab']/a[@id='accountTabButton']/span[1]"));
		System.out.println("Current Account Balance is " + account_Balance.getText());
		
		//Navigate to the football screen
		String sport = "Football";
		driver.findElement(By.xpath("//div[@class='left-nav']/nav[3]/ul/ul/li/a[@class='c-list__item' and @title='"+ sport +"']")).click();
		
		Thread.sleep(2000);
		ArrayList<WebElement> select_bet = (ArrayList<WebElement>)   
		driver.findElements(By.xpath("//div[@class='btmarket']/div[2]/div[1]/button[1]"));
			for (int i = 0; i < select_bet.size(); i++) {
				for(WebElement bet : select_bet) {
					if (i==0){
						bet.click();
					}              
					break;
				}				
			}
		
		
			
		//Select first match and home team to win
		//Enter Stake
		driver.findElement(By.xpath("//div[contains(@id, 'single-bet')]/div[1]/div[2]/span/input")).click();
			
		driver.findElement(By.xpath("//div[contains(@id, 'single-bet')]/div[1]/div[2]/span/input")).sendKeys("0.01");
		
		/*//Click on the place a bet button
		driver.findElement(By.xpath("//div[@id='betslip-footer-actions']/ul/li[3]/input")).click();
		
		//Verify that the bet is placed
		WebElement receipt = driver.findElement(By.xpath("//div[@id='receipt-notice-box']/em"));
		String bet_Confirmation = receipt.getText();
		System.out.println(bet_Confirmation);
		Assert.assertEquals("Bet Placed", bet_Confirmation);
		
		//Verify the slip returns
		WebElement bet_return = driver.findElement(By.xpath("//div[@class='betslip-footer__to-return']/div[2]/span[@id='total-to-return-price']"));	
		System.out.println("To Return " + bet_return.getText());
		
		
		
		//Verify the Total Stake
		WebElement total_stake = driver.findElement(By.xpath("//div[@class='betslip-footer__total-stake']/div[2]/span[@id='total-stake-price']"));
		System.out.println("Total Stake " + total_stake.getText());
		*/
		
		
		
		
		
		driver.quit();
		
	
		
	}
	
	//Getter for Driver
			public WebDriver getDriver() {
		        return this.driver;
		}
			
}
