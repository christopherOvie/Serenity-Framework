package pages;

import utils.PetCategories;

public class DashBoardPage extends BasePage{

	private static final String GREETINGS_MSG = "//div[@id='Content']//div[contains(text(),'Welcome')]";
	
	// Product Quick Links for sidebar display
		private static final String SIDEBAR_FISH_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'FISH')]";

		private static final String SIDEBAR_DOGS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'DOGS')]";

		private static final String SIDEBAR_REPTILES_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'REPTILES')]";

		private static final String SIDEBAR_CATS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'CATS')]";

		private static final String SIDEBAR_BIRDS_LINK = "//*[@id='SidebarContent']/a[contains(@href , 'BIRDS')]";
	
		
		// Product Quick Links for Center display
		private static final String CENTER_IMAGE = "div[id='MainImageContent'] area[href$='BIRDS']:nth-child(1)";
		

		private static final String FISH_IMAGE = "div[id='MainImageContent'] area[href$='FISH']";

		private static final String DOGS_IMAGE = "div[id='MainImageContent'] area[href$='DOGS']";

		private static final String REPTILES_IMAGE = "div[id='MainImageContent'] area[href$='REPTILES']";

		private static final String CATS_IMAGE = "div[id='MainImageContent'] area[href$='CATS']";

		private static final String BIRDS_IMAGE = "div[id='MainImageContent'] area[href$='CATS']+area[href$='BIRDS']";
	/*
	 * get the greetingd message
	 * 
	 */
	public String getGreetingMessage() {
		
	return	waitFor(GREETINGS_MSG).$(GREETINGS_MSG).getText();
	}
	/**
	 * Select product category from Images displayed on side bar
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromSideBar(PetCategories petCategories) {
		switch (petCategories) {
		case FISH:
			    $(SIDEBAR_FISH_LINK).click();
			    return this.switchToPage(ProductsPage.class);
		case DOGS:
			 $(SIDEBAR_DOGS_LINK).click();
			    return this.switchToPage(ProductsPage.class);
		case REPTILES:
			 $(SIDEBAR_REPTILES_LINK).click();
			    return this.switchToPage(ProductsPage.class);
		case CATS:
			 $(SIDEBAR_CATS_LINK).click();
			    return this.switchToPage(ProductsPage.class);
		case BIRDS:
			 $(SIDEBAR_BIRDS_LINK).click();
			    return this.switchToPage(ProductsPage.class);
		default:
			break;
		}
		return null;
	}
	
	/**
	 * Select product category from Images displayed on dashboard
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromCenterDisplay(PetCategories petCategories) {
		switch (petCategories) {
		case FISH:
			
			$(FISH_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case DOGS:
			
			//withAction().moveToElement( $(DOGS_IMAGE) ).click().build().perform();
			$(DOGS_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case CATS:
			
			$(CATS_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case BIRDS:
			
			$(BIRDS_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		case REPTILES:
			
			$(REPTILES_IMAGE).click();

			return this.switchToPage(ProductsPage.class);

		default:
			break;
		}
		return null;

	}
}
