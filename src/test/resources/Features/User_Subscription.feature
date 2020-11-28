@User_Subscription
Feature: Verify the user is able to subscribe to emails on the my preference page
Scenario Outline:the user is able to subscribe to emails
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Click on the your interests tab 
Then Tick the check box to be updated for the latest emails 
Then Click save preferences
Then Verify The page displays an 'successfully saved' message on Your Interest screen
Examples: 
		|browser	|
		|chrome		|
