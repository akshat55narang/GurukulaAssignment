package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchOverViewPage {

	public WebDriver driver;
	
	public BranchOverViewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='col-md-4']/button/span[@class='ng-scope']")
	private WebElement buttonCreateBranch;
	
	@FindBy(css="#searchQuery")
	private WebElement inputSearchQuery;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	private WebElement buttonSearchBranch;
	
	@FindAll(value = { @FindBy(xpath="//*[text()='View']")})
	private List<WebElement> buttonViewBranch;
	
	@FindBy(xpath="//*[text()='Edit']")
	private List<WebElement> buttonEditBranch;
	
	@FindBy(xpath="//*[text()='Delete']")
	private List<WebElement> buttonDeleteBranch;
	
	@FindBy(linkText="<<")
	private WebElement linkFirst;
	
	@FindBy(linkText=">>")
	private WebElement linkLast;
	
	@FindBy(linkText="<")
	private WebElement linkPrevious;
	
	@FindBy(linkText=">")
	private WebElement linkNext;
	
	@FindBy(xpath="//*[@name='name']")
	private WebElement formInputName;
	
	@FindBy(xpath="//*[@name='code']")
	private WebElement formInputBranch;
	
	@FindBy(xpath="//*[text()='Cancel']")
	private WebElement buttonCancelBranchCreation;
	
	@FindBy(xpath="//*[text()='Save']")
	private WebElement buttonSaveBranchCreation;
	
	//table table-striped
	@FindBy(xpath="//*[@class='table table-striped']")
	public WebElement tableBranchInformation;
	
	@FindAll(value = { @FindBy(css="[class='table table-striped'] tr[class='ng-scope'] td:nth-child(2)") })
	private List<WebElement> rowBranchName; 
		
	@FindBy(xpath="//*[@class='table table-striped']/tbody/tr[1]/td[2]/input")
	private WebElement inputBranchViewName;
	
	@FindBy(xpath="//*[@class='btn btn-danger']/span[@class='ng-scope']")
	private WebElement buttonDeleteConfirmation;
	
	//
	@FindBy(xpath="//*[text()='Back']")
	private WebElement buttonViewFormBack;
	
	public WebElement getCreateBranchButton(){
		return buttonCreateBranch;
	}
	
	public WebElement getSearchInput(){
		return inputSearchQuery;
	}
	
	public WebElement getSearchBranchButton(){
		return buttonSearchBranch;
	}
	
	public List<WebElement> getViewBranchButton(){
		return buttonViewBranch;
	}
	
	public List<WebElement> getEditBranchButton(){
		return buttonEditBranch;
	}
	
	public List<WebElement> getDeleteBranchButton(){
		return buttonDeleteBranch;
	}
	
	public WebElement getFirstPageButton(){
		return linkFirst;
	}
	
	public WebElement getLastPageButton(){
		return linkLast;
	}
	
	public WebElement getNextPageButton(){
		return linkNext;
	}
	
	public WebElement getPreviousPageButton(){
		return linkPrevious;
	}
	
	public WebElement getFormInputName(){
		return formInputName;
	}
	
	public WebElement getFormInputBranch(){
		return formInputBranch;
	}
	
	public WebElement getCancelButton(){
		return buttonCancelBranchCreation;
	}
	
	public WebElement getSaveButton(){
		return buttonSaveBranchCreation;
	}
	
	public WebElement getBranchListTable(){
		return tableBranchInformation;
	}
	
	public List<WebElement> getBranchRowNameColumn(){
		return rowBranchName;
	}
	
	public WebElement getBranchViewFormName(){
		return inputBranchViewName;
	}

	public WebElement getBackButtonOnViewForm(){
		return buttonViewFormBack;
	}
	
	public WebElement getDeleteConfirmation(){
		return buttonDeleteConfirmation;
	}
}
