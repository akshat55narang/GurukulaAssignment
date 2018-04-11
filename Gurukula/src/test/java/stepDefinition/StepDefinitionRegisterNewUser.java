package stepDefinition;

import objectRepository.HomePage;
import objectRepository.RegistrationPage;
import objectRepository.UpdateAccountSettingsPage;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionRegisterNewUser {

	TestContext testContext;
	public HomePage home;
	public RegistrationPage register;
	
	public StepDefinitionRegisterNewUser(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		register = testContext.getPageObjectManager().getRegistrationPage();
	}
	
	//Register New User
	
		@Given("^User clicks on Register in Accounts Menu$")
		public void user_clicks_on_Register_in_Accounts_Menu() throws Throwable {
		    home.getAccountMenu().click();
			home.getUserRegistrationFromAccountMenu().click();
		}

		@When("^User enters the Registration details$")
		public void user_enters_the_Registration_details() throws Throwable {
			//register = page.getRegistrationPage();
			register.getLoginIdForNewUserRegistration().sendKeys("");
			
			register.getLoginIdForNewUserRegistration().sendKeys("akshatnarang");
			register.getEmailIdForNewUserRegistration().sendKeys("akshat55narang@gmail.com");
			register.getPasswordForNewUserRegistration().sendKeys("liverpoolFC");
			register.getPasswordConfirmationForNewUserRegistration().sendKeys("liverpoolFC");
			
			}

		@When("^clicks on Register$")
		public void clicks_on_Register() throws Throwable {
			register.getRegisterButtonForNewUserRegistration().click();
		}

		@Then("^User should register his/her account successfully$")
		public void user_should_register_his_her_account_successfully() throws Throwable {
			Assert.assertEquals("Registration failed! Please try again later.", register.getRegistrationFailureMessage().getText());
			
		}

		@Then("^Register button should be disabled$")
		public void register_button_should_be_disabled() throws Throwable {
		    Assert.assertFalse(register.getRegisterButtonForNewUserRegistration().isEnabled());
		}
		
		@When("^User doesnot enter all the mandatory fields$")
		public void user_doesnot_enter_all_the_mandatory_fields() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		@When("^User enters login name \"([^\"]*)\"$")
		public void user_enters_login_name(String login) throws Throwable {
		    if(login.equals("adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")){
		    	register.getLoginIdForNewUserRegistration().sendKeys(login);
		    	   
		    }
		    else if(login.equals("AkshatNarang")){
		    	register.getLoginIdForNewUserRegistration().sendKeys(login);
		    	   
		    }
		    else if(login.equals("akshatnarang@")){
		    	register.getLoginIdForNewUserRegistration().sendKeys(login);
		    }
		    
		}

		@Then("^User should receive an error message for login name \"([^\"]*)\"$")
		public void user_should_receive_an_error_message_for_login_name(String message) throws Throwable {
		    if(message.equals("Your login cannot be longer than 50 characters.")){
		    	Assert.assertEquals("Your login cannot be longer than 50 characters.", register.getLoginFailureMessage().getText());
		    }
		    else if(message.equals("Your login is required to be at least 5 characters.")){
		    	Assert.assertEquals("Your login can only contain lower-case letters and digits.", register.getLoginFailureMessage().getText());
		    }
		    
		}
		
		@When("^User enters password \"([^\"]*)\"$")
		public void user_enters_password(String arg1) throws Throwable {
			

		}

		@When("^User enters password \"([^\"]*)\" and password confirmation \"([^\"]*)\"$")
		public void user_enters_password_and_password_confirmation(String arg1, String arg2) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}

		
		
}
