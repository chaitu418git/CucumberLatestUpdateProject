package pageObjects;

import java.io.Console;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnk_customer_menu=By.xpath("(//p[contains(text(),'Customers')])[1]");
	By lnk_customer_menuitem=By.xpath("(//p[contains(text(),'Customers')])[2]");
	By addnew=By.xpath("//a[@class='btn btn-primary']");
	By verify_AddCustPage=By.xpath("//h1[contains(text(),'Add a new customer')]");
	By txt_Email=By.id("Email");
	By txt_Password=By.id("Password");
	By txt_Firstname=By.id("FirstName");
	By txt_LastName=By.id("LastName");
	By radiobut_Male=By.id("Gender_Male");
	By radiobut_Female=By.id("Gender_Female");
	By txt_dateofBirth=By.id("DateOfBirth");
	By txt_Company=By.id("Company");
	By chkbox_TaxExempt=By.id("IsTaxExempt");
	By newsletter=By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[1]");
	By newsletter_dropdownvalues=By.xpath("//div[@id='SelectedNewsletterSubscriptionStoreIds-list']/div/ul/li");
	By txt_adminComments=By.id("AdminComment");
	By btn_save=By.name("save");
	By success_mess=By.xpath("//div[@class='alert alert-success alert-dismissable']/text()[2]");
	
	public void clickonCustomerMenu()
	{
		new WebDriverWait(ldriver, 30).until(ExpectedConditions.presenceOfElementLocated(lnk_customer_menu));
		ldriver.findElement(lnk_customer_menu).click();
	}
	public void clickonCustomerMenuItem() {
		new WebDriverWait(ldriver, 30).until(ExpectedConditions.presenceOfElementLocated(lnk_customer_menuitem));
		ldriver.findElement(lnk_customer_menuitem).click();
	}
	public void clickonAddNew()
	{
		new WebDriverWait(ldriver, 30).until(ExpectedConditions.presenceOfElementLocated(addnew));
		ldriver.findElement(addnew).click();
	}
	public void verifyAddCustPage()
	{
		Assert.assertTrue(ldriver.findElement(verify_AddCustPage).isDisplayed());
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txt_Email).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txt_Password).sendKeys(password);
	}
	public void setFirstname(String firstname)
	{
		ldriver.findElement(txt_Firstname).sendKeys(firstname);
	}
	public void setLastname(String lastname)
	{
		ldriver.findElement(txt_LastName).sendKeys(lastname);
	}
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			ldriver.findElement(radiobut_Male).click();
		}
		else if (gender.equalsIgnoreCase("female"))
		{
			ldriver.findElement(radiobut_Female).click();
		}
	}
	public void setDOB(String dob)
	{
		ldriver.findElement(txt_dateofBirth).sendKeys(dob);
	}
	public void setCompanyname(String companyname)
	{
		ldriver.findElement(txt_Company).sendKeys(companyname);
	}
	public void taxExempt()
	{
		Assert.assertFalse(ldriver.findElement(chkbox_TaxExempt).isSelected());
		ldriver.findElement(chkbox_TaxExempt).click();
	}
	public void newsLetterClick()
	{
		ldriver.findElement(newsletter).click();
	}
	public void selectnewsletter(String newsletter)
	{
		List<WebElement> values=ldriver.findElements(newsletter_dropdownvalues);
		for(WebElement value:values)
		{
			if(value.getText().contains(newsletter))
			{
				value.click();
			}
		}
		
	}
	public void setAdminComments(String admincomment)
	{
		ldriver.findElement(txt_adminComments).sendKeys(admincomment);
	}
	public void clickOnSaveButton()
	{
		ldriver.findElement(btn_save).click();
	}
	public void verifySuccessMessage(String message)
	{
		//new WebDriverWait(ldriver, 30).until(ExpectedConditions.presenceOfElementLocated(success_mess));
		//Assert.assertTrue(ldriver.findElement(success_mess).isDisplayed());
		
		//System.out.println(ldriver.findElement(success_mess).getText());
	Assert.assertEquals(message,ldriver.findElement(success_mess).getText().trim());
		
	}
}
