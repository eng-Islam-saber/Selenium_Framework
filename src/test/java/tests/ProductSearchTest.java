package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;


public class ProductSearchTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	
	@Test
	public void userCanSearchForProduct()
	{
		searchPageObject = new SearchPage(driver);
		searchPageObject.productSearch(productName);
		searchPageObject.openProductDetailsPage();
		
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
		
	}
}
