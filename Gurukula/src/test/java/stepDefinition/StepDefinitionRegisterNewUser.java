package stepDefinition;

import objectRepository.HomePage;
import objectRepository.RegistrationPage;
import objectRepository.UpdateAccountSettingsPage;

import org.junit.Assert;

import cucumber.Log;
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

	// Register New User

	@Given("^User clicks on Register in Accounts Menu$")
	public void user_clicks_on_Register_in_Accounts_Menu() throws Throwable {
		Log.info("Clicking on Account Menu");
		home.getAccountMenu().click();
		home.getUserRegistrationFromAccountMenu().click();
	}

	@When("^User enters the Registration details$")
	public void user_enters_the_Registration_details() throws Throwable {
		
		register.getLoginIdForNewUserRegistration().sendKeys("akshatnarang");
		register.getEmailIdForNewUserRegistration().sendKeys(
				"akshat55narang@gmail.com");
		register.getPasswordForNewUserRegistration().sendKeys("liverpoolFC");
		register.getPasswordConfirmationForNewUserRegistration().sendKeys(
				"liverpoolFC");
		

	}

	@When("^clicks on Register$")
	public void clicks_on_Register() throws Throwable {
		Log.info("Clicking on Registration Button");
		register.getRegisterButtonForNewUserRegistration().click();
	}

	@Then("^User should register his/her account successfully$")
	public void user_should_register_his_her_account_successfully()
			throws Throwable {
		
		Assert.assertNotEquals("Registration failed! Please try again later.",
				register.getRegistrationFailureMessage().getText());

	}

	@Then("^Register button should be disabled$")
	public void register_button_should_be_disabled() throws Throwable {
		Assert.assertFalse(register.getRegisterButtonForNewUserRegistration()
				.isEnabled());
	}

	@When("^User doesnot enter all the mandatory fields$")
	public void user_doesnot_enter_all_the_mandatory_fields() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^User enters login name \"([^\"]*)\"$")
	public void user_enters_login_name(String login) throws Throwable {
		if (login.equals("AkshatNarang")) {
			register.getLoginIdForNewUserRegistration().sendKeys(login);

		} else if (login.equals("akshatnarang@")) {
			register.getLoginIdForNewUserRegistration().sendKeys(login);
		}

	}

	@When("^User enters \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_enters_as(String attribute, String value) throws Throwable {
		if (attribute.equals("login")) {
			register.getLoginIdForNewUserRegistration().sendKeys(value);

		} else if (attribute.equals("email")) {
			register.getEmailIdForNewUserRegistration().sendKeys(value);

		} else if (attribute.equals("password")) {
			register.getPasswordForNewUserRegistration().sendKeys(value);

		} else if (attribute.equals("confirmpassword")) {
			register.getPasswordConfirmationForNewUserRegistration().sendKeys(value);

		}
	}

	@Then("^User should receive an error message for login name \"([^\"]*)\"$")
	public void user_should_receive_an_error_message_for_login_name(
			String message) throws Throwable {
		if (message.equals("Your login cannot be longer than 50 characters.")) {
			Assert.assertEquals(
					"Your login cannot be longer than 50 characters.", register
							.getLoginFailureMessage().getText());
		} else if (message
				.equals("Your login can only contain lower-case letters and digits.")) {
			Assert.assertEquals(
					"Your login can only contain lower-case letters and digits.",
					register.getLoginFailureMessage().getText());
		}

	}

	@When("^User enters password \"([^\"]*)\"$")
	public void user_enters_password(String arg1) throws Throwable {

	}

	@Then("^User should receive an error message \"([^\"]*)\" for Registering a New User$")
	public void user_should_receive_an_error_message_for_Registering_a_New_User(
			String errormessage) throws Throwable {
		if (errormessage
				.equals("Your login cannot be longer than 50 characters.")) {
			Assert.assertTrue(register.getLoginFailureMessage().getText().equals(errormessage));
		}

		else if (errormessage
				.equals("Your e-mail cannot be longer than 50 characters.")) {
			
			Assert.assertTrue(register.getMessageFailureChecks().size()!=0);
		} else if (errormessage
				.equals("Your e-mail is required to be at least 5 characters.")) {
			
			Assert.assertTrue(register.getEmailFailureMessage().getText().equals(errormessage));
			
		} else if (errormessage.equals("Your e-mail is invalid.")) {
			
			Assert.assertTrue(register.getEmailFailureMessage().getText().equals(errormessage));
		} else if (errormessage
				.equals("Your password cannot be longer than 50 characters.")) {
			
			Assert.assertTrue(register.getPasswordFailureMessage().getText().equals(errormessage));
		} else if (errormessage
				.equals("Your password is required to be at least 5 characters.")) {
			
			Assert.assertTrue(register.getPasswordFailureMessage().getText().equals(errormessage));
			
		} else if (errormessage
				.equals("Your confirmation password is required to be at least 5 characters.")) {
			
			Assert.assertTrue(register.getPasswordConfirmationFailureMessage().getText().equals(errormessage));
			
		} else if (errormessage
				.equals("Your confirmation password cannot be longer than 50 characters.")) {
			Assert.assertTrue(register.getPasswordConfirmationFailureMessage().getText().equals(errormessage));
		}
		else if (errormessage.equals("The password and its confirmation do not match!")){
			Assert.assertTrue(register.getPasswordMismatchMessage().getText().equals(errormessage));
		}
	}

	@Given("^User enters login as \"([^\"]*)\"$")
	public void user_enters_login(String login) throws Throwable {
	    register.getLoginIdForNewUserRegistration().sendKeys(login);
	}

	@Given("^USer enters email as \"([^\"]*)\"$")
	public void user_enters_email(String email) throws Throwable {
	    register.getEmailIdForNewUserRegistration().sendKeys(email);
	}

	
	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws Throwable {
	   register.getPasswordForNewUserRegistration().sendKeys(password);
	}

	@When("^User enters confirm password as \"([^\"]*)\"$")
	public void user_enters_confirm_password_as(String confirmpassword) throws Throwable {
	   register.getPasswordConfirmationForNewUserRegistration().sendKeys(confirmpassword);
	   register.getRegisterButtonForNewUserRegistration().click();
	}
	
}
