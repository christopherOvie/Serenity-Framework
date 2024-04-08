package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AccountsPage;
import pages.BasePage;
import pages.DashBoardPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.PetCategories;



public class PetStoreSteps extends ScenarioSteps{
	
	BasePage basePage;
	LoginPage loginPage;
	AccountsPage accountPage;
	DashBoardPage dashBoardPage;
	ProductsPage productsPage;
	//OrdersPage ordersPage;
	
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
	}
		

