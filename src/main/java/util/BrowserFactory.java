package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver driver() {
		// Set Chrome Driver Properties
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// Create ChromeDriver object and launch chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// return the driver to the test class
		driver.get("https://techfios.com/test/billing/?ng=admin/");
		return driver; 
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
