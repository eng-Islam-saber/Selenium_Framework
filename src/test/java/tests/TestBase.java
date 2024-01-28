package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	@Parameters( {"browser_Type"} )
	@BeforeSuite
	public void startDriver(@Optional("chrome") String browser)
	{
		System.out.print("browser: "+browser);
		if( browser.equalsIgnoreCase("chrome") )
		{
			driver =  WebDriverManager.chromedriver().create();
		}
		else if( browser.equalsIgnoreCase("Firefox") )
		{
			driver =  WebDriverManager.firefoxdriver().create();
		}
		
		
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
