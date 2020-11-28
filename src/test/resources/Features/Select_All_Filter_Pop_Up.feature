@Select_All_Filter_Pop_Up 
Feature: Verify clear all button on Pop Up 
Scenario Outline: Verifying Clear All buton 
	Given Open site in "<browser>" 
	Then navigate to the site 
	Then verify the home page title 
	And Accept the cookies 
	And Click View All Article Button 
	Then On the all articles page click on filter by category 
	Then Click on all select all button and Verify all the categories are selected for a topic 
	Examples: 
		|browser	|
		|chrome		|
		
		
		
		
