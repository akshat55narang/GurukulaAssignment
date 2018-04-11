package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage login;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#username")
	private WebElement inputUsername;
	
	@FindBy(id="password")
	private WebElement inputPassword;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-scope']")
	private WebElement buttonAuthentication;
	
	@FindBy(xpath="//*[@class='alert alert-success ng-scope ng-binding']")
	private WebElement authenticationContainer;
	
	@FindBy(xpath="//*[@class='alert alert-danger ng-scope']")
	private WebElement messageAuthenticationFailure;
	
	public WebElement getInputUserName(){
		return inputUsername;
	}

	public WebElement getInputPassword(){
		return inputPassword;
	}

	public WebElement getAuthenticationButton(){
		return buttonAuthentication;
	}
	
	public WebElement getAuthenticationSuccessMessage(){
		return authenticationContainer;
	}
	
	public WebElement getAuthenticationFailureMessage(){
		return messageAuthenticationFailure;
	}
}
