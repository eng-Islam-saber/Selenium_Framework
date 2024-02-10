package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='product-name']/h1")
	public WebElement productName;

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(xpath = "//div[@class='product-price']")
	public WebElement productPrice;
	
	@FindBy(xpath = "//a[text()='Add your review']")
	public WebElement addYourReviewLink;
	
	
	
	public void clickEmailFriendBtn()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openProductReviewsPage()
	{
		clickButton(addYourReviewLink);
	}
	
}
