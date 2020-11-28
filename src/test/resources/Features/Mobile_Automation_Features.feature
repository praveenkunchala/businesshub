@PCC_Mobile_Automation_Updated
Feature: Mobile testing on the site

@Acast_Mobile_Page
Scenario Outline:Verify Acast page is displayed as expected
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Mobile Search for the acast page on frontend eg:technically speaking
Then verify the acast pod contains the following: Title, date, mins, subscribe and share button
Examples: 
		|browser	|
		|Mobile		|
		
@Account_Mobile_Preference_Link
Scenario Outline: Verify the Preference link 
	Given Open site in "<browser>" 
	Then navigate to the site 
	Then verify the home page title 
	And Accept the cookies
	Then Click Mobile Top menu button
	Then Click Linkden for logging in 
	Then The user is able to see the account preferences link in the footer
	Examples: 
		|browser	|
		|Mobile		|
		
@Business_Mobile_Preferences_Saving
Scenario Outline:Saving Business Prferencess
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select preferences for 'your business' section
Then Click save preferences
Then Verify The Mobile page displays an 'successfully saved' message
Examples: 
|browser	|
|Mobile		|

@clear_Mobile_All_Button_All_Article_Page
Scenario Outline:Verifying Clear All buton
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then On the all articles page click on filter by category
Then Select the category by checking on the check box and click apply
Then Verify the page only displays the selected categories
Then Now click on clear all button on the page
Then verify the text appears on the page' you are viewing all articles'
Then Verify all categories are now displayed on the view all articles page

Examples: 
		|browser	|
		|Mobile		|
		
@clear_Mobile_All_Button_On_Pop_Up
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
		|Mobile		|
		
@Clicking_Mobile_On_Logo
Scenario Outline:Verify Logo Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Click on Bank logo
Then verify home page title after clicking on logo
Examples: 
		|browser	|
		|Mobile		|
		
@deleting_Mobile_Profile
Scenario Outline:Verify Login Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then click on delete my account button
And click confirm
Then verify The profile icon is hidden 'Account preferences' is removed from footer
Examples: 
		|browser	|
		|Mobile		|
		
@Business_Mobile_location_Saving
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business location' from the drop down menu
Examples: 
		|browser	|
		|Mobile		|
		
@Business_Mobile_Type_Saving		
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business type' from the drop down menu
Examples: 
		|browser	|
		|Mobile		|
		
@Business_Mobile_Turn_Over_Saving		
Scenario Outline: Verify the user is able to select an option
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Select 'your business' section
Then Select a 'business turn over' from the drop down menu
Examples: 
		|browser	|
		|Mobile		|
		
@Login_Mobile_Button
Scenario Outline:Verify Login Button
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
Then login Button is visible with login with linkedin Text
Examples: 
		|browser	|
		|Mobile		|
		
@Preference_Mobile_Categories
Scenario Outline: Verify all categories
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Choose your interest tab
Then Verify all categories are displayed on the page
Examples: 
		|browser	|
		|Mobile		|
		
@Preference_Mobile_Page_Validations
Scenario Outline:Preference page validations
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then validate preference Page Objects
Examples: 
		|browser	|
		|Mobile		|
		
@Preference_Mobile_Page_View
Scenario Outline:Preference page Access After clicking on profile icon
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Once logged in the user is able to view the preference page
Examples: 
		|browser	|
		|Mobile		|
		
@Preference_Mobile_Appium_Categories
Scenario Outline:  Verify all categories are displayed on Your interests tab
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Choose your interest tab
Then Verify all categories are displayed on the page
Examples: 
		|browser	|
		|Mobile		|
		
@Select_Mobile_All_Filter_Pop_Up  
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
		|Mobile		|
		
@Spot_Light_Mobile_Article
Scenario Outline: Verify the spotlight campaigns 
	Given Open site in "<browser>" 
	Then navigate to the site 
	Then verify the home page title 
	And Accept the cookies 
	Then Mobile Search for a word from the campaign list on the searchbox in the front end 
	Then On the search results page, notice the result being displayed on the spotlight section eg:SPOTLIGHT 
	Then On the spotlight tab, verify the campaign is displayed 
	Then Also clicking on the spotlight result, the page can be verified 
	Examples: 
		|browser	|
		|Mobile		|
		
@User_Mobile_Subscription
Scenario Outline:the user is able to subscribe to emails
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Click on the profile icon at the top right of the page
Then Click on the your interests tab 
Then Tick the check box to be updated for the latest emails 
Then Click save preferences
Then Verify The page displays an 'successfully saved' message on Your Interest screen
Examples: 
		|browser	|
		|Mobile		|
		