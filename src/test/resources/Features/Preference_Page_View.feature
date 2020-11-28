@Preference_Page_View
Feature: Verify the user is able to access the preference page by clicking on the profile icon, top right of the screen.
Scenario Outline:Preference page Access After clicking on profile icon
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