package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {

	
	private WebDriverManager webDriverManager;
	private PageObjectManager page;
	
	public TestContext(){
		webDriverManager = new WebDriverManager();
		page = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager(){
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager(){
		return page;
	}

}
