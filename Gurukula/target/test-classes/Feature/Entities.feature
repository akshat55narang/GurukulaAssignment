Feature: Entities Overview 

Background: User is Logged in with valid credentials
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
		| username  | password  |
        | admin     | admin     | 
And User is able to login to the Application 

@Entitylist
Scenario: Verify whether user is able to view Branch and Staff in the Entities Menu
When User clicks on Entities Menu 
Then User should be able to view Branch and Staff values in the Entity list

@CreateStaff
Scenario: Verify whether user is able to create new staff entry 
And User opens Entities Menu
And User selects Staff Menu
When User creates a new Staff entry 
Then User should be able to see the created entry in the Staff list

@CreateBranch
Scenario: Verify whether user is able to create new Branch entry 
And User opens Entities Menu
And User selects Branch Menu
When User creates a new Branch entry 
Then User should be able to see the created entry in the Branch list

@ViewBranch
Scenario: Verify whether user is able to view a specific Branch
When User clicks on Entities Menu 
And User clicks on Branch Entity
And User clicks on View Button for Branch
Then User should be able to see the specific Branch with name "ComputerScience"

@ViewStaff
Scenario: Verify whether user is able to view a specific Staff
When User clicks on Entities Menu 
And User clicks on Staff Entity
And User clicks on View Button for Staff
Then User should be able to see the specific Staff with name "akshatnarang"

@EditBranch
Scenario: Verify whether user is able to edit a specific Branch
When User clicks on Entities Menu 
And User clicks on Branch Entity
And User clicks on Edit Button for Branch
Then User should be able to edit the specific Branch with name "Computer Science"

@EditStaff
Scenario: Verify whether user is able to edit a specific Staff
When User clicks on Entities Menu 
And User clicks on Staff Entity
And User clicks on Edit Button for Staff
Then User should be able to edit the specific Staff with name "akshat narang"

@DeleteBranch
Scenario: Verify whether user is able to delete a specific Branch
When User clicks on Entities Menu 
And User clicks on Branch Entity
And User clicks on Delete Button for Branch
Then User should be able to Delete the specific Branch with name "Computer Science"

@DeleteStaff
Scenario: Verify whether user is able to delete a specific Staff
When User clicks on Entities Menu 
And User clicks on Staff Entity
And User clicks on Delete Button for Staff
Then User should be able to Delete the specific Staff with name "akshat narang"
