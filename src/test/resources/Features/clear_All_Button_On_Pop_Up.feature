@clear_All_Button_On_Pop_Up
Feature: Verify clear all button on Pop Up
Scenario Outline:Verifying Clear All buton
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then On the all articles page click on filter by category
Then Click on select all button
Then Click clear all on the bottom of the pop up
Then Verify all the checkboxes are unchecked
Examples: 
		|browser	|
		|chrome		|