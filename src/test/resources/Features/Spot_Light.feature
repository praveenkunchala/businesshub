@Spot_Light_Article
Feature: Verify the spotlight campaigns appear on the search results page 
Scenario Outline: Verify the spotlight campaigns 
	Given Open site in "<browser>" 
	Then navigate to the site 
	Then verify the home page title 
	And Accept the cookies 
	Then Search for a word from the campaign list on the searchbox in the front end 
	Then On the search results page, notice the result being displayed on the spotlight section eg:SPOTLIGHT 
	Then On the spotlight tab, verify the campaign is displayed 
	Then Also clicking on the spotlight result, the page can be verified 
	Examples: 
		|browser	|
		|chrome		|
		
		
