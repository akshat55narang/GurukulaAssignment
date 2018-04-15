package stepDefinition;

import javax.sql.rowset.WebRowSet;

import managers.PageObjectManager;
import managers.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.PasswordResetPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.Log;
import cucumber.TestContext;
import cucumber.api.java.en.*;

public class StepDefinitionPasswordReset {

	public HomePage home;
	public PasswordResetPage passwordreset;
	TestContext testContext;
	
	
	public StepDefinitionPasswordReset(TestContext test) {
		testContext = test;
		home = testContext.getPageObjectManager().getHomePage();
		passwordreset = testContext.getPageObjectManager().getPasswordResetPage();
	}
	
	@When("^User enters registered email \"([^\"]*)\"$")
	public void user_enters_registered_email(String email) throws Throwable {
		Log.info("Entering email for new registration = "+email);
		if(email.equals("akshat55narang@gmail.com")){
	    	
	    	passwordreset.getResetPasswordEmail().sendKeys(email);
	    }
	    else if(email.equals("adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com")){
	    	passwordreset.getResetPasswordEmail().sendKeys(email);
	    }
	    else if(email.equals("a@c")){
	    	passwordreset.getResetPasswordEmail().sendKeys(email);
	    	
	    }
	    else if(email.equals("a")){
	    	passwordreset.getResetPasswordEmail().sendKeys(email);
	    }
	    
	}
	
	@When("^User clicks Reset Password Button$")
	public void user_clicks_Reset_Password_Button() throws Throwable {
		Log.info("Clicking on Reset Password Button ");
	    passwordreset.getResetPasswordButton().click();
	    
	}
	
	@When("^User deletes the email text$")
	public void user_deletes_the_email_text() throws Throwable {
		Log.info("Deleting email from input ");
		passwordreset.getResetPasswordEmail().clear();
	    testContext.getWebDriverManager().getExplicitWaitForElement(passwordreset.getFailedResetPasswordMessage(), "visibility");
	}

	
	@Then("^User should receive a message \"([^\"]*)\" for Password Reset$")
	public void user_should_receive_a_message_for_Password_Reset(String message) throws Throwable {
		int count = passwordreset.getListOfAllFaliedChecks().size();
		
		boolean flag = false;
		if(message.equals("Check your e-mails for details on how to reset your password.")){
			for(int i=0;i<count;i++){
				Log.info("Message received when User clicked on Reset Password="+passwordreset.getListOfAllFaliedChecks().get(i).getText());
				if(passwordreset.getListOfAllFaliedChecks().get(i).getText().equals(message)){
				flag = true;
				break;
				}
			}
			Assert.assertTrue(flag);
	    }
	    else if(message.equals("Your e-mail cannot be longer than 50 characters.")){
	    	for(int i=0;i<count;i++){
	    		Log.info("Message received when User clicked on Reset Password="+passwordreset.getListOfAllFaliedChecks().get(i).getText());
	    		if(passwordreset.getListOfAllFaliedChecks().get(i).getText().equals(message)){
				flag = true;
				break;
				}
			}
			Assert.assertTrue(flag);
			}
	    else if(message.equals("Your e-mail is required to be at least 5 characters.")){
	    	
	    	for(int i=0;i<count;i++){
	    		
	    		Log.info("Message received when User clicked on Reset Password="+passwordreset.getListOfAllFaliedChecks().get(i).getText());
	    		if(passwordreset.getListOfAllFaliedChecks().get(i).getText().equals(message)){
				flag = true;
				break;
				}
			}
			Assert.assertTrue(flag);
			}
	    else if(message.equals("Your e-mail is invalid.")){
	    	for(int i=0;i<count;i++){
	    		Log.info("Message received when User clicked on Reset Password="+passwordreset.getListOfAllFaliedChecks().get(i).getText());
	    		if(passwordreset.getListOfAllFaliedChecks().get(i).getText().equals(message)){
				flag = true;
				break;
				}
			}
			Assert.assertTrue(flag);
			}
		
	}

	@Then("^The Reset Password button should be disabled\\.$")
	public void the_Reset_Password_button_should_be_disabled() throws Throwable {
		Log.info("Verifying whether reset password button is displayed");
		Assert.assertTrue(passwordreset.getResetPasswordButton().isDisplayed());
	}

	
}
