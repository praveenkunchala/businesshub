@deleting_Profile
Feature: Verify the styling for the Login button
Scenario Outline:Verify Login Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then click on delete my account button
And click confirm
Then verify The profile icon is hidden 'Account preferences' is removed from footer
Examples: 
		|browser	|
		|chrome		|
