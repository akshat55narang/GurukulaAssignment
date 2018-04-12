package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAccountSettingsPage {

	public WebDriver driver;
	
	public UpdateAccountSettingsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//updateaccountsettings
	@FindBy(xpath="//span[text()='Settings']")
	private WebElement listItemSettings;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement inputFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement inputLastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement inputEmail;
	
	@FindBy(xpath="//input[@name='langKey']")
	private WebElement dropDownLangKey;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement buttonSave;
	
	@FindBy(xpath="//*[@class='help-block ng-scope']")
	private WebElement messageLessCharacters;
	//Unhidden element 
	@FindBy(xpath="//*[@class='help-block ng-scope']")
	private WebElement messageMaxCharacters;
	
	@FindAll(value = { @FindBy(xpath="//*[@class='help-block ng-scope']") })
	private List<WebElement> messageFailureChecks;
	
	//alert alert-danger ng-scope
	@FindBy(xpath="//*[@class='alert alert-success ng-scope']")
	private WebElement messageSuccess;
	//alert alert-danger ng-scope
	@FindBy(xpath="//*[@class='alert alert-danger ng-scope']")
	private WebElement messageFailure;
	
	
	public WebElement getListItemSettings(){
		return listItemSettings;
	}
		
	public WebElement getFirstNameInput(){
		return inputFirstName;
	}
	
	public WebElement getLastNameInput(){
		return inputLastName;
	}
	
	public WebElement getInputEmail(){
		return inputEmail;
	}
	
	public WebElement getLanguangeKeyDropDown(){
		return dropDownLangKey;
	}
	
	public WebElement getSaveButton(){
		return buttonSave;
	}
	
	public WebElement getLessCharactersErrorMessage(){
		return messageLessCharacters;
	}
	
	public WebElement getMaximumCharactersErrorMessage(){
		return messageMaxCharacters;
	}
	
	public WebElement getSaveSuccessMessage(){
		return messageMaxCharacters;
	}
	
	public WebElement getSaveFailureMessage(){
		return messageFailure;
	}
	
	public List<WebElement> getFailureChecks(){
		return messageFailureChecks;
	}
}
