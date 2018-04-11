package stepDefinition;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import managers.ConfigFileManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.PasswordResetPage;
import objectRepository.RegistrationPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import dataProvider.ConfigFileReader;

public class StepDefinitionLogin {

	public WebDriver driver;
	public ConfigFileManager fileReadManager;
	//public ConfigFileReader config;
	public HomePage home;
	public LoginPage login;
	public RegistrationPage register;
	public PasswordResetPage passwordreset;
	public PageObjectManager page;
	public WebDriverManager webDriverManager;
	public WebDriverWait wait;
	
	TestContext testContext;
	
	public StepDefinitionLogin(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		login = testContext.getPageObjectManager().getLoginPage();
		passwordreset = testContext.getPageObjectManager().getPasswordResetPage();
		register = testContext.getPageObjectManager().getRegistrationPage();
	}
	
	
	@Given("^User opens Application in Browser$")
	public void user_opens_Application_in_Browser() throws Throwable {
	
	}
	
	@Given("^User clicks on Login Button$")
	public void user_clicks_on_Login_Button() throws Throwable {
		home.getLoginButton().click();
		testContext.getWebDriverManager().getExplicitWaitForElement(login.getAuthenticationButton(), "visibility");
	}

	@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_username_and_password(String username,String password) throws Throwable {
		login.getInputUserName().sendKeys(username);
		login.getInputPassword().sendKeys(password);
		}

	@Then("^User should be able to Login$")
	public void user_should_be_able_to_Login() throws Throwable {
		String userType = "admin";
		login.getAuthenticationButton().click();
		Assert.assertTrue(login.getAuthenticationSuccessMessage().getText().equals("You are logged in as user \""+userType+"\"."));
		}

	
	@When("^User enters invalid \"([^\"]*)\" or invalid \"([^\"]*)\"$")
	public void user_enters_invalid_username(String username,String password) throws Throwable {
	    login.getInputUserName().sendKeys(username);
	    login.getInputPassword().sendKeys(password);
	    
	}

	@Then("^User should not be able to Login$")
	public void user_should_not_be_able_to_Login() throws Throwable {
		login.getAuthenticationButton().click();
		Assert.assertEquals("Authentication failed! Please check your credentials and try again.", login.getAuthenticationFailureMessage().getText());
		
	}

	@Given("^User enters valid credentials$")
	public void user_enters_valid_credentials(DataTable credentials) throws Throwable {
		List<Map<String,String>> data = credentials.asMaps(String.class,String.class);
		login.getInputUserName().sendKeys(data.get(0).get("username"));
		login.getInputPassword().sendKeys(data.get(0).get("password"));
	}

	@Given("^User is able to login to the Application$")
	public void user_is_able_to_login_to_the_Application() throws Throwable {
	   login.getAuthenticationButton().click();
	   testContext.getWebDriverManager().getExplicitWaitForElement(login.getAuthenticationSuccessMessage(), "visibility");
	   
	}

	@When("^User opens Account Menu$")
	public void user_opens_account_menu() throws Throwable {
	    home.getAccountMenu().click();
	   
	}
	
	@When("^User clicks on logout button$")
	public void user_clicks_on_logout_button() throws Throwable {
		int count = home.getAccountMenuList().size();
		System.out.println(count);
		for(int i=0;i<count;i++){
			System.out.println(home.getAccountMenuList().get(i).getText());
			if(home.getAccountMenuList().get(i).getText().equals(" Log out")){
				//System.out.println();
				home.getAccountMenuList().get(i).click();
				break;
			}
		}
	}

	@Then("^User should be able to logout of the application$")
	public void user_should_be_able_to_logout_of_the_application() throws Throwable {
		
		Assert.assertTrue(home.getLoginButton().isDisplayed());
		
		
		
	}

	@When("^User clicks on /Did you forget your password\\?/$")
	public void user_clicks_on_Did_you_forget_your_password() throws Throwable {
	    home.getForgotPasswordLink().click();
	    testContext.getWebDriverManager().getExplicitWaitForElement(passwordreset.getResetPasswordEmail(), "visibility");
	}

	@When("^enters his email address \"([^\"]*)\"$")
	public void enters_his_email_address(String email) throws Throwable {
	   page = new PageObjectManager(driver);
	   passwordreset = page.getPasswordResetPage();
	   passwordreset.getResetPasswordEmail().sendKeys(email);
	}

	@Then("^User should receive the password reset link in the email$")
	public void user_should_receive_the_password_reset_link_in_the_email() throws Throwable {
	    passwordreset.getResetPasswordButton().click();
	    Assert.assertEquals("E-Mail address isn't registered! Please check and try again", passwordreset.getFailedResetPasswordMessage().getText());
	    
	}
	
	@Given("^User clicks on Accounts Menu$")
	public void user_clicks_on_Accounts_Menu() throws Throwable {
		
		//wait = testContext.getWebDriverManager().getExplicitWaitForElement(home.getAccountMenu(), "clickable");
	    home.getAccountMenu().click();
	    wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 20);
	    wait.until(ExpectedConditions.visibilityOf(home.getListItemPasswordFromAccountsMenu()));
	}
	
}
