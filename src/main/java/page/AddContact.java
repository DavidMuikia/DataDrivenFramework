package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContact extends BasePage {

	WebDriver driver;

	public AddContact(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='side-menu']/li[2]/a/span")
	WebElement link;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Contact')]")
	WebElement addLink;
	@FindBy(how = How.ID, using = "account")
	WebElement accountname;
	@FindBy(how = How.ID, using = "company")
	WebElement companyname;
	@FindBy(how = How.ID, using = "email")
	WebElement emailaddress;
	@FindBy(how = How.ID, using = "phone")
	WebElement phoneNo;
	@FindBy(how = How.ID, using = "address")
	WebElement streetaddress;
	@FindBy(how = How.ID, using = "city")
	WebElement cityname;
	@FindBy(how = How.ID, using = "state")
	WebElement statename;
	@FindBy(how = How.ID, using = "zip")
	WebElement zipcode;
	@FindBy(how = How.XPATH, using = "//input[@type='search']")
	WebElement tag;
	@FindBy(how = How.ID, using = "submit")
	WebElement submitbutton;

	public void FillOutContact(String AccName, String CompName, String Email, String Phone, String Address, String City,
			String State, String Zip, String Tag) throws InterruptedException {
		link.click();
		Thread.sleep(2000);
		addLink.click();
		Thread.sleep(1000);
		accountname.sendKeys(AccName);
		Thread.sleep(1000);
		companyname.sendKeys(CompName);
		emailaddress.sendKeys(Email);
		phoneNo.sendKeys(Phone);
		streetaddress.sendKeys(Address);
		cityname.sendKeys(City);
		statename.sendKeys(State);
		Thread.sleep(1000);
		zipcode.sendKeys(Zip);
		Thread.sleep(1000);
		tag.sendKeys(Tag);
		Thread.sleep(1000);
		submitbutton.click();
	
	}
}