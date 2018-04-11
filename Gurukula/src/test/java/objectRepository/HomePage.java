package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	public HomePage home;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="login")
	private WebElement buttonLogin;
	
	@FindBy(xpath="//*[text()='Account']")
	private WebElement dropdownAccountMenu;
	
	@FindAll(value = { @FindBy(xpath="//li[@class='dropdown pointer open']/ul/li") })
	private List<WebElement> listAccountMenu;
	
	@FindBy(xpath="//*[@class='dropdown-menu']/li[4]")
	private WebElement listItemLogOut;
	
	@FindBy(xpath="//span[text()='Register']")
	private WebElement listItemRegister;
	
	@FindBy(linkText="Did you forget your password?")
	private WebElement linkForgotPassword;
	
	@FindBy(xpath="//*[text()='Entities']")
	private WebElement dropdownEntities;
	
	@FindAll(value = { @FindBy(xpath="//li[@class='dropdown pointer ng-scope open']/ul/li") })
	private List<WebElement> listEntities;
	
	@FindBy(xpath="//*[text()='Staff']")
	private WebElement listItemStaff;
	
	@FindBy(xpath="//*[text()='Branch']")
	private WebElement listItemBranch;
	
	@FindBy(xpath="//*[text()='Password']")
	private WebElement listItemPassword;
	
	@FindBy(xpath="//*[text()='Settings']")
	private WebElement listItemSettings;
	
	public WebElement getLoginButton(){
		return buttonLogin;
	}
	
	public WebElement getAccountMenu(){
		return dropdownAccountMenu;
	}
	
	public List<WebElement> getAccountMenuList(){
		return listAccountMenu;
	}
	
	public WebElement getLogout(){
		return listItemLogOut;
	}
	
	public WebElement getUserRegistrationFromAccountMenu(){
		return listItemRegister;
	}
	
	public WebElement getForgotPasswordLink(){
		return linkForgotPassword;
	}
	
	public WebElement getEntitiesMenu(){
		return dropdownEntities;
	}
	
	public List<WebElement> getEntitiesList(){
		return listEntities;
	}
	
	public WebElement getListItemStaffFromEntitiesMenu(){
		return listItemStaff;
	}
	
	public WebElement getListItemBranchFromEntitiesMenu(){
		return listItemBranch;
	}
	
	public WebElement getListItemPasswordFromAccountsMenu(){
		return listItemPassword;
	}
	
	public WebElement getListItemSettingsFromAccountsMenu(){
		return listItemSettings;
	}
	

}
