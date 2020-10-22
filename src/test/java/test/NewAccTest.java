package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class NewAccTest {
WebDriver driver;
	
ExcelReader reader = new ExcelReader(".//data//TF_TestData.xlsx");
String userName = reader.getCellData("LoginInfo", "UserName", 2);
String password = reader.getCellData("LoginInfo", "Password", 2);

	
	@Test
	public void OpenANewAccount() {
		
		driver = BrowserFactory.driver();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);
		loginPage.clickSignInButton();
}
	}
