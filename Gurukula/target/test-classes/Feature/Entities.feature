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
When User creates a new Staff entry with name "Akshat Narang"
Then User should be able to see the created entry in the Staff list with name "Akshat Narang"

@CreateBranch
Scenario: Verify whether user is able to create new Branch entry 
And User opens Entities Menu
And User selects Branch Menu
When User creates a new Branch entry with name "Computer Science"
And Branch Code "CSE"
Then User should be able to see the created entry in the Branch list with name "Computer Science"

@Negative
Scenario Outline: Verify whether a Branch or Staff entry is not created when Cancel Button is pressed 
And User opens Entities Menu
And User selects "<entity>" Menu
When User creates a new "<entity>" entry with name "<name>"
And Clicks on Cancel Button for "<entity>"
Then User should not see the cancelled entry for respective "<entity>"
Examples:
	|entity|name|
	|Branch|Computer Science|
	|Staff|Akshat Narang|

@E2E
Scenario Outline: Verify whether user is able to create new Branch entry 
And User opens Entities Menu
And User selects "<entity>" Menu
When User creates a new "<entity>" entry with name "<name>"
Then User should be able to see the created entry in the "<entity>" list with name "<name>"
When User clicks on View Button for "<entity>"
Then User should be able to see the specific "<entity>" with name "<name>"
#When User clicks on Edit Button for "<entity>"
#Then User should be able to edit the specific "<entity>" with name "<edited name>"
When User clicks on Delete Button for Branch
Then User should be able to Delete the specific "<entity>" with name "<edited name>"
Examples:
	|entity|name|edited_name|
	#|Branch|Computer Science|Electronics|
	|Staff|Akshat Narang|TestStaff|

@ViewBranch
Scenario: Verify whether user is able to view a specific Branch
When User clicks on Entities Menu 
And User clicks on Branch Entity
And User clicks on View Button for Branch
Then User should be able to see the specific Branch with name "Computer Science"


@ViewStaff
Scenario: Verify whether user is able to view a specific Staff
When User clicks on Entities Menu 
And User clicks on Staff Entity
And User clicks on View Button for Staff
Then User should be able to see the specific Staff with name "Akshat Narang"

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
