package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void startDriver()
	{
		driver = WebDriverManager.chromedriver().create();
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
