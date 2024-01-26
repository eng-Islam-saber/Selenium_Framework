package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	//https://demo.nopcommerce.com/
	
	//driver will not be accessed outside package ,but accessed outside package by sub classes only
	protected WebDriver driver;
	
	public PageBase(WebDriver driver)
	{
		//initializing all elements 
		PageFactory.initElements(driver, this);
	}
	
	
}
