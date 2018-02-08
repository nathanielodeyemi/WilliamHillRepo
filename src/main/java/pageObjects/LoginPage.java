package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.williamhill.util.TestBase;

/*
 * Selenium page object to represent Login page. 
 * 
 * @author Nathaniel Odeyemi
 */
public class LoginPage extends TestBase {
	
	@FindBy(id="loginUsernameInput")
	WebElement username;
	
	@FindBy(id="loginPasswordInput")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement submitLoginDetailButton;
	
	/*
	 * Default Constructor.
	 * 
	 * @param webDriver
	 * 				<code>org.openqa.selenium.WebDriver</code>
	 */
	public LoginPage(final WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Method to enter login detail
	 * 
	 * @param uname - Username 
	 * @param pword - password
	 * @return homepage 
	 */
	public HomePage login(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		
		return new HomePage(driver);	
	}
	
	/*
	 * Method to click login button after entering login detail
	 * 
	 * @return homepage 
	 */
	public HomePage clickSubmitLoginDetailsButton() {
		this.submitLoginDetailButton.click();
		return new HomePage(driver);
	}
}
