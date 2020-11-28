@Acast_Page_validations
Feature: Verify Acast page is displayed as expected
@Acast_Page
Scenario Outline:Verify Acast page is displayed as expected
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Search for the acast page on frontend eg:technically speaking
Then verify the acast pod contains the following: Title, date, mins, subscribe and share button
Examples: 
		|browser	|
		|chrome		|
@Acast_Page_facebook
Scenario Outline:Verify Acast have the ability to be shared on social networks FACEBOOK
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Search for the acast page on frontend eg:technically speaking
Then Verify article share functionality on Facebook Page
Then Check the post on Facebook Page
Examples: 
		|browser	|
		|chrome		|	
@Acast_Page_twitter
Scenario Outline:Verify Acast have the ability to be shared on social networks Twitter
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
#Then Search for the acast page on frontend eg:technically speaking
Then Verify article share functionality on Twitter page
Then Check the post on Twitter Page
Examples: 
		|browser	|
		|chrome		|
@Acast_Page_Linkedin
Scenario Outline:Verify Acast have the ability to be shared on social networks Linkden
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Search for the acast page on frontend eg:technically speaking
Then Verify article share functionality on Linkden page
Then Check the post on Linkden Page
Examples: 
		|browser	|
		|chrome		|