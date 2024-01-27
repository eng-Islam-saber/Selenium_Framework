package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void startDriver()
	{
		
		driver =  WebDriverManager.chromedriver().create();
		
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
