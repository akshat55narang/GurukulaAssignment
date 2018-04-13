package stepDefinition;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Entities;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BranchOverViewPage;
import objectRepository.HomePage;
import objectRepository.StaffOverviewPage;
import cucumber.Log;
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
	private int countBefore;
	private int countAfter;
	
	public StepDefinitionEntities(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
		staff = testContext.getPageObjectManager().getStaffOverviewPage();
		branch = testContext.getPageObjectManager().getBranchOverviewPage();
	}

	@When("^User clicks on Entities Menu$")
	public void user_User_clicks_on_Entities_Menu() throws Throwable {
		home.getEntitiesMenu().click();
		Log.info("Click on Entities");
		wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(),
				10);
		wait.until(ExpectedConditions.visibilityOf(home.getEntitiesMenu()));
	}

	@Then("^User should be able to view Branch and Staff values in the Entity list$")
	public void user_should_be_able_to_view_Branch_and_Staff_values_in_the_Entity_list()
			throws Throwable {
		Assert.assertEquals(" Branch", home.getEntitiesList().get(0).getText());
		Assert.assertEquals(" Staff", home.getEntitiesList().get(1).getText());

		
	}

	@When("^User clicks on ([^\"]*) Entity$")
	public void user_clicks_on_Menu(String entity) throws Throwable {
		if (entity.equals("Staff")) {
			home.getListItemStaffFromEntitiesMenu().click();
		} else if (entity.equals("Branch")) {
			home.getListItemBranchFromEntitiesMenu().click();
		}
	}

	@When("^User clicks on View Button for ([^\"]*)$")
	public void user_clicks_on_View_Button(String entity) throws Throwable {
		if (entity.equals("Staff")) {

		} else if (entity.equals("Branch")) {

		}
	}

	@Then("^User should be able to see the specific ([^\"]*) with name \"([^\"]*)\"$")
	public void user_should_be_able_to_see_a_list(String entity, String name)
			throws Throwable {

		if (entity.equals("Staff")) {
			int count = staff.getStaffRowNameCoulumn().size();
			
			

			for (int i = 0; i < count; i++) {
				if (staff.getStaffRowNameCoulumn().get(i).getText()
						.equals(name)) {
					staff.getViewStaffButton().get(i).click();
					Assert.assertTrue(staff.getStaffViewFormName()
							.getAttribute("value").contains(name));
					// staff.getBackButtonOnViewForm().click();

				}
			}
		} else if (entity.equals("Branch")) {

			int count = branch.getBranchRowNameColumn().size();
			for (int i = 0; i < count; i++) {
				if (branch.getBranchRowNameColumn().get(i).getText()
						.equals(name)) {
					branch.getViewBranchButton().get(i).click();
					Assert.assertTrue(branch.getBranchViewFormName()
							.getAttribute("value").equals(name));
					branch.getBackButtonOnViewForm().click();
				}

			}

		}
	}

	@Given("^User opens Entities Menu$")
	public void user_opens_Entities_Menu() throws Throwable {
		home.getEntitiesMenu().click();
		// wait = new
		// WebDriverWait(testContext.getWebDriverManager().getDriver(), 10);
		// wait.until(ExpectedConditions.visibilityOf(home.getListItemBranchFromEntitiesMenu()));
		testContext.getWebDriverManager().getExplicitWaitForElement(
				home.getListItemBranchFromEntitiesMenu(), "visibility");
	}

	@Given("^User selects ([^\"]*) Menu$")
	public void user_opens_Entities_Menu(String entityoption) throws Throwable {
		if (entityoption.equals("Staff")) {
			home.getListItemStaffFromEntitiesMenu().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getCreateStaffButton(), "visibility");
		} else if (entityoption.equals("Branch")) {
			home.getListItemBranchFromEntitiesMenu().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getCreateBranchButton(), "visibility");
		}
	}

	@When("^User creates a new ([^\"]*) entry with name \"([^\"]*)\"$")
	public void user_creates_a_new_Entity_entry(String entity, String name)
			throws Throwable {
		if (entity.equals("Staff")) {
			staff.getCreateStaffButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getCancelButton(), "visibility");
			staff.getFormInputName().sendKeys(name);
			countBefore = staff.getStaffRowNameCoulumn().size();
			staff.getSaveButton().click();

			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getCreateStaffButton(), "visibility");

		} else if (entity.equals("Branch")) {
			branch.getCreateBranchButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getCancelButton(), "visibility");

			branch.getFormInputName().sendKeys(name);
		}
	}

	@When("^Branch Code \"([^\"]*)\"$")
	public void branch_Code(String code) throws Throwable {
		branch.getFormInputBranch().sendKeys(code);
		countBefore = branch.getBranchRowNameColumn().size();
		branch.getSaveButton().click();
		testContext.getWebDriverManager().getExplicitWaitForElement(
				branch.getCreateBranchButton(), "visibility");

	}

	@Then("^User should be able to see the created entry in the ([^\"]*) list with name \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_created_entry(String entity,
			String name) throws Throwable {

		if (entity.equals("Staff")) {
			countAfter = staff.getStaffRowNameCoulumn().size();
			Assert.assertTrue(countAfter > countBefore);
		} else if (entity.equals("Branch")) {
			countAfter = branch.getBranchRowNameColumn().size();
			Assert.assertTrue(countAfter > countBefore);
		}
	}

	// / Negative Cases for Create Entity

	@Given("^User selects \"([^\"]*)\" Menu$")
	public void user_selects_Menu(String entityoption) throws Throwable {
		if (entityoption.equals("Staff")) {
			home.getListItemStaffFromEntitiesMenu().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getCreateStaffButton(), "visibility");
		} else if (entityoption.equals("Branch")) {
			home.getListItemBranchFromEntitiesMenu().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getCreateBranchButton(), "visibility");
		}

	}

	@When("^Clicks on Cancel Button for \"([^\"]*)\"$")
	public void clicks_on_Cancel_Button(String entity) throws Throwable {
		if (entity.equals("Staff")) {
			staff.getCancelButton().click();

		} else if (entity.equals("Branch")) {
			branch.getCancelButton().click();
		}

	}

	@Then("^User should not see the cancelled entry for respective \"([^\"]*)\"$")
	public void user_should_not_see_the_cancelled_entry_for_respective(
			String entity) throws Throwable {
		if (entity.equals("Staff")) {
			countAfter = staff.getStaffRowNameCoulumn().size();
			Assert.assertTrue(countAfter == countBefore);
		} else if (entity.equals("Branch")) {
			countAfter = branch.getBranchRowNameColumn().size();
			Assert.assertTrue(countAfter == countBefore);
		}
	}

	@When("^User enters the name as \"([^\"]*)\"$")
	public void user_enters_the_name_as(String arg1) throws Throwable {

	}

	@Then("^User should receive \"([^\"]*)\"$")
	public void user_should_receive(String arg1) throws Throwable {

	}

	// Edit Scenario
	@When("^User clicks on Edit Button for ([^\"]*)$")
	public void user_clicks_on_Edit_Button(String entity) throws Throwable {
		if (entity.equals("Staff")) {
		} else if (entity.equals("Branch")) {

		}
	}

	
	// Delete Entity
	@When("^User clicks on Delete Button for \"([^\"]*)\"$")
	public void user_clicks_on_Delete_Button_for_Staff(String entity)
			throws Throwable {

	}

	
	@When("^User opens Settings from Account menu$")
	public void user_opens_Settings_from_Account_menu() throws Throwable {

	}

	@Then("^User should be able to edit the logged in account information$")
	public void user_should_be_able_to_edit_the_logged_in_account_information()
			throws Throwable {

	}

	// E2E

	@When("^User creates a new \"([^\"]*)\" entry with name \"([^\"]*)\"$")
	public void user_creates_a_new_entry_with_name(String entity, String name)
			throws Throwable {
		if (entity.equals("Staff")) {
			staff.getCreateStaffButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getSaveButton(), "visibility");
			staff.getFormInputName().sendKeys(name);

			countBefore = staff.getStaffRowNameCoulumn().size();
			staff.getSaveButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getSaveButton(), "invisibility");

		} else if (entity.equals("Branch")) {
			branch.getCreateBranchButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getSaveButton(), "visibility");
			branch.getFormInputName().sendKeys(name);
			countBefore = branch.getBranchRowNameColumn().size();
			branch.getFormInputBranch().sendKeys("CSE");
			countBefore = branch.getBranchRowNameColumn().size();
			branch.getSaveButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getSaveButton(), "invisibility");

		}
	}

	@Then("^User should be able to see the created entry in the \"([^\"]*)\" list with name \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_created_entry_in_the_list_with_name(
			String entity, String name) throws Throwable {
		if (entity.equals("Staff")) {

			countAfter = staff.getStaffRowNameCoulumn().size();
			Assert.assertTrue(countAfter > countBefore);
		} else if (entity.equals("Branch")) {
			countAfter = branch.getBranchRowNameColumn().size();
			Assert.assertTrue(countAfter > countBefore);
		}

	}

	@When("^User clicks on View Button for \"([^\"]*)\"$")
	public void user_clicks_on_View_Button_for(String arg1) throws Throwable {

	}

	@Then("^User should be able to see the specific \"([^\"]*)\" with name \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_specific_with_name(
			String entity, String name) throws Throwable {
		if (entity.equals("Staff")) {
			int count = staff.getStaffRowNameCoulumn().size();
			
			for (int i = 0; i < count; i++) {
				if (staff.getStaffRowNameCoulumn().get(i).getText()
						.equals(name)) {
					staff.getViewStaffButton().get(i).click();
					break;
				}
			}
			Assert.assertTrue(staff.getStaffViewFormName()
					.getAttribute("value").contains(name));
			staff.getBackButtonOnViewForm().click();

		} else if (entity.equals("Branch")) {

			int count = branch.getBranchRowNameColumn().size();
			for (int i = 0; i < count; i++) {
				if (branch.getBranchRowNameColumn().get(i).getText()
						.equals(name)) {
					branch.getViewBranchButton().get(i).click();
					break;
				}
			}
			Assert.assertTrue(branch.getBranchViewFormName()
					.getAttribute("value").equals(name));
			branch.getBackButtonOnViewForm().click();
		}

	}

	@When("^User clicks on Edit Button for \"([^\"]*)\"$")
	public void user_clicks_on_Edit_Button_for(String arg1) throws Throwable {

	}

	@Then("^User should be able to edit the specific \"([^\"]*)\" having \"([^\"]*)\" with name \"([^\"]*)\"$")
	public void user_should_be_able_to_edit_the_specific_with_name(
			String entity, String name, String editedname) throws Throwable {
		if (entity.equals("Staff")) {
			int edit = staff.getEditStaffButton().size();
			
			for (int i = 0; i < edit; i++) {
				if (staff.getStaffRowNameCoulumn().get(i).getText()
						.equals(name)) {
					staff.getEditStaffButton().get(i).click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(staff.getCancelButton(),
									"visibility");
					staff.getFormInputName().clear();
					staff.getFormInputName().sendKeys(editedname);
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(staff.getSaveButton(),
									"clickable");
					staff.getSaveButton().click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(staff.getSaveButton(),
									"invisibility");
					Assert.assertTrue(staff.getStaffRowNameCoulumn().get(i)
							.getText().equals(editedname));

					break;
				}
			}

		}
		if (entity.equals("Branch")) {
			int edit = branch.getEditBranchButton().size();
			
			for (int i = 0; i < edit; i++) {
				if (branch.getBranchRowNameColumn().get(i).getText()
						.equals(name)) {
					branch.getEditBranchButton().get(i).click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(
									branch.getCancelButton(), "visibility");
					branch.getFormInputName().clear();
					branch.getFormInputName().sendKeys(editedname);
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(branch.getSaveButton(),
									"clickable");
					branch.getSaveButton().click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(branch.getSaveButton(),
									"invisibility");
					Assert.assertTrue(branch.getBranchRowNameColumn().get(i)
							.getText().equals(editedname));

					break;
				}
			}

		}
	}

	@Then("^User should be able to Delete the specific \"([^\"]*)\" with name \"([^\"]*)\"$")
	public void user_should_be_able_to_Delete_the_specific_with_name(
			String entity, String editedname) throws Throwable {

		
		if (entity.equals("Staff")) {
			int countBeforeDelete = staff.getDeleteStaffButton().size();
			for (int i = 0; i < countBeforeDelete; i++) {
				if (staff.getStaffRowNameCoulumn().get(i).getText()
						.equals(editedname)) {
					staff.getDeleteStaffButton().get(i).click();
					testContext
							.getWebDriverManager()
							.getExplicitWaitForElement(
									staff.getDeleteConfirmation(), "visibility");
					staff.getDeleteConfirmation().click();
					
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(staff.getCancelButton(),
									"invisibility");
					break;
				}
			}

			int countAfterDelete = staff.getStaffRowNameCoulumn().size();
			Assert.assertTrue(countBeforeDelete > countAfterDelete);

			
		} else if (entity.equals("Branch")) {
			int countBeforeDelete = branch.getDeleteBranchButton().size();
			for (int i = 0; i < countBeforeDelete; i++) {
				if (branch.getBranchRowNameColumn().get(i).getText()
						.equals(editedname)) {
					branch.getDeleteBranchButton().get(i).click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(
									branch.getDeleteConfirmation(),
									"visibility");
					branch.getDeleteConfirmation().click();
					testContext.getWebDriverManager()
							.getExplicitWaitForElement(
									branch.getCancelButton(), "invisibility");
					break;
				}
			}

			int countAfterDelete = branch.getBranchRowNameColumn().size();
			Assert.assertTrue(countBeforeDelete > countAfterDelete);

		}

	}

	@When("^User clicks on create \"([^\"]*)\" entry with name \"([^\"]*)\"$")
	public void user_clicks_on_create_entry_with_name(String entity, String name)
			throws Throwable {
		if (entity.equals("Staff")) {
			staff.getCreateStaffButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					staff.getSaveButton(), "visibility");
			staff.getFormInputName().sendKeys(name);
		} else if (entity.equals("Branch")) {
			branch.getCreateBranchButton().click();
			testContext.getWebDriverManager().getExplicitWaitForElement(
					branch.getSaveButton(), "visibility");
			branch.getFormInputName().sendKeys(name);
		}
	}

	@Then("^User should receive an error message \"([^\"]*)\" for the incorrect name format for the respective \"([^\"]*)\"$")
	public void user_should_receive_an_error_message_for_the_incorrect_name_format(
			String message, String entity) throws Throwable {
		if (entity.equals("Staff")) {
			int count = staff.getStaffFailureChecks().size();
			
			if (message.equals("This field is required.")) {
				
				for (int i = 0; i < count; i++) {
					
					Assert.assertTrue(staff.getStaffFailureChecks().get(i)
							.getText().equals(message));
					break;

				}

				staff.getCancelButton().click();
			}

			else if (message
					.equals("This field cannot be longer than 50 characters.")) {
				staff.getFormInputName()
						.sendKeys(
								"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				for (int i = 0; i < count; i++) {

					Assert.assertTrue(staff.getStaffFailureChecks().get(i)
							.getText().equals(message));
					break;

				}

				staff.getCancelButton().click();

			}

			else if (message
					.equals("This field should follow pattern ^[a-zA-Z\\s]*$.")) {
				staff.getFormInputName().sendKeys("Akshat1Narang");
				for (int i = 0; i < count; i++) {

					Assert.assertTrue(staff.getStaffFailureChecks().get(i)
							.getText().equals(message));
					break;
				}

				staff.getCancelButton().click();
			}
		} else if (entity.equals("Branch")) {
			int count = staff.getStaffFailureChecks().size();
			boolean flag = false;
			if (message.equals("This field is required.")) {
				staff.getFormInputName().clear();
				for (int i = 0; i < count; i++) {

					if (staff.getStaffFailureChecks().get(i).getText()
							.equals(message)) {
						flag = true;
						break;
					}
				}
				Assert.assertTrue(flag);
				staff.getCancelButton().click();
			}

			else if (message
					.equals("This field cannot be longer than 50 characters.")) {
				staff.getFormInputName()
						.sendKeys(
								"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				for (int i = 0; i < count; i++) {

					if (staff.getStaffFailureChecks().get(i).getText()
							.equals(message)) {
						flag = true;
						break;
					}
				}
				Assert.assertTrue(flag);
				staff.getCancelButton().click();
				}

			else if (message
					.equals("This field should follow pattern ^[a-zA-Z\\s]*$.")) {
				staff.getFormInputName().sendKeys("Akshat1Narang");
				for (int i = 0; i < count; i++) {

					if (staff.getStaffFailureChecks().get(i).getText()
							.equals(message)) {
						flag = true;
						break;
					}
				}
				Assert.assertTrue(flag);
				staff.getCancelButton().click();
			}

		}
	}
	
	@When("^User searches for a \"([^\"]*)\" using \"([^\"]*)\"$")
	public void user_searches_for_a_document_using(String entity,String attribute) throws Throwable {
		if(entity.equals("Staff")){
		if(attribute.equals("name")){
		  staff.getSearchInput().sendKeys(attribute);
		 
	   }
	   else if(attribute.equals("id")){
		   staff.getSearchInput().sendKeys(attribute);
	   }
	   else if(attribute.equals("code")){
		   staff.getSearchInput().sendKeys(attribute);
	   }
		staff.getSearchStaffButton().click();
		}
		
		else if(entity.equals("Branch")){
			if(attribute.equals("name")){
				  branch.getSearchInput().sendKeys(attribute);
			   }
			   else if(attribute.equals("id")){
				   branch.getSearchInput().sendKeys(attribute);
			   }
			   else if(attribute.equals("code")){
				   branch.getSearchInput().sendKeys(attribute);
			   }
			branch.getSearchBranchButton().click();
			
		}
	}

	@Then("^User should be able to view a list of all the matching results$")
	public void user_should_be_able_to_view_a_list_of_all_the_matching_results() throws Throwable {
	    
	}

}
