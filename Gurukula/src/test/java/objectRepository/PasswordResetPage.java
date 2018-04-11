package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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
	
	@FindBy(xpath="//*[@class='help-block ng-scope']")
	private WebElement messageFailedResetPassword;
	
	@FindBy(xpath="//*[@class='alert alert-danger ng-scope']")
	private WebElement messageFailureAlert;
	
	@FindAll(value = @FindBy(xpath="//*[starts-with(@class,'help')]"))
	private List<WebElement> listFailedResponses;
	
	
	public WebElement getResetPasswordEmail(){
		return inputEmailId;
	}
	
	public WebElement getResetPasswordButton(){
		return buttonResetPassword;
	}
	
	public WebElement getFailedResetPasswordMessage(){
		return messageFailedResetPassword;
	}
	
	public WebElement getFailedResetPasswordAlert(){
		return messageFailureAlert;
	}
	
	public List<WebElement> getListOfAllFaliedChecks(){
		return listFailedResponses;
	}

}

