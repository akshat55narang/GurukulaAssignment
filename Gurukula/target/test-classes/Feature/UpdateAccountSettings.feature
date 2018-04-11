Feature: Update User Settings 

Background: User is Logged in with valid credentials
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
| username | password |
| admin | admin | 
And User is able to login to the Application 
And User clicks on Accounts Menu
And User opens Settings Menu

@R1Login
Scenario: Verify whether user is able to update the settings for its profile
When User updates all the settings
And User clicks on Save
Then User should receive a confirmation of updated settings with the updated Settings

@R1Login
Scenario: Verify whether the length of the First Name and Last Name field is 50
Then The maximum length of First Name and Last Name should be 50

@R1Login
Scenario: Verify whether user receives a message when email is more than 50 characters
When User enters email "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com"
Then User should receive an error message for email "Your e-mail cannot be longer than 50 characters."

@R1Login
Scenario: Verify whether user receives a message when email is less than 5 characters
When User enters email "a@c"
Then User should receive an error message for email "Your e-mail is required to be at least 5 characters."

@R1Login
Scenario: Verify whether user receives a message when email is invalid
When User enters email "a"
Then User should receive an error message for email "Your e-mail is invalid."