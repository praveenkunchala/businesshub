@Clicking_On_Logo
Feature: Verify Natwest logo is as per design and when clicked directs the user back to the homepage
Scenario Outline:Verify Logo Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Click on Bank logo
Then verify home page title after clicking on logo
Examples: 
		|browser	|
		|chrome		|
