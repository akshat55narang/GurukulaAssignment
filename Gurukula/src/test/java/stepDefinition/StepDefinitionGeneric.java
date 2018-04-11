package stepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePage;
import cucumber.TestContext;
import cucumber.api.java.en.*;

public class StepDefinitionGeneric {

	TestContext testContext;
	private HomePage home;
	public WebDriverWait wait;
	
	public StepDefinitionGeneric(TestContext test) {
		testContext=test;
		home = testContext.getPageObjectManager().getHomePage();
	}
	
	

	
}
