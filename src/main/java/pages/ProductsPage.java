package pages;

import utils.PetCategories;
//ststic imports for Table

import static net.thucydides.core.matchers.BeanMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.pages.components.HtmlTable.inTable;
//import net.thucydides.core.pages.components.HtmlTable.*;

public class ProductsPage extends BasePage {
	private static final String PRODUCT_TABLE = "//*[@id='Catalog']//table";
	//private static final String ANCHOR = "//*[@id='Catalog']//table//td[normalize-space() = '";
	private static final String ANCHOR =  "//table//td[normalize-space(text())='";
	private static final String PROCEED_TO_CHECKOUT = "//div[@id='Cart']/a";
	//private static final String ANCHOR1="//table//td[normalize-space(text())='"; 
	//Syring quanity=="//table//td[normalize-space(text())='Female Puppy Bulldog']//following-sibling::td/input";
	//String total="//table//td[normalize-space(text())='Goldfish ']//parent::tr//img//parent::a";
//       "table//td[normalize-space(text())='";    //div[@id='Cart']/a
	//
	/*
	 * ] select the pet by providing a name
	 * 
	 * @param petcategory
	 * 
	 * @param petname
	 * 
	 * @return
	 * 
	 * 
	 * 
	 */

	public ProductsPage selectPetByName(PetCategories petCategory, String petName) {

		// ensure you are o correct page and correct pet category is displayed for d
		// products
		waitForTextToAppear(petCategory.getValue());

		// filter the row to match the pet
		List<WebElement> rows = inTable($(PRODUCT_TABLE)).filterRows(the("Name", equalTo(petName)));
//to click the link  trying to find a link and perfor
		rows.get(0).findElement(By.tagName("a")).click();

		return this;

	}
	/*
	 *this method add a a pet to the shopping cart
	 *@param specificProductName
	 *@return 
	 * 
	 * 
	 */
	public ProductsPage addToCartSpecificProducts(String specificProductName) {
		
		//    //table//td[normalize-space(text())='Male Adult Bulldog']//parent::tr//a[contains(@href, 'Cart')]
		//String anchor= "table//td[normalize-space(text())='";
		$(PRODUCT_TABLE).shouldContainText(specificProductName);
		String addToCartPartT1= "']//parent::tr//a[contains(@href, 'Cart')]";
		String addToCartButton=ANCHOR  +  specificProductName   +  addToCartPartT1;
		waitFor(addToCartButton).$(addToCartButton).click();
		return this;
		
	}
	/*
	 * add an iitem to cart by viewing details of the pet
	 * @param specificProduct
	 * @param details
	 * @return
	 */
	
	public ProductsPage addToCartByViewingItemDetails(String specificProduct
			, String...details) {
		
		$(PRODUCT_TABLE).shouldContainText(specificProduct);
		
		String viewItemLinkPartT1= "']//parent::tr//a[contains(@href, 'view')]";
		String viewItemLink=  ANCHOR+ specificProduct+ viewItemLinkPartT1;
		
		waitFor(viewItemLink).$(viewItemLink).click();
		waitForAnyTextToAppear(details[0],details [1],details[2]);
		waitFor("//a[@class='Button']").$("//a[@class='Button']").click();
				return this;
		
	}
	/*SElecting product from search result
	 * 
	 * @param productName
	 * @return
	 * 
	 * 
	 */
	public  ProductsPage selectProductFromSearchTable(String productName) {
		
		String searchResultPart1= "']//parent::tr//img//parent::a";
		String searchResultLink=ANCHOR+productName + searchResultPart1;
		waitFor(searchResultLink).$(searchResultLink).click();
		return this;
	}

	public ProductsPage shoppingCart(String productDescription,int quantity) {
		String quantityPart1="']//following-sibling::td/input";
		
		String totalCost="']//following-sibling::td[4]";
		String quantityinput=ANCHOR + productDescription + quantityPart1;
		String totalCostLabel=ANCHOR + productDescription+ totalCost;
		//waitFor(quantityinput).$(quantityinput)
		//return ProductsPage;
		
		if(quantity>0) {
			//it is a  float
	      Float totalValueBeforeUpdate = Float.valueOf($(totalCostLabel).getText().substring(1));
		  $(quantityinput).typeAndEnter(Integer.toString(quantity));
		  Float totalValueAfterUpdate = Float.valueOf($(totalCostLabel).getText().substring(1));
		     if(totalValueAfterUpdate < totalValueBeforeUpdate) {
		    	 return null;
		     }
		  
		}
		if(quantity == 0) {
			 $(quantityinput).typeAndEnter(Integer.toString(quantity));
			 waitForAbsenceOf(quantityinput).shouldNotBeVisible(By.xpath(quantityinput));
		}
		return this;	
	}
	/*remove item fro shopping cart
	 * 
	 * 
	 */
	public boolean removeItemFromCart(String productName)
	{
		String removeBtnPart1="']//following-sibling::td[5]/a";
	
		String removeBtn= ANCHOR + productName + removeBtnPart1;
		waitFor(removeBtn).$(removeBtn).click();
		return (waitForAbsenceOf(removeBtn).isElementVisible(By.xpath(removeBtn)));  //do a negation same as return false
		
	}
	/*
	 * click proceed to checkout
	 * 
	 * 
	 */
	
	public OrdersPage clickProceedToCeckout() {
		
		waitFor(PROCEED_TO_CHECKOUT).$(PROCEED_TO_CHECKOUT).click();
		return this.switchToPage(OrdersPage.class);
		
	}
}
