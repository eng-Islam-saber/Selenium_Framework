package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productSearchList;
	
	@FindBy(xpath = "//div[@class='details']/h2/a")
	WebElement productTitleLink;

	
	public void productSearch(String productName)
	{
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	
	public void openProductDetailsPage()
	{
		clickButton(productTitleLink);
	}
	
	public void productSearchUsingAutoSuggest(String productName)
	{
		setTextElementText(searchTxtBox, productName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(productSearchList.get(0));
	}

}
