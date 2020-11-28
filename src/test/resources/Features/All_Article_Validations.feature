@PCC_Article_Validations
Feature: Validate Article listing and individual Pages

@PCC_All_Article_Page
Scenario Outline: Validate All_Article page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title	
And Accept the cookies
And Click View All Article Button
Then Verify Page Title Text of All Article page
Then Verify Video option in the article
#Then Verify Filter option in the Articles Page

Examples: 
|browser	|
|chrome		|

@PCC_Verify_individual_Article_page
Scenario Outline: Verify Individual Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify Header Title and Text 
Then Verify individual article page
Then Verify fields in the bottom of the page

Examples: 
|browser	|
|chrome		|

@PCC_Verify_All_Article_design_and_Pagenation
Scenario Outline: Verify Individual Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify PageNation
Then Verify articles according to Pagenation
#Then Verify fields in the bottom of the page

Examples: 
|browser	|
|chrome		|

@PCC_Verify_All_Article_Pagenation
Scenario Outline: Verify Individual Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify PageNation

Examples: 
|browser	|
|chrome		|

@PCC_Linkden_Login
Scenario Outline: Validate Linkden Login Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Verify image after logging in

Examples: 
|browser	|
|chrome		|

@PCC_toolkit
Scenario Outline: Validate Toolkits Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then verify Toolkit cards in the Page
Then Verify the Toolkit article redirection feature

Examples: 
|browser	|
|chrome		|

@PCC_verify_Subscribe_Article_page
Scenario Outline: Verify Subscribe float Button Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Check Preferences saved
Then Click Required Article in the Home page
Then get Subscribe button color and Click Subscribe
Then verify if other articles tagged to the same category are subscribed

Examples: 
|browser	|
|chrome		|

@PCC_verify_Subscribe_Article_page_linkdn_login
Scenario Outline: Verify Subscribe float Button Article Page without logging in first
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Required Article in the Home page
Then Click subscribe button in the Article Page
Then Click Required Article in the Home page
Then get Subscribe button color and Click Subscribe
Then verify if other articles tagged to the same category are subscribed

Examples: 
|browser	|
|chrome		|

@PCC_Events_Validations
Scenario Outline: Events Site Validations
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then go to Events Page and verify Cards
Then Verify Events Article Page

Examples: 
|browser	|
|chrome		|

@PCC_Footer_Linkden_Login
Scenario Outline: Validate Linkden Login Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Login from footer section

Examples: 
|browser	|
|chrome		|

@PCC_Validate_Subscribe_Preference
Scenario Outline: Validate if articles subscribed from preference page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Linkden for logging in
Then Change a preference to subscribed
Then Verify if the subscribed categorie is changed to subscribe

Examples: 
|browser	|
|chrome		|
