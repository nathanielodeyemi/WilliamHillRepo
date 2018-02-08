package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.williamhill.util.TestBase;

/*
 * Selenium page object to represent Football page. 
 * 
 * @author Nathaniel Odeyemi
 */
public class FootballPage extends TestBase{
	
	@FindBy(xpath="//section[@id='match-highlights']/header/div/h2")
	WebElement verifySportPage;
	
	@FindBy(xpath="//div[@class='account-tab']/a[@id='accountTabButton']/span[1]")
	WebElement currentAccountBalance;
	
	@FindBy(xpath="//div[@class='btmarket']/div[2]/div[1]/button[1]")
	WebElement selectBet;
	
	@FindBy(xpath="//div[contains(@id, 'single-bet')]/div[1]/div[2]/span/input")
	WebElement bettingStake;
	
	@FindBy(xpath="//div[@id='betslip-footer-actions']/ul/li[3]/input")
	WebElement placeBetButton;
	
	@FindBy(xpath="//div[@id='receipt-notice-box']/em")
	WebElement verifyBetPlaced;
	
	@FindBy(xpath="//div[@id='bet-receipt']/receipt/header/h2/div/a/i[2]")
	WebElement bettingSlipDropDown;
	
	@FindBy(xpath="//div[@class='betslip-footer__to-return']/div[2]/span[@id='total-to-return-price']")
	WebElement betReturn;
	
	@FindBy(xpath="//div[@class='betslip-footer__total-stake']/div[2]/span[@id='total-stake-price']")
	WebElement totalStake;
	
	/*
	 * Default Constructor.
	 * 
	 * @param webDriver
	 * 				<code>org.openqa.selenium.WebDriver</code>
	 */
	public FootballPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Method to validate that the correct sport page is displayed.
	 * 
	 * @return Boolean 
	 */
	public Boolean verifySportPageIsDisplayed() {
		
		return verifySportPage.isDisplayed();
	}
	
	/*
	 * Method to select the first bet from list.
	 * 
	 * @return ArrayList 
	 */	
	public ArrayList<WebElement> selectFirstActiveBet() {
		
		ArrayList<WebElement> select_bet = (ArrayList<WebElement>)   
		driver.findElements(By.xpath("//div[@class='btmarket']/div[2]/div[1]/button[1]"));
		select_bet.get(0).click();
		return select_bet;
	}
	
	/*
	 * Method to get the account current balance.
	 * 
	 * @return String 
	 */	
	public String getCurrentAccountBalance() {	
		return currentAccountBalance.getText();
	}
	
	/*
	 * Method to enter Stake.
	 * 
	 * @param String stake
	 * 					To allow user enter any value they want.
	 */	
	public void enterStake(String stake) {
		bettingStake.sendKeys(stake);
	}
	
	/*
	 * Method to click Place Bet button.
	 */
	public void clickPlaceBetButton() {
		placeBetButton.click();
	}
	
	/*
	 * Method to verify that Bet Placed button is displayed.
	 * 
	 * @return Boolean 
	 */
	public Boolean verifyThatBetIsPlaced() {
	
		return verifyBetPlaced.isDisplayed();	
	}
	
	/*
	 * Method to click dropdown arrow on betting slip.
	 */
	public void clickBettingSlipDropdownArrow() {
		bettingSlipDropDown.click();
	}
	
	/*
	 * Method to verify that Bet Return value is displayed.
	 * 
	 * @return Boolean 
	 */
	public boolean verifyBetReturn() {
		return betReturn.isDisplayed();
	}
	
	/*
	 * Method to verify that Total Stake is displayed.
	 * 
	 * @return Boolean 
	 */
	public boolean verifyTotalStake() {
		
		return totalStake.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
