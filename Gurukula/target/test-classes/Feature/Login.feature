Feature: Login 
This feature is used to allow only the valid users to log into the Gurukula application.

Background: User Login
Given User opens Application in Browser
And User clicks on Login Button

@Login
Scenario Outline: Verify whether user is able to login with Valid Username and Password
When User enters valid "<username>" and "<password>"
Then User should be able to Login
Examples:
          | username  | password  |
          | admin     | admin     |

@Login    
Scenario Outline:: Verify whether user is able to login with Invalid Username or Password
When User enters invalid "<username>" or invalid "<password>"
Then User should not be able to Login 
Examples:
		| username  | password  |
        | invaliduser     | admin     |
        | admin     | invalidpassword     | 

@Login
Scenario: Verify whether user is able to logout of the application 
And User enters valid credentials
		| username  | password  |
        | admin     | admin     |   
And User is able to login to the Application  
When User opens Account Menu
And User clicks on logout button
Then User should be able to logout of the application

@Logout
Scenario: Verify whether user is able to edit the logged in account information 
And User enters valid credentials
		| username  | password  |
        | admin     | admin     |   
And User is able to login to the Application  
When User opens Settings from Account menu
Then User should be able to edit the logged in account information












