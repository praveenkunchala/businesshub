@Preference_Page_Validations
Feature: Verify the preference page contains: First name Last name etc
Scenario Outline:Preference page validations
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then validate preference Page Objects
Examples: 
		|browser	|
		|chrome		|