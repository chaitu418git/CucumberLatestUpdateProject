package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class LoginPage {
public WebDriver ldriver;
WaitHelper waithelper;

public LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	waithelper=new WaitHelper(ldriver);
}
@FindBy(id="Email")
@CacheLookup
WebElement txtEmail;

@FindBy(id = "Password")
@CacheLookup
WebElement txtPassword;

@FindBy(xpath = "//button[contains(text(),'Log in')]")
@CacheLookup
WebElement btnLogin;

@FindBy(linkText = "Logout")
@CacheLookup
WebElement lnkLogOut;

By logOut=By.xpath("//a[text()='Logout']");

public void setUserName(String uname)
{
	txtEmail.clear();
	txtEmail.sendKeys(uname);
}
public void setPassword(String password)
{
	txtPassword.clear();
	txtPassword.sendKeys(password);
}

public void clickLogin()
{
	btnLogin.click();
}
public void clickLogout() 
{
//	Actions action=new Actions(ldriver);
	//action.moveToElement(lnkLogOut);
	//new WebDriverWait(ldriver, 30).until(ExpectedConditions.elementToBeClickable(lnkLogOut));
	waithelper.waitForVisibilityOfElement(lnkLogOut, 30);
	lnkLogOut.click();
}

}
