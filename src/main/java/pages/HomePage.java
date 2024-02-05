package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) 
	{
		super(driver);	
	
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[text()='Log out']")
	public WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccountLink;
	
	
	@FindBy(xpath = "//a[text()='Contact us']")
	WebElement contactUsLink;
	
	
	public void openContactUsPage()
	{
		scrollPageToBottom();
		clickButton( contactUsLink );
		
	}
	
	
	public void openRegisterationPage()
	{
		clickButton( registerLink );
		
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
	
	public void openLoginPage()
	{
		clickButton( loginLink );
	}
	
	public void userLogOut()
	{
		clickButton( logoutLink );
	}
	
	

}
