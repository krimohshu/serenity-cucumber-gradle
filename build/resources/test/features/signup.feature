Feature: Signup user

@ui @pageobject @signup
Scenario: Register a new user for ETSY website
Given user is at Etsy homepage
When user submits the registration form
Then user should get registration confirmation message