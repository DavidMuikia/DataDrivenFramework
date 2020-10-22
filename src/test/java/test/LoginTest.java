package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
WebDriver driver;
	
	ExcelReader reader = new ExcelReader(".//data//TF_TestData.xlsx");
	String userName = reader.getCellData("LoginInfo", "UserName", 2);
	String password = reader.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.driver();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashBoardElement();
		
		BrowserFactory.tearDown();
		
	}

}
