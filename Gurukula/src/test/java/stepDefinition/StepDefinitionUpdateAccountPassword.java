package stepDefinition;


import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import objectRepository.HomePage;
import objectRepository.UpdateAccountPasswordPage;
import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class StepDefinitionUpdateAccountPassword {

	TestContext testContext;
	public UpdateAccountPasswordPage updateaccountpassword;
	public HomePage home;
	public WebDriverWait wait;
	
	public StepDefinitionUpdateAccountPassword(TestContext test){
		testContext = test;
		updateaccountpassword = testContext.getPageObjectManager().getUpdateAccountPasswordPage();
		home = testContext.getPageObjectManager().getHomePage();
		
	}
	
	
	
	
	@Given("^User opens Password Menu$")
	public void user_opens_Password_Menu() throws Throwable {
		wait = testContext.getWebDriverManager().getExplicitWaitForElement(home.getListItemPasswordFromAccountsMenu(), "visibility");
	    home.getListItemPasswordFromAccountsMenu().click();
	}

	@When("^User enters New Password as \"([^\"]*)\"$")
	public void user_enters_New_Password_as(String password) throws Throwable {
	    updateaccountpassword.getNewPasswordInput().sendKeys(password);
	}

	@When("^User enters matching Confirmation Password as \"([^\"]*)\"$")
	public void user_enters_matching_Confirmation_Password_as(String confirmpassword) throws Throwable {
	    updateaccountpassword.getNewConfirmPasswordInput().sendKeys(confirmpassword);
	}

	@When("^User clicks on Save Button$")
	public void user_clicks_on_Save_Button() throws Throwable {
	    updateaccountpassword.getSaveButton().click();
	}

	@Then("^User the new Password should be updated successfully with message \"([^\"]*)\"\\.$")
	public void user_the_new_Password_should_be_updated_successfully(String message) throws Throwable {
		
		org.junit.Assert.assertEquals(message, updateaccountpassword.getUpdateSuccessMessage().getText());
	}
	

	@Then("^User should receive an error message \"([^\"]*)\"$")
	public void user_should_receive_an_error_message(String errormessage) throws Throwable {
	    if(errormessage.equals("Your password is required to be at least 5 characters.")){
	    	org.junit.Assert.assertEquals(errormessage, updateaccountpassword.getNewPasswordLeastCharErrorMessage().getText());
	    }
	    else if (errormessage.equals("Your password cannot be longer than 50 characters.") ){
	    	org.junit.Assert.assertEquals(errormessage, updateaccountpassword.getNewPasswordMaximumCharErrorMessage().getText());
	    }
	    else if (errormessage.equals("Your confirmation password is required to be at least 5 characters.") ){
	    	org.junit.Assert.assertEquals(errormessage, updateaccountpassword.getNewPasswordLeastCharErrorMessage().getText());
	    }
	    else if (errormessage.equals("Your confirmation password cannot be longer than 50 characters.") ){
	    	org.junit.Assert.assertEquals(errormessage, updateaccountpassword.getNewPasswordMaximumCharErrorMessage().getText());
	    }
	    else if (errormessage.equals("The password and its confirmation do not match!")){
	    	//The password and its confirmation do not match!
	    	org.junit.Assert.assertEquals(errormessage, updateaccountpassword.getPasswordMismatchErrorMessage().getText());
	    }
	}

	
}
