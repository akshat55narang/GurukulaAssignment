Feature: Register a New User

Background: User Login
Given User opens Application in Browser
And User clicks on Register in Accounts Menu

@Register
Scenario: Verify whether a new user is able to Register for gurukula
When User enters the Registration details
And clicks on Register
Then User should register his/her account successfully

@Register
Scenario: Verify whether the Register is deactivated by default
Then Register button should be disabled

Scenario: Verify whether the Register is deactivated until all the mandatory checks on fields are met
When User doesnot enter all the mandatory fields
Then Register button should be disabled

@Register
Scenario: Verify whether user receives a message when login is more than 50 characters
When User enters login name "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
Then User should receive an error message "Your login cannot be longer than 50 characters."

@Register
Scenario Outline: Verify whether user receives a message when login contains special characters or Uppercase characters
When User enters login name "<loginname>"
Then User should receive an error message for login name "Your login can only contain lower-case letters and digits."
Examples:
|loginname|
|AkshatNarang|
|akshatnarang@|

Scenario: Verify whether user receives a message when email is more than 50 characters
When User enters email "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com"
Then User should receive an error message "Your e-mail cannot be longer than 50 characters."

Scenario: Verify whether user receives a message when email is less than 5 characters
When User enters email "a@c"
Then User should receive an error message "Your e-mail is required to be at least 5 characters."

Scenario: Verify whether user receives a message when password is less than 5 characters
When User enters password "abc"
Then User should receive an error message "Your password is required to be at least 5 characters."

Scenario: Verify whether user receives a message when password is more than 50 characters
When User enters password "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa"
Then User should receive an error message "Your password is required to be at least 5 characters."

Scenario: Verify whether user receives a message when password confirmation is less than 5 characters
When User enters password "abc"
Then User should receive an error message "Your confirmation password is required to be at least 5 characters."

Scenario: Verify whether user receives a message when password confirmation is more than 50 characters
When User enters password "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa"
Then User should receive an error message "Your confirmation password cannot be longer than 50 characters."

Scenario: Verify whether user receives a message when password confirmation is more than 50 characters
When User enters password "akshatnarang" and password confirmation "akshatnarang111"
Then User should receive an error message "The password and its confirmation do not match!"




