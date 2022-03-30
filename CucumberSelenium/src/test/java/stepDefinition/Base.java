package stepDefinition;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class Base {
	public WebDriver driver;
	public LoginPage loginpage;
	public AddCustomerPage addcust;
	public SearchCustomer searchCust;
	public static Logger logger;
	public Properties configProp;
}
