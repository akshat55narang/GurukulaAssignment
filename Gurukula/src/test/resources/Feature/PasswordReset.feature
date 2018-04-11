Feature: Forgot Password 

@RLogin
Scenario: Verify whether user is able to reset the password using the Reset Password Link
Given User opens Application in Browser
And User clicks on Login Button
When User clicks on /Did you forget your password?/
And enters his email address "akshat55narang@gmail.com"
Then User should receive the password reset link in the email
