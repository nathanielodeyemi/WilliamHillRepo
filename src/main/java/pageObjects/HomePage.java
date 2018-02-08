package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.williamhill.util.TestBase;

import pageObjects.LoginPage;

/*
 * Selenium page object to represent Home page. 
 * 
 * @author Nathaniel Odeyemi
 */
public class HomePage extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//*[@id='accountTabButton']/span[2]/span")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='account_deposit']/span")
	WebElement depositbutton;
	
	/*
	 * Default Constructor.
	 * 
	 * @param webDriver
	 * 				<code>org.openqa.selenium.WebDriver</code>
	 */
	public HomePage(WebDriver driver) {
		super(driver);		
	}
	
	/*
	 * Method to validate home page title.
	 * 
	 * @return String 
	 */
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	
	/*
	 * Method to click login button to allow user to enter username and password.
	 * 
	 * @return Login page 
	 */
	public LoginPage clickLoginButton() {
		
		this.loginButton.click(); 
		return new LoginPage(driver);
	}
	
	/*
	 * Method to validate that Deposit button is displayed.
	 * 
	 * @return Boolean 
	 */
	public Boolean verifyThatDepositTextisDisplayed(){
		
		//Verify that user has successfully logged in
		return depositbutton.isDisplayed();
	}
	
	/*
	 * Method to search and click any sport.
	 * 
	 * @param sport
	 * 			to allow user to enter any sport 
	 */
	public void selectSport(String sport) {
				
		WebElement sportType = driver.findElement(By.xpath("//div[@class='left-nav']/nav[3]/ul/ul/li/a[@class='c-list__item' and @title='"+ sport +"']"));
		sportType.click();
	}
	


}
