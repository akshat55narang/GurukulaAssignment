package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.TestContext;


public class UpdateAccountPasswordPage {
	
	public WebDriver driver;
	
	public UpdateAccountPasswordPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement inputNewPassword;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement inputNewConfirmPassword;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement buttonSave;
	
	@FindBy(xpath="//div[@class='alert alert-success ng-scope ng-hide']")
	private WebElement messageSuccess;
	
	@FindBy(xpath="(//*[@class='help-block ng-scope'])[1]")
	private WebElement messageLessCharacters;
	//Your password cannot be longer than 50 characters.
	@FindBy(xpath="(//*[@class='help-block ng-scope'])")
	private WebElement messageMaxCharacters;
	
	@FindBy(xpath="//*[@class='alert alert-danger ng-scope']")
	private WebElement messagePasswordMismatch;
	
	//form[@name='form']/div[2]/div/p[@class='help-block ng-scope']"
	@FindBy(xpath="//form[@name='form']/div[2]/div/p[@class='help-block ng-scope']")
	private WebElement messageConfirmPassword;
	
	public WebElement getNewPasswordInput(){
		return inputNewPassword;
	}
		
	public WebElement getNewConfirmPasswordInput(){
		return inputNewConfirmPassword;
	}
	
	public WebElement getSaveButton(){
		return buttonSave;
	}
	
	public WebElement getUpdateSuccessMessage(){
		return messageSuccess;
	}
	
	public WebElement getNewPasswordLeastCharErrorMessage(){
		return messageLessCharacters;
	}
	
	public WebElement getNewPasswordMaximumCharErrorMessage(){
		return messageMaxCharacters;
	}
	
	public WebElement getPasswordMismatchErrorMessage(){
		return messagePasswordMismatch;
	}
	
	public WebElement getConfirmPasswordErrorMessage(){
		return messageConfirmPassword;
	}

}
