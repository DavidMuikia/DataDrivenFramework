package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContact;
import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

WebDriver driver;
	
	ExcelReader reader = new ExcelReader(".//data//TF_TestData.xlsx");
	String userName = reader.getCellData("LoginInfo", "UserName", 2);
	String password = reader.getCellData("LoginInfo", "Password", 2);
	String fullName = reader.getCellData("AddContactInfo", "FullName", 2);
	String company = reader.getCellData("AddContactInfo", "Company Name", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	String tag = reader.getCellData("AddContactInfo", "Tag", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.driver();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);		
		loginPage.clickSignInButton();
		 
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashBoardElement();

		AddContact contact = PageFactory.initElements(driver, AddContact.class);
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(9999);
		contact.FillOutContact(fullName + randomNumber, company, email, phoneNum, address, city, state, zip, tag);
	
		
		BrowserFactory.tearDown();
		
	}

}
