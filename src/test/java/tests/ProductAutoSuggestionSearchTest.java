package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductAutoSuggestionSearchTest  extends TestBase
{
	String productName = "Apple";
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	
	@Test
	public void userCanSearchWithAutoSuggestSearchForProduct()
	{
		searchPageObject = new SearchPage(driver);
		searchPageObject.productSearchUsingAutoSuggest(productName);
		productDetailsPageObject = new ProductDetailsPage(driver);
		Assert.assertTrue( productDetailsPageObject.productName.getText().contains(productName) );
	}
}
