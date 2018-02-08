package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FootballPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import cucumber.api.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.williamhill.util.TestBase;

/*
 * Cucumber step definitions class for Place Bet 
 * 
 * @author Nathaniel Odeyemi
 */

public class PlaceBetTest_Steps {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private FootballPage footballPage;
	private String currentAccountBalance;
	
	/*
	 * Method to perform initial set-up activities that are required to run the step definitions
	 */
	@Before
	public void setUp() {
		
		//Load the Selenium wed driver and navigate to website
		this.driver = TestBase.initialization();
		
		//instantiate all the Home, Login and Football page
		this.homePage = new HomePage(driver);
		this.loginPage = new LoginPage(this.driver);
		this.footballPage = new FootballPage(this.driver);
	}
	
	/*
	 * Step definition for the step
	 * "user is on the Home Page and login"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@Given("^user is on the Home Page and login$")
	public void user_is_on_the_Home_Page() throws Throwable {

		//validate that the website loads successfully	
		String title = this.homePage.validateHomePageTitle();
		Assert.assertEquals(title , "Online Betting from William Hill - The Home of Betting");
		
		//Click Login button
		this.homePage.clickLoginButton();
		
		//Enter username and password
		this.loginPage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
		
		//Submit login details
		this.loginPage.clickSubmitLoginDetailsButton();
	}
	
	/*
	 * Step definition for the step
	 * "successfully logs in"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@And("^successfully logs in$")
	public void successfully_login() throws Throwable {
		
		//Assert that user has successfully logged in
		boolean depositButton = this.homePage.verifyThatDepositTextisDisplayed();
		
		Assert.assertTrue(depositButton);

	}
	
	/*
	 * Step definition for the step
	 * "user navigate to the <sport> Page"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 * @String sport
	 * 			  allow user to select any sport
	 */
	@When("^user navigate to the \"([^\"]*)\" Page$")
	public void user_navigate_to_the_sport_Page(String sport) throws Throwable {
		
		//Navigate to the football screen		
		this.homePage.selectSport(sport);
		
		//Verify that football page is displayed
		boolean sportPage = this.footballPage.verifySportPageIsDisplayed();
		Assert.assertTrue(sportPage);
	}
	
	/*
	 * Step definition for the step
	 * "selects the first active match"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@And("^selects the first active match$")
	public void selects_the_first_active_match() throws Throwable {		
		
		Thread.sleep(2000);
		
		//select the first active betting odd
		this.footballPage.selectFirstActiveBet();
	}
	
	/*
	 * Step definition for the step
	 * "place a bet <stake> and click Place a bet button"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 * @String stake
	 * 			  allow user to enter any amount
	 */
	@And("^place a bet \"([^\"]*)\" and click Place a bet button$")
	public void place_a_bet_and_click_Place_a_bet_button(String stake) throws Throwable {	
		//Get current account balance
		currentAccountBalance = this.footballPage.getCurrentAccountBalance();
		
		//Enter Stake
		this.footballPage.enterStake(stake);
		
		Thread.sleep(2000);
		//Click on the place a bet button
		this.footballPage.clickPlaceBetButton();
	}
	
	/*
	 * Step definition for the step
	 * "bet should be placed successfully"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@Then("^bet should be placed successfully$")
	public void bet_should_be_placed_successfully() throws Throwable {
		
		//wait for button to be loaded
		Thread.sleep(5000);
		
		//Verify that the bet is placed
		boolean betPlaced = this.footballPage.verifyThatBetIsPlaced();
		Assert.assertTrue(betPlaced);
		
	}
	
	/*
	 * Step definition for the step
	 * "user verifies the return value on the betting receipt"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@And("^user verifies the return value on the betting receipt$")
	public void user_verifies_the_return_value_on_the_betting_receipt() throws Throwable {
		
		//Select dropdown icon to view betting information
		this.footballPage.clickBettingSlipDropdownArrow();
		
		//Verify Bet Returns
		boolean bet_return = this.footballPage.verifyBetReturn();
		Assert.assertTrue("Couldn't find return!", bet_return);
		
	}
	
	/*
	 * Step definition for the step
	 * "user confirms the total stake on the betting receipt"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@And("^user confirms the total stake on the betting receipt$")
	public void user_confirms_the_total_stake_on_the_betting_receipt() throws Throwable {
				
		//Verify the Total Stake
		boolean total_stake = this.footballPage.verifyTotalStake();
		Assert.assertTrue("Couldn't find Total Stake!", total_stake);
	}
	
	/*
	 * Step definition for the step
	 * "user account balance has been updated"
	 * 
	 * @throw Throwable 
	 * 			  exception occurred while executing test
	 */
	@And("^user account balance has been updated$")
	public void user_account_balance_has_been_updated() throws Throwable {
		
		String account_Balance = this.footballPage.getCurrentAccountBalance(); 
		Assert.assertFalse(account_Balance.equals(currentAccountBalance));
			
	}
	
	/*
	 * Method to close browser once test is completed
	 */
	@After
	public void tearDown() {
		driver.quit();
	}
}
