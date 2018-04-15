Feature: Update Account Password
This feature is used to update the password for the user account currently logged into the 
Gurukula Application.

Background: User is Logged in with valid credentials
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
| username | password |
| admin | admin | 
And User is able to login to the Application
And User clicks on Accounts Menu
And User opens Password Menu

@UpdateAccountPassword
Scenario: Verify whether user is able to update its respective account password
When User enters New Password as "testpassword"
And User enters matching Confirmation Password as "testpassword"
And User clicks on Save Button
Then User the new Password should be updated successfully with message "Password changed!".

@UpdateAccountPassword
Scenario Outline: Verify whether user receives a message when password is less than 5 characters
When User enters New Password as "<new_password>"
Then User should receive an error message "<errormessage>"
Examples:
	|new_password|errormessage|
	|abc|Your password is required to be at least 5 characters.|
	|adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa|Your password cannot be longer than 50 characters.|

@UpdateAccountPassword
Scenario Outline: Verify whether user receives a message when password confirmation is less than 5 characters
When User enters matching Confirmation Password as "<confirmation_password>"
Then User should receive an error message "<errormessage>"
Examples:
	|confirmation_password|errormessage|
	|abc|Your confirmation password is required to be at least 5 characters.|
	|adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa|Your confirmation password cannot be longer than 50 characters.|

@UpdateAccountPassword
Scenario: Verify whether user receives a message when password confirmation is more than 50 characters
When User enters New Password as "akshatnarang" 
And User enters matching Confirmation Password as "akshatnarang111"
And User clicks on Save Button
Then User should receive an error message "The password and its confirmation do not match!"


