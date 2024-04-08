package pages;

public class DashBoardPage extends BasePage{

	private static final String GREETINGS_MSG = "//div[@id='Content']//div[contains(text(),'Welcome')]";
	
	/*
	 * get the greetingd message
	 * 
	 */
	public String getGreetingMessage() {
		
	return	waitFor(GREETINGS_MSG).$(GREETINGS_MSG).getText();
	}
}
