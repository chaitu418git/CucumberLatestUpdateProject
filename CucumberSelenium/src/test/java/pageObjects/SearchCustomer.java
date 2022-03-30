package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {
	public static WebDriver ldriver;
    WaitHelper waithelper;
	public SearchCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstname;
	
	@FindBy(how = How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastname;
	
	@FindBy(how = How.ID,using="search-customers")
	@CacheLookup
	WebElement btn_Search;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	static By tableColumnHeaders=By.xpath("//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th");
	//By tableColumnHeadersText=By.xpath(tableColumnHeaders+"")
	
	public void setEmail(String email)
	{
		waithelper.waitForVisibilityOfElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String fname)
	{
		waithelper.waitForVisibilityOfElement(txtFirstname, 30);
		txtEmail.clear();
		txtEmail.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		waithelper.waitForVisibilityOfElement(txtLastname, 30);
		txtEmail.clear();
		txtEmail.sendKeys(lname);
	}
	public void clickonSearchButton()
	{
		btn_Search.click();
	}

	public static int getColumnIndex(String columnName) {
		
		int columns = ldriver.findElements(tableColumnHeaders).size();
		int indexOfQuanity = 0;
		for (int i = 1; i <= columns; i++) {
			if (ldriver.findElement(By.xpath("//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th["+i+"]")).getText().equalsIgnoreCase(columnName)) {
				indexOfQuanity = i;
				break;
			}
		}
		return indexOfQuanity;

	}
	public int getNoOfRows()
	{
		return tableRows.size();
	}
	public int getNoOfColumns()
	{
		return tableColumns.size();
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		int columnNumber=getColumnIndex("Email");
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td["+columnNumber+"]")).getText();
		System.out.println(emailid);
		if(emailid.equalsIgnoreCase(email))
		{
			flag=true;
		}
		}
		return flag;
	}
}
