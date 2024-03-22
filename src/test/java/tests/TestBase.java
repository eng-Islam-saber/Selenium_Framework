package tests;

import java.io.File;
import java.io.IOException;
import java.security.DrbgParameters.Capability;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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

	public static String downloadFolderPath = System.getProperty("user.dir")+"\\Downloads";

	
	public static ChromeOptions  setChromeDriverOption()
	{
	
		ChromeOptions chromeOptions = new ChromeOptions();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content.settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFolderPath);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		return chromeOptions;
	}
	
	
	public static FirefoxOptions  setFireFoxDriverOption()
	{
		
		FirefoxOptions fireFoxOptions = new FirefoxOptions();

		fireFoxOptions.addPreference("browser.download.folderList", 2);
		fireFoxOptions.addPreference("browser.download.dir", downloadFolderPath);
		fireFoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");


		return fireFoxOptions;
	}

	@Parameters( {"browser_Type"} )
	@BeforeSuite
	public void startDriver(@Optional("chrome") String browser)
	{
		System.out.print("browser: "+browser);


		if( browser.equalsIgnoreCase("chrome") )
		{
			WebDriverManager.chromedriver().setup();
			
			driver =  new ChromeDriver(setChromeDriverOption());
		}
		else if( browser.equalsIgnoreCase("Firefox") )
		{
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver(setFireFoxDriverOption());
		}


		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
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
