package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import steps.PetStoreSteps;
import utils.PetCategories;

@RunWith(SerenityRunner.class)
public class Sample {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("Navigating to the signon page")
	public void navigateToSignOnPage() throws InterruptedException {

		shopper.navigateToLoginPage();
		shopper.doLogin("test", "test");
		//shopper.navigateToDashBoard();
	    //shopper.selectProductsFromSideBar(PetCategories.DOGS);
        //shopper.selectPetByName(PetCategories.DOGS, "Bulldog");
	    //shopper.addToCartSpecificProducts("Female Puppy Bulldog");
	    
	   // shopper.addToCartByViewingItemDetails("Female Puppy Bulldog", "Friendly dog from England","Female Puppy Bulldog","Bulldog");
	   
	    shopper.searchForProduct("Bulldog");
	    
	    shopper.selectProductFromSearchTable("Bulldog");
	    shopper.addToCartByViewingItemDetails("Female Puppy Bulldog", "Friendly dog from England","Female Puppy Bulldog","Bulldog");
		   
	    
	 // shopper.shoppingCart("Female Puppy Bulldog", 0);
	   Assert.assertNotEquals(null, shopper.shoppingCart("Female Puppy Bulldog", 6));
	   
	   //shopper.removeItemFromCart("Female Puppy Bulldog");
	   
	   //assertTrue(shopper.removeItemFromCart("Female Puppy Bulldog"));
	    shopper.clickProceedToCeckout();
	   
	}
	
	
	
}
