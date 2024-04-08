package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import steps.PetStoreSteps;

@RunWith(SerenityRunner.class)
public class AccountPageTest {
	@Managed
	WebDriver driver;

	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("add a  new user and verify if the new user can login")
	public void addNewUserAndVerify() throws InterruptedException {
		
		Faker faker = new Faker();
		
		String username2= faker.name().username() ;
		String username ="test" + faker.number().randomNumber(10, false);
		String password = faker.internet().password();
		String repeatPassword =password;
		
		String firstname= faker.name().firstName() ;
		String lastname=faker.name().lastName();
		String email=faker.internet().emailAddress();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String address1 =faker.address().buildingNumber();
		String address2 =faker.address().streetAddress();
		String city =faker.address().city();
		String state =faker.address().state();
		String zip =faker.address().zipCode();
		String country =faker.address().country();
		
		
				
		shopper.navigateToLoginPage();
		shopper.navigateToRegistrationPage();
		shopper.addNewUserInformation(username, password, repeatPassword);
		shopper.addAccountInformation(firstname, lastname, email, phoneNumber, address1, address2, city, state, zip, country);
		shopper.addProfileInformation("english", "DOGS", true, true);
		
		shopper.clickSavedAccountInformation();
		
		shopper.clickSignOnLink();
		//login again with same username and password used in creating account
		
	      shopper.doLogin(username, password);
	     Thread.sleep(5000);
	String greetingMessage=	shopper.getGreetingMessage();
	assertEquals("Welcome " + firstname + "!", greetingMessage);
	//assertEquals("Welcome " + firstname + "!",greetingMessage);
     assertThat(greetingMessage).contains("Welcome " + firstname + "!");
		
		
	}

}
