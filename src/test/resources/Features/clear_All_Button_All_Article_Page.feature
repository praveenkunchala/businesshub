@clear_All_Button_All_Article_Page
Feature: Verify clear all button on the all articles page
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
		|chrome		|