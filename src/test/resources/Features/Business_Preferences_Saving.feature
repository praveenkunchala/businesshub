@Business_Preferences_Saving
Feature: Verify the user is able to save preferences
Scenario Outline:Saving Business Prferencess
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select preferences for 'your business' section
Then Click save preferences
Then Verify The page displays an 'successfully saved' message
Examples: 
|browser	|
|chrome		|
