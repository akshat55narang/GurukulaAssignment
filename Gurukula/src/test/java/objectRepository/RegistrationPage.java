package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement inputNewRegistrationLoginId;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement inputNewRegistrationEmailId;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement inputNewRegistrationNewPassword;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement inputNewRegistrationNewPasswordConfirmation;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-scope']")
	private WebElement buttonRegister;
	
	@FindBy(xpath="//div[@class='alert alert-danger ng-scope']")
	private WebElement messageRegistrationFailure;

	//help-block ng-scope
	@FindBy(xpath="//form[@name='form']/div[1]/div/p[@class='help-block ng-scope']")
	private WebElement messageLoginFailure;
	
	@FindBy(xpath="//form[@name='form']/div[2]/div/p[@class='help-block ng-scope']")
	private WebElement messageEmailFailure;
	
	@FindBy(xpath="//form[@name='form']/div[3]/div/p[@class='help-block ng-scope']")
	private WebElement messageNewPasswordFailure;
	
	@FindBy(xpath="//form[@name='form']/div[4]/div/p[@class='help-block ng-scope']")
	private WebElement messageConfirmPasswordFailure;
	
	public WebElement getLoginIdForNewUserRegistration(){
		return inputNewRegistrationLoginId;
	}

	public WebElement getEmailIdForNewUserRegistration(){
		return inputNewRegistrationEmailId;
	}
	
	public WebElement getPasswordForNewUserRegistration(){
		return inputNewRegistrationNewPassword;
	}
	
	public WebElement getPasswordConfirmationForNewUserRegistration(){
		return inputNewRegistrationNewPasswordConfirmation;
	}
	
	public WebElement getRegisterButtonForNewUserRegistration(){
		return buttonRegister;
	}
	
	public WebElement getRegistrationFailureMessage(){
		return messageRegistrationFailure;
	}

	public WebElement getLoginFailureMessage(){
		return messageLoginFailure;
	}
	
	public WebElement getEmailFailureMessage(){
		return messageEmailFailure;
	}
	
	public WebElement getPasswordFailureMessage(){
		return messageNewPasswordFailure;
	}
	
	public WebElement getPasswordConfirmationFailureMessage(){
		return messageConfirmPasswordFailure;
	}
}
