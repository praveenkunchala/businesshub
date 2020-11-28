@Login_Button
Feature: Verify the styling for the Login button
Scenario Outline:Verify Login Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
Then login Button is visible with login with linkedin Text
Examples: 
		|browser	|
		|chrome		|
