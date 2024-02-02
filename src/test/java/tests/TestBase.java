package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

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
	
	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException 
	{
		if( result.getStatus() == ITestResult.FAILURE ) 
		{
			String path = "./Screenshots/"+result.getName()+"_Failure.png";
			Helper.captureScreenshot(driver, path);
		}
	
		
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
