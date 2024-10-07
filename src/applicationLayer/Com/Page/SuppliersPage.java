package applicationLayer.Com.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SuppliersPage {
	WebDriver driver;
	//write constructor to access webdriver methods
	public SuppliersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath="(//a[@href='a_supplierslist.php'][normalize-space()='Suppliers'])[2]")
	WebElement objsupplierslink;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-plus ewIcon'])[1]")
	WebElement objclickplus;
	
	@FindBy(xpath="//input[@id='x_Supplier_Number']")
	WebElement objsuppliernumber;
	
	@FindBy(xpath="//input[@id='x_Supplier_Name']")
	WebElement objsuppliersname;
	
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement objaddress;
	
	@FindBy(xpath="//input[@id='x_City']")
	WebElement objcity;
	
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement objcountry;
	
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement objcontactperson;
	
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement objphonenumber;
	
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement objemail;
	
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement objmobilenumber;
	
	@FindBy(xpath="//textarea[@id='x_Notes']")
	WebElement objnotes;
	
	@FindBy(xpath="//button[@id='btnAction']")
	WebElement objclickaddsuppliers;
	
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement objaddnewrecord;
	
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
	WebElement objaddnewsuccess;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement objsearchpanel;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/form/div/div/div/div/input[1]")
	WebElement objentertextbox;
	
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement objsearchbutton;
	
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")
	WebElement objsnreutn;

	public boolean addsuppliers(String suppliername, String address, String city, String country,
			String contactperson, String phonenumber, String email, String mobilenumber, String notes) throws Throwable
	{
		this.objsupplierslink.click();
		this.objclickplus.click();
		String exp=this.objsuppliernumber.getAttribute("value");
		this.objsuppliersname.sendKeys(suppliername);
		this.objaddress.sendKeys(address);
		this.objcity.sendKeys(city);
		this.objcountry.sendKeys(country);
		this.objcontactperson.sendKeys(contactperson);
		this.objphonenumber.sendKeys(phonenumber);
		this.objemail.sendKeys(email);
		this.objmobilenumber.sendKeys(mobilenumber);
		this.objnotes.sendKeys(notes);
		this.objclickaddsuppliers.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		this.objaddnewrecord.click();
		Thread.sleep(2000);
		this.objaddnewsuccess.click();
		Thread.sleep(2000);
		if(!this.objentertextbox.isDisplayed())
			//click search panel button
			this.objsearchpanel.click();
		this.objentertextbox.clear();
		this.objentertextbox.sendKeys(exp);
		this.objsearchbutton.click();
		Thread.sleep(3000);
		String act = this.objsnreutn.getText();
		Thread.sleep(2000);
		
		
		if(exp.equals(act))
		{
			Reporter.log("Suppliers Add Success::",true);
			return true;
		}
		else
		{
			Reporter.log("Suppliers Add UnSuccess",true);
			return false;
		}
	}
}


