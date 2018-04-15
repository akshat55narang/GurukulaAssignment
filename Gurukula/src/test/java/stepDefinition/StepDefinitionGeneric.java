package stepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePage;
import cucumber.Log;
import cucumber.TestContext;
import cucumber.api.Scenario;
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
	public void before(Scenario scenario){
		Log.startTestCase(scenario.getName());
	}
	
	@After
	public void close_browser(Scenario scenario){
		testContext.getWebDriverManager().closeBrowser();
		testContext.getWebDriverManager().closeAllBrowsers();
		Log.endTestCase(scenario.getName());
	}

	
}
