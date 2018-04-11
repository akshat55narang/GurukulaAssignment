package stepDefinition;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

import org.jsoup.nodes.Entities;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BranchOverViewPage;
import objectRepository.BranchOverViewPage;
import objectRepository.HomePage;
import objectRepository.StaffOverviewPage;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ro.Si;

public class StepDefinitionEntities {

	TestContext testContext;
	public HomePage home;
	public WebDriverWait wait;
	public StaffOverviewPage staff;
	public BranchOverViewPage branch;
	
	public StepDefinitionEntities(TestContext context){
		testContext=context;
		home = testContext.getPageObjectManager().getHomePage();
		staff = testContext.getPageObjectManager().getStaffOverviewPage();
		branch = testContext.getPageObjectManager().getBranchOverviewPage();
	}

	@When("^User clicks on Entities Menu$")
	public void user_User_clicks_on_Entities_Menu() throws Throwable {
	    home.getEntitiesMenu().click();
	    wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(home.getEntitiesMenu()));
	}

	@Then("^User should be able to view Branch and Staff values in the Entity list$")
	public void user_should_be_able_to_view_Branch_and_Staff_values_in_the_Entity_list() throws Throwable {
		Assert.assertEquals(" Branch", home.getEntitiesList().get(0).getText());
		Assert.assertEquals(" Staff", home.getEntitiesList().get(1).getText());
		
		testContext.getWebDriverManager().closeBrowser();
	}
	
	@When("^User clicks on ([^\"]*) Entity$")
	public void user_clicks_on_Menu(String entity) throws Throwable {
	   if(entity.equals("Staff")){
		   home.getListItemStaffFromEntitiesMenu().click();
		  }
	   else if(entity.equals("Branch")){
		   home.getListItemBranchFromEntitiesMenu().click();
	   }
	}

	@When("^User clicks on View Button for ([^\"]*)$")
	public void user_clicks_on_View_Button(String entity) throws Throwable {
	   if(entity.equals("Staff")){
		    
	   }
	   else if(entity.equals("Branch")){
		   
	   }
	}
	
	@Then("^User should be able to see the specific ([^\"]*) with name \"([^\"]*)\"$")
	public void user_should_be_able_to_see_a_list(String entity,String name) throws Throwable {
	    if(entity.equals("Staff")){
	    	 int count = staff.getStaffRowNameCoulumn().size();
			   for(int i=0;i<count;i++){
				   if(staff.getStaffRowNameCoulumn().get(i).getText().equals(name)){
				   staff.getViewStaffButton().get(i).click();
				   Assert.assertTrue(staff.getStaffViewFormName().getAttribute("value").contains(name));  
				   staff.getBackButtonOnViewForm().click();
			   
				   }
			   }
	    }
	    else if(entity.equals("Branch")){
	    	
	    	 int count = branch.getBranchRowNameColumn().size();
	    	    for(int i=0;i<count;i++){
				   	if(branch.getBranchRowNameColumn().get(i).getText().equals(name)){
				    branch.getViewBranchButton().get(i).click();
				    Assert.assertTrue(branch.getBranchViewFormName().getAttribute("value").equals(name));  
				    branch.getBackButtonOnViewForm().click();
				   }
			  
				  }
			 testContext.getWebDriverManager().closeBrowser();
	    }
	}

	@Given("^User opens Entities Menu$")
	public void user_opens_Entities_Menu() throws Throwable {
	    home.getEntitiesMenu().click();
	    wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(home.getListItemBranchFromEntitiesMenu()));
	}

	@Given("^User selects ([^\"]*) Menu$")
	public void user_opens_Entities_Menu(String entityoption) throws Throwable {
		if(entityoption.equals("Staff")){
		home.getListItemStaffFromEntitiesMenu().click();
		System.out.println("Staffs");
		}
		else if(entityoption.equals("Branch")){
		home.getListItemBranchFromEntitiesMenu().click();
		}
	}

	@When("^User creates a new ([^\"]*) entry$")
	public void user_creates_a_new_Entity_entry(String entity) throws Throwable {
	    if(entity.equals("Staff")){
	    	staff.getCreateStaffButton().click();
	    	staff.getFormInputName().sendKeys("akshatnarang");
	    	staff.getSaveButton().click();
	    	wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    // wait.until(ExpectedConditions.)
	    // wait(10);
	    }
	    else if(entity.equals("Branch")){
	    	branch.getCreateBranchButton().click();
	    	branch.getFormInputName().sendKeys("ComputerScience");
	    	branch.getFormInputBranch().sendKeys("CSE");
	    	branch.getSaveButton().click();
	    	wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	    }
	}

	@Then("^User should be able to see the created entry in the ([^\"]*) list$")
	public void user_should_be_able_to_see_the_created_entry(String entity) throws Throwable {
	    if(entity.equals("Staff")){
		int count = staff.getStaffRowNameCoulumn().size();
	    boolean flag = true;
	    for(int i=0;i<count;i++){
	    	//System.out.println(staff.getStaffTableRows().get(i).getText());
	    	
	    	}
	    } 
	    else if(entity.equals("Branch")){
	    	int count = branch.getBranchRowNameColumn().size();
		    boolean flag = true;
		    for(int i=0;i<count;i++){
		    //	System.out.println(branch.getBranchTableRows().get(i).getText());
		    	
		    }
	    }
	}
	//Edit Scenario
	@When("^User clicks on Edit Button for ([^\"]*)$")
	public void user_clicks_on_Edit_Button(String entity) throws Throwable {
		if(entity.equals("Staff")){
		}
		else if(entity.equals("Branch")){
			
		}
	}

	@Then("^User should be able to edit the specific ([^\"]*) with name \"([^\"]*)\"$")
	public void user_should_be_able_to_edit_the_specific_Entity(String entity,String name) throws Throwable {
	    if(entity.equals("Staff")){
	    	 int count = staff.getStaffRowNameCoulumn().size();
	    	 System.out.println(count);
			   for(int i=0;i<count;i++){
				   if(staff.getStaffRowNameCoulumn().get(i).getText().equals(name)){
				   staff.getEditStaffButton().get(i).click();
				   wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
				   wait.until(ExpectedConditions.visibilityOf(staff.getFormInputName()));
				   staff.getFormInputName().sendKeys("Test");
				   staff.getSaveButton().click();
				   
				   wait.until(ExpectedConditions.invisibilityOf(staff.getSaveButton()));
				   
				   Assert.assertFalse(staff.getStaffRowNameCoulumn().get(i).getText().equals(name));  
				 }
			   }
	    }
	    else if (entity.equals("Branch")){
	    	 int count = branch.getBranchRowNameColumn().size();
	    	    for(int i=0;i<count;i++){
	    	    	 if(branch.getBranchRowNameColumn().get(i).getText().equals(name)){
	  				   branch.getEditBranchButton().get(i).click();
	  				   wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	  				   wait.until(ExpectedConditions.visibilityOf(branch.getFormInputName()));
	  				   branch.getFormInputName().sendKeys("Test");
	  				   branch.getSaveButton().click();
	  				   
	  				   wait.until(ExpectedConditions.invisibilityOf(branch.getSaveButton()));
	  				  
	  				   Assert.assertFalse(branch.getBranchRowNameColumn().get(i).getText().equals(name));  
	  				 }
			  
				  }
			 testContext.getWebDriverManager().closeBrowser();
	    }
	}
	
	//Negative Cases for Edit 
	
	
	//Delete Entity
	@When("^User clicks on Delete Button for ([^\"]*)$")
	public void user_clicks_on_Delete_Button_for_Staff(String entity) throws Throwable {
	
	}

	@Then("^User should be able to Delete the specific ([^\"]*) with name \"([^\"]*)\"$")
	public void user_should_be_able_to_Delete_the_specific_Staff_with_name(String entity,String name) throws Throwable {
	    if(entity.equals("Staff")){
	    	
	    }
	    else if(entity.equals("Branch")){
	    	 int count = branch.getBranchRowNameColumn().size();
	    	    for(int i=0;i<count;i++){
	    	    	 if(branch.getBranchRowNameColumn().get(i).getText().equals(name)){
	  				   branch.getDeleteBranchButton().get(i).click();
	  				   wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
	  				   wait.until(ExpectedConditions.visibilityOf(branch.getDeleteConfirmation()));
	  				   branch.getDeleteConfirmation().click();
	  				   
	  				   wait.until(ExpectedConditions.invisibilityOf(branch.getDeleteConfirmation()));
	  				  
	  				   Assert.assertFalse(branch.getBranchRowNameColumn().get(i).getText().equals(name));  
	  				 }
			  
				  }
	    }
	}
	@When("^User opens Settings from Account menu$")
	public void user_opens_Settings_from_Account_menu() throws Throwable {
	    
	}

	@Then("^User should be able to edit the logged in account information$")
	public void user_should_be_able_to_edit_the_logged_in_account_information() throws Throwable {
	    
	}
	
	
}
