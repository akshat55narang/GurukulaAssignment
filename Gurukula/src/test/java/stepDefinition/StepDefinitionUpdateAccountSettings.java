package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePage;
import objectRepository.UpdateAccountSettingsPage;
import cucumber.Log;
import cucumber.TestContext;
import cucumber.api.java.en.*;

public class StepDefinitionUpdateAccountSettings {

	TestContext testContext;
	public HomePage home;
	public WebDriverWait wait;
	public UpdateAccountSettingsPage updateaccountsettings;
	
	public StepDefinitionUpdateAccountSettings(TestContext test) {
		testContext=test;
		home = testContext.getPageObjectManager().getHomePage();
		updateaccountsettings = testContext.getPageObjectManager().getUpdateAccountSettingsPage();
	}
	@Given("^User opens Settings Menu$")
	public void user_opens_Settings_Menu() throws Throwable {
		updateaccountsettings.getListItemSettings().click();
		wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(updateaccountsettings.getFirstNameInput()));
	}

	@When("^User updates all the settings$")
	public void user_updates_all_the_settings() throws Throwable {
	    updateaccountsettings.getFirstNameInput().sendKeys("FirstName");
	    updateaccountsettings.getLastNameInput().sendKeys("LAstName");
	    updateaccountsettings.getInputEmail().clear();
	    updateaccountsettings.getInputEmail().sendKeys("akshat55narang@gmail.com");
	    
	   
	}

	@When("^User clicks on Save$")
	public void user_clicks_on_Save() throws Throwable {
	    updateaccountsettings.getSaveButton().click();
	  }

	@Then("^User should receive a confirmation of updated settings with the updated Settings$")
	public void user_should_receive_a_confirmation_of_updated_settings_with_the_updated_Settings() throws Throwable {
	    Assert.assertTrue(updateaccountsettings.getSaveFailureMessage().equals("Settings saved!"));
	}

	@Then("^The maximum length of First Name and Last Name should be (\\d+)$")
	public void the_maximum_length_of_First_Name_and_Last_Name_should_be(int arg1) throws Throwable {
	    Assert.assertTrue(updateaccountsettings.getFirstNameInput().getAttribute("ng-maxlength").equals("50"));
	    Assert.assertTrue(updateaccountsettings.getLastNameInput().getAttribute("ng-maxlength").equals("50"));
	}

	@When("^User enters email \"([^\"]*)\"$")
	public void user_enters_email(String email) throws Throwable {
	    WebElement emailaddress =  updateaccountsettings.getInputEmail();
		if(email.equals("adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com")){
	    	emailaddress.clear();
	    	emailaddress.sendKeys(email);
	    	try {
				Log.info(updateaccountsettings.getLessCharactersErrorMessage().getText());
			} catch (Exception e) {
				Log.info("The Element containing the email was not found.");
				e.printStackTrace();
			}
	    }
	    else if(email.equals("a@c")){
	    	emailaddress.clear();
	    	emailaddress.sendKeys(email);
	    	Log.info(updateaccountsettings.getLessCharactersErrorMessage().getText());
	    }
	    else if(email.equals("a")){
	    	emailaddress.clear();
	    	emailaddress.sendKeys(email);
	    	Log.info(updateaccountsettings.getLessCharactersErrorMessage().getText());
	    }
	}
	
	@Then("^User should receive an error message for email \"([^\"]*)\"$")
	public void user_should_receive_an_error_message_for_email(String error) throws Throwable {
	    if(error.equals("Your e-mail cannot be longer than 50 characters.")){
	    	Assert.assertTrue(updateaccountsettings.getFailureChecks().size()!=0);
	    }
	    else if(error.equals("Your e-mail is invalid.")){
	    	Assert.assertTrue(updateaccountsettings.getLessCharactersErrorMessage().getText().equals("Your e-mail is invalid."));
	    }
	    else if(error.equals("Your e-mail is required to be at least 5 characters.")){
	    	Assert.assertTrue(updateaccountsettings.getLessCharactersErrorMessage().getText().equals("Your e-mail is required to be at least 5 characters."));
	    }
	}
}
