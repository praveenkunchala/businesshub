@Preference_Page
Feature: Verify the preference page contents

@Preference_Page_Validations
Scenario Outline:Preference page contains: First name Last name etc
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
@Preference_Page_View
Scenario Outline:Verify the user is able to access the preference page by clicking on the profile icon, top right of the screen.
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Once logged in the user is able to view the preference page
Examples: 
		|browser	|
		|chrome		|
@Preference_Categories
Scenario Outline:  Verify all categories are displayed on Your interests tab
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Choose your interest tab
Then Verify all categories are displayed on the page
Examples: 
		|browser	|
		|chrome		|