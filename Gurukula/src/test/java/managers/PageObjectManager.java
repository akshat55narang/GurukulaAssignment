package managers;

import objectRepository.BranchOverViewPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.PasswordResetPage;
import objectRepository.RegistrationPage;
import objectRepository.StaffOverviewPage;
import objectRepository.UpdateAccountPasswordPage;
import objectRepository.UpdateAccountSettingsPage;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public PageObjectManager page;
	public WebDriver driver;
	public HomePage home;
	public LoginPage login;
	public RegistrationPage register;
	public PasswordResetPage passwordreset;
	public StaffOverviewPage staff;
	public BranchOverViewPage branch;
	public UpdateAccountPasswordPage updateaccountpassword;
	public UpdateAccountSettingsPage updateaccountsettings;
	
	public PageObjectManager(WebDriver driver){
		this.driver=driver;
	}
	
	public HomePage getHomePage(){
		return (home==null)?home = new HomePage(driver):home;
		
	}
	public LoginPage getLoginPage(){
		return (login==null)?login = new LoginPage(driver):login;
	}

	public RegistrationPage getRegistrationPage(){
		return (register==null)? register = new RegistrationPage(driver):register;
	}
	
	public PasswordResetPage getPasswordResetPage(){
		return (passwordreset == null)? passwordreset = new PasswordResetPage(driver):passwordreset;
	}
	
	public StaffOverviewPage getStaffOverviewPage(){
		return (staff==null)? staff = new StaffOverviewPage(driver):staff;
	}
	
	public BranchOverViewPage getBranchOverviewPage(){
		return (branch==null)? branch = new BranchOverViewPage(driver):branch;
	}
	
	public UpdateAccountPasswordPage getUpdateAccountPasswordPage(){
		return (updateaccountpassword==null)? updateaccountpassword = new UpdateAccountPasswordPage(driver):updateaccountpassword;
	}
	
	public UpdateAccountSettingsPage getUpdateAccountSettingsPage(){
		return (updateaccountsettings==null)? updateaccountsettings = new UpdateAccountSettingsPage(driver):updateaccountsettings;
	}
}
