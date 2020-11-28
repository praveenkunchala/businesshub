@Dropdowns_Selection
Feature: Verify the user is able to select an option from the drop downs
@Business_location_Saving
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business location' from the drop down menu
Examples: 
		|browser	|
		|chrome		|
		
@Business_Type_Saving		
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business type' from the drop down menu
Examples: 
		|browser	|
		|chrome		|

@Business_Turn_Over_Saving		
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business turn over' from the drop down menu
Examples: 
		|browser	|
		|chrome		|
@Business_Preferences_Saving
Scenario Outline: Verify the user is able to save preferences
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