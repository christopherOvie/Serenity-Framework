package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.Steps;
import steps.PetStoreSteps;

@RunWith(SerenityRunner.class)
public class LoginPageTests {

	@Managed
	WebDriver driver;

	@Steps
	PetStoreSteps shopper;

	@Test
	@Title("verify if a user can login successfully into the store with valid credential")
	public void verifyIfLoginIsSuccessful() {
		shopper.navigateToLoginPage();
		shopper.doLogin("test", "test");

		String greetingMessage = shopper.getGreetingMessage();
		System.out.println(greetingMessage);
		assertEquals("Welcome test!", greetingMessage);
		assertThat(greetingMessage).contains("Welcome");
		
		// Test case 1: Text contains "hello"
//	    String text1 = "hello world";
//	    String result1 = processor.processText(text1);
//	    if (text1.contains("hello")) {
//	        assertEquals("Contains greeting", result1);
//	    } else {
//	        assertEquals("Does not contain greeting", result1);
//	    }

	}

	@Test
	@Title("verify if the user can sign out successfully")
	public void verifyIfUserCanLogoutIsSuccessful() {
		shopper.navigateToLoginPage();

		shopper.doLogin("test", "test");

		shopper.signOut();

	}

	@Test
	@Title("verify if <b> <i> Invalid username or password. Signon failed.  </i> </b> is displayed "
			+ "for invalid credentials ")
	public void verifyMessageIsDisplayedForInvalidLogin() {

		shopper.navigateToLoginPage();

		shopper.doLogin("test", "testing");

		
		String expectedMessage= "Invalid username or password. Signon failed.";
		String invalidMessage = shopper.getMessageOnInvalidLogin();
		System.out.println(invalidMessage);
		assertEquals("Invalid username or password. Signon failed.", invalidMessage);
		assertThat(invalidMessage).contains("Invalid username or password.");
		 if (expectedMessage.contains("hello")) {
	            assertEquals("Signon failed", invalidMessage);
	        } else {
	            assertEquals("Does not contain Signon failed message", invalidMessage);
	        }
		
	}
	
	// Test case 1: Text contains "hello"
//    String text1 = "hello world";
//    String result1 = processor.processText(text1);
//    if (text1.contains("hello")) {
//        assertEquals("Contains greeting", result1);
//    } else {
//        assertEquals("Does not contain greeting", result1);
//    }

}
