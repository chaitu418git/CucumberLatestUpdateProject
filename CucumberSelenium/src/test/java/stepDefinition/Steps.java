package stepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;
import utilities.PropertyClass;
import utilities.UtilityMethods;

public class Steps extends Base{
	
	@Before
	public void setUp() throws IOException
	{
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
	  //  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		if(PropertyClass.configProp("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",PropertyClass.configProp("chromepath"));
			driver=new ChromeDriver();
		}
		
	    logger.info("******Chrome Browser was launched******");
	    driver.manage().window().maximize();
		
	}
	@Given("user launches the browser")
	public void user_launches_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		
	    loginpage=new LoginPage(driver);
	    
	}

	@When("user opens the url {string}")
	public void user_opens_the_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(url);
	    logger.info("Opened the url");
	}

	@When("user enters Email as {string}")
	public void user_enters_email_as(String username) {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.setUserName(username);
		logger.info("Entered the username");
	}

	@When("user enters Password as {string}")
	public void user_enters_password_as(String password) {
	    // Write code here that turns the phrase above into concrete actions
	    loginpage.setPassword(password);
	    logger.info("Entered the Password");
	}

	@When("user click on Login Button")
	public void user_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    loginpage.clickLogin();
	    logger.info("Clicked on Login Button");
	}

	@Then("Page Title should be displayed as {string}")
	public void page_title_should_be_displayed_as(String title) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    if(driver.getPageSource().contains("Login was unsuccessful."))
	    {
	    	driver.close();
	    	logger.info("Login Failed");
	    Assert.assertTrue(false);
	    	
	    }
	    else {
	    	logger.info("Login Passed");
	    	Assert.assertEquals(title, driver.getTitle());
		}
	   // Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	    Thread.sleep(3000);
	}

	@When("user click on Logout Button")
	public void user_click_on_logout_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(l)));
	   // Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		loginpage.clickLogout();
		logger.info("Clicked on Logout");
	    Thread.sleep(3000);
	    
	}

	@Then("close the Browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	    logger.info("Browser was closed");
	}
	//customer actions
	@Then("user click on customers menu")
	public void user_click_on_customers_menu() {
		addcust=new AddCustomerPage(driver);
		addcust.clickonCustomerMenu();
		logger.info("Clicked on Customer Menu");
	}
	@Then("click on customers menu item")
	public void click_on_customers_menu_item() {
	   addcust.clickonCustomerMenuItem();
	   logger.info("Clicked on Customer Menu Item");
	}
	@Then("click on Add New Button")
	public void click_on_add_new_button() {
	    addcust.clickonAddNew();
	    logger.info("clicked on Add New Button");
	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    addcust.verifyAddCustPage();
	    logger.info("Verified the Add new customer page display");
	}
	@When("user enters customer info")
	public void user_enters_customer_info() {
		logger.info("*****Adding New Cutomer*******");
	    addcust.setEmail(UtilityMethods.randomString()+"@gmail.com");
	    addcust.setPassword("abc@1234");
	    logger.info("Entered Password");
	    addcust.setFirstname("Tejaswini");
	    addcust.setLastname("Testfly");
	    addcust.selectGender("female");
	    addcust.setDOB("03/24/2022");
	    addcust.setCompanyname("Testing Automation");
	    addcust.taxExempt();
	    addcust.newsLetterClick();
	    addcust.selectnewsletter("Test store 2");
	    addcust.setAdminComments("test Comments");
	}
	@When("click on Save Button")
	public void click_on_save_button() {
		logger.info("*****Saving the new Customer*******");
	 addcust.clickOnSaveButton();
	}
	@Then("user can view confirmation message as {string}")
	public void user_can_view_confirmation_message_as(String message) {
	    addcust.verifySuccessMessage(message);
	    logger.info("*****Verified Succes Message*******");
	}
//Search customer email actions
	@Given("enter customer Email")
	public void enter_customer_email() {
		logger.info("*****Searching the Cutomer by email*******");
	   searchCust=new SearchCustomer(driver);
	   searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {
	    searchCust.clickonSearchButton();
	    logger.info("*****Clicked on search button*******");
	    Thread.sleep(3000);
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	    logger.info("*****Searched customer if found in the table******");
	}

}
