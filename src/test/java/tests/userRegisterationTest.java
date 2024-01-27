package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterationPage;

public class userRegisterationTest extends TestBase
{
	
	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	
	@Test
	public void UserCanRegisterSuccessfully()
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegisterationPage();
		
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegister("Islam", "Mohamed", "Islam@gmail.com", "123456789");
		
		Assert.assertTrue( userRegisterationPageObject.registerationMessage.getText().contains("Your registration completed") );
	}
}
