package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {

	private WebDriver driver;
	
	public PasswordResetPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement inputEmailId;
	
	@FindBy(xpath="//*[@class='btn btn-primary ng-scope']")
	private WebElement buttonResetPassword;
	
	@FindBy(xpath="//*[@class='alert alert-danger ng-scope']")
	private WebElement messageFailedResetPassword;
	
	public WebElement getResetPasswordEmail(){
		return inputEmailId;
	}
	
	public WebElement getResetPasswordButton(){
		return buttonResetPassword;
	}
	
	public WebElement getFailedResetPasswordMessage(){
		return messageFailedResetPassword;
	}
}
