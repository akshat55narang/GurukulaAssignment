package stepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePage;
import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class StepDefinitionGeneric {

	TestContext testContext;
	private HomePage home;
	public WebDriverWait wait;
	
	public StepDefinitionGeneric(TestContext test) {
		testContext=test;
		home = testContext.getPageObjectManager().getHomePage();
	}
	
	@Before
	public void before(){
		
	}
	
	@After
	public void close_browser(){
		testContext.getWebDriverManager().closeBrowser();
	}

	
}
