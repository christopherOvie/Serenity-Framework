package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AccountsPage;
import pages.BasePage;
import pages.DashBoardPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.OrdersPage;
import pages.ProductsPage;
import utils.PetCategories;



public class PetStoreSteps extends ScenarioSteps{
	
	BasePage basePage;
	LoginPage loginPage;
	AccountsPage accountPage;
	DashBoardPage dashBoardPage;
	ProductsPage productsPage;
	OrdersPage ordersPage;
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	
	@Step("Signing into login page")
	public LoginPage clickSignOnLink() {
		return	basePage.clickSignOnLink();
	}
	
	@Step("Signing out from the store")
	public DashBoardPage signOut() {

		return basePage.signOut();
	}
	
	@Step("Navigating to Login Page")
	public LoginPage navigateToLoginPage() {

		return basePage.navigateToSignOnPage();
	}

	@Step("Navigating to products page by cliking on : {0} link on header")
	public ProductsPage navigateToProductCategory(PetCategories productCategory) {
		
		return basePage.navigateToProductCategory(productCategory);
	}
	@Step("Navigating to Products Page by clicking on shopping cart")
	public ProductsPage navigateToShoppingCartPage() {

		return basePage.navigateToShoppingCart();
	}

	@Step("Navigating to Help Page")
	public HelpPage navigateToHelpPage() {

		return basePage.navigateToHelpPage();
	}

	@Step("Clicking on Company Logo & navigating to the DashBoard")
	public DashBoardPage navigateToDashBoard() {
		
		return basePage.navigateToDashBoard();
	}
	
	@Step("Navigating to Accounts Page")
	public AccountsPage navigateToMyAccountsPage() {

		return basePage.navigateToAccountPage();
	}

	@Step("Searching for product: {0}")
	public ProductsPage searchForProduct(String productName) {

		return basePage.searchForProduct(productName);
	}
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * login PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("gettig invalid login message")
	public String getMessageOnInvalidLogin() {
	return	loginPage.getMessageOnInvalidLogin();
		
	}
	
	@Step("navigating to ser registration page")
	public AccountsPage navigateToRegistrationPage() {
	return	loginPage.navigateToRegistrationPage();
		
	}
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * Account PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("Logging into the application with userName: {0} & passsword: {1}")
	public DashBoardPage doLogin(String username,String password) {
		
		return	loginPage.doLogin(username, password);
	}
	/*
	 * account page spteps
	 * 
	 * 
	 */
	@Step("adding new user information with  with userName: {0} & passsword: {1} & repeatPassword{2}")
	public AccountsPage addNewUserInformation(String username,String password,String repeatPassword) {
	return	accountPage.addNewUserInformation(username, password, repeatPassword);
		
	}
	
	@Step("Adding account information- firstname:{0} , lastName:{1}," +
			 " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, "  +
			 "state:{7}, zip:{8}, country:{9} ")
	public AccountsPage addAccountInformation(String firstname, String lastname, String email, String phoneNumber
			, String address1, String address2, String city, 
			String state,String zip,String country) {
					return	accountPage.addAccountInformation(firstname, lastname, email,
							phoneNumber, address1, address2, city, state, zip, country);
			}
	@Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
	public AccountsPage addProfileInformation(String language,
            String category,
            boolean myList,
            boolean myBanner) {
		return accountPage.addProfileInformation(language, category, myList, myBanner);
	}
	
	@Step("click saved account information")
	public DashBoardPage clickSavedAccountInformation() {
		
		return	accountPage.clickSavedAccountInformation();
		
	}
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * DASHBOARDPAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("Getting the greeting message")
	public String getGreetingMessage() {
		return dashBoardPage.getGreetingMessage();
	}
	
	@Step("selecting {0} from side bar")
	public ProductsPage selectProductsFromSideBar(PetCategories petCategories) {
		
		return dashBoardPage.selectProductsFromSideBar(petCategories);
	
	}
	
	@Step("selecting {0} from center display")
	public ProductsPage selectProductsFromCenterDisplay(PetCategories petCategories) {
		
		return dashBoardPage.selectProductsFromCenterDisplay(petCategories);
	
	}
	
	/************************************************************************************************
	 * **********************************************************************************************
	 * 
	 * PRODUCT PAGE STEPS
	 * 
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("selecting a pet with petcategory {0} , and petname {1}")
	public ProductsPage selectPetByName(PetCategories petCategory,String petName) {
	return productsPage.selectPetByName(petCategory, petName);	
	}
	
	@Step("Adding {0} to the shopping cart")
	public ProductsPage addToCartSpecificProducts(String specificProductName) {
		
	return productsPage.addToCartSpecificProducts(specificProductName);
	}
	@Step("selecting a pet{0} by viewing details and adding it to cart")
	public ProductsPage addToCartByViewingItemDetails(String specificProduct
			, String...details) {
		return productsPage.addToCartByViewingItemDetails(specificProduct, details);
	}
	
	
	@Step("selecting {0} name from the search result")
	public  ProductsPage selectProductFromSearchTable(String productName) {
		return	productsPage.selectProductFromSearchTable(productName);
	
	}
	@Step("interacting with shopping cart")
	public ProductsPage shoppingCart(String productDescription,int quantity) {
		return	productsPage.shoppingCart(productDescription, quantity);
	}

	@Step("Remove {0} item from shopping cart")
	public boolean removeItemFromCart(String productName) {
		return productsPage.removeItemFromCart(productName);
		
	
   }
	@Step("click proceed to checkout")
	public OrdersPage clickProceedToCeckout() {
		return 	productsPage.clickProceedToCeckout();
	}
	

	/************************************************************************************************
	 * **********************************************************************************************
	 * 	
	 * ORDERS PAGE STEPS
	 * 
	 **************************************************************************************************/
	public OrdersPage enterPaymentAndBillingDetails(String cardType,
			String cardNumber,
			String expiryDate,
			String firstname,
			String lastname,
			String addr1,
			String addr2,
			String city,
			String state,
			String zip,
			String country){
		
		return ordersPage.enterPaymentAndBillingDetails(cardType, 
		   		  cardNumber, 
		   		  expiryDate, 
		   		  firstname, 
		   		  lastname, 
		   		  addr1, 
		   		  addr2, 
		   		  city, 
		   		  state, 
		   		  zip, 
		   		  country);
	                  }
	
	public OrdersPage clickShipToDifferentAddress(){
		return ordersPage.clickShipToDifferentAddress();
	}
	
	public OrdersPage enterShippingInfo(String firstName , String lastName , String addr1
			,String addr2,String city ,String state , String zip, String country){
		return ordersPage.enterShippingInfo(firstName, lastName, addr1, addr2, city, state, zip, country);
		
	}
	@Step("clicking on Continue Button")
	public OrdersPage clickOnContinueBtn(){
		return ordersPage.clickOnContinueBtn();
		
	}
	public OrdersPage clickOnConfirmBtn(){
		return ordersPage.clickOnConfirmBtn();	
		
	}
	@Step("Verify if order has been placed")
	public void verifyIfOrderSubmitted(){
		 ordersPage.verifyIfOrderSubmitted();
	
	}
	}
	
	
		

