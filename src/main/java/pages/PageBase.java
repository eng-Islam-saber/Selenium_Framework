package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	//https://demo.nopcommerce.com/
	
	//driver will not be accessed outside package ,but accessed outside package by sub classes only
	protected WebDriver driver;
	
	protected JavascriptExecutor js ;
	
	public PageBase(WebDriver driver)
	{
		//initializing all elements 
		PageFactory.initElements(driver, this);
	}
	
	
	protected static void clickButton(WebElement button)
	{
		button.click();
	}
	
	
	protected static void setTextElementText(WebElement txtElement, String value)
	{
		txtElement.sendKeys( value );
	}
	
	protected  void scrollPageToBottom()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	
}
