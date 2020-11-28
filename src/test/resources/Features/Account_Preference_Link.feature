@Account_Preference_Link
Feature: Verify once the user is logged in the footer should display Account preferences link
Scenario Outline: Verify the Preference link 
	Given Open site in "<browser>" 
	Then navigate to the site 
	Then verify the home page title 
	And Accept the cookies
	Then Click Linkden for logging in 
	Then The user is able to see the account preferences link in the footer
	Examples: 
		|browser	|
		|chrome		|
		
		
