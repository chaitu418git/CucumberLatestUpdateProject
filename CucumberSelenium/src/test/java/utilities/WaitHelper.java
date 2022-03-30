package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
public WebDriver driver;
public WaitHelper(WebDriver driver)
{
	this.driver=driver;
}
@SuppressWarnings("deprecation")
public void waitForVisibilityOfElement(WebElement element,long timeOutInSeconds)
{
	new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
}
}
