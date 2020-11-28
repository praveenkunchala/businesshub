@PCC_Mobile_Automation
Feature: Validate Article listing and individual Pages

@PCC_Mobile_All_Article_Page_Article_Validations
Scenario Outline: Open the Appium browser and navigate to the site
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify Page Title Text of All Article page
Then Verify Video option in the article

Examples: Different browser parameter
|browser	|
|Mobile		|


@PCC_Mobile_Verify_individual_Article_page
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
|Mobile		|

@PCC_Mobile_Verify_All_Article_design_and_Pagenation
Scenario Outline: Verify Individual Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify PageNation
Then Verify articles according to Pagenation

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Verify_All_Article_Pagenation
Scenario Outline: Verify Individual Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
And Click View All Article Button
Then Verify PageNation

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Linkden_Login
Scenario Outline: Validate Linkden Login Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Verify image after logging in

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_toolkit
Scenario Outline: Validate Toolkits Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Verify Mobile Toolkit cards in the Page
Then Verify the Toolkit article redirection feature

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_verify_Subscribe_Article_page
Scenario Outline: Verify Subscribe float Button Article Page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Check Preferences saved
Then Click Mobile Top menu button
Then Click Required Article in the Home page
Then get Subscribe button color and Click Subscribe
Then Click Mobile Top menu button
Then verify if other articles tagged to the same category are subscribed

Examples: 
|browser	|
|Mobile		|

@PCC_verify_Mobile_Subscribe_Article_page_linkdn_login
Scenario Outline: Verify Subscribe float Button Article Page without logging in first
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Required Article in the Home page
Then Click subscribe button in the Article Page
Then Click Mobile Top menu button
Then Click Required Article in the Home page
Then get Subscribe button color and Click Subscribe
Then Click Mobile Top menu button
Then verify if other articles tagged to the same category are subscribed

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Events_Validations
Scenario Outline: Events Site Validations
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then go to Events Page and verify Cards
Then Verify Events Article Page

Examples: 
|browser	|
|Mobile		|

#@PCC_Mobile_Footer_Linkden_Login
#Scenario Outline: Validate Linkden Login Page
#Given Open site in "<browser>"  
#Then navigate to the site
#Then verify the home page title
#And Accept the cookies
#Then Login from footer section
#
#Examples: 
#|browser	|
#|chrome		|

@PCC_Mobile_Validate_Subscribe_Preference
Scenario Outline: Validate if articles subscribed from preference page
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Change a preference to subscribed
Then Click Mobile Top menu button
Then Verify if the subscribed categorie is changed to subscribe

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Footer&MenuOptions
Scenario Outline: Open the browser and navigate to the site
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Verify the Followon links - Linkedin, Twitter
And Verify the Footer links - Accessibility, Privacy, Terms and Conditions
Then Verify RBS Logo
Then Click Mobile Top menu button
Then Validate Menu Options "Business Guidence"
Then Click Mobile Top menu button
Then Validate Menu Options "Market Trends"
Then Click Mobile Top menu button
Then Validate Menu Options "Sectors"
Then Click Mobile Top menu button
Then Validate Menu Toolkits or Events Options "Toolkits"
Then Click Mobile Top menu button
Then Validate Menu Toolkits or Events Options "Events"

Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Social_links
Scenario Outline: Validate Social Media Posts 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Navigate to first article
Then Verify Mobile article share functionality on Facebook
Then Check the post on Mobile Facebook
Then Navigate to first article
Then Verify article share functionality on Twitter
Then Check the post on Twitter
Then Click Mobile Top menu button
Then Click Linkden for logging in
Then Navigate to first article
Then Verify article share functionality on Linkden
Then Check the post on Linkden


Examples: 
|browser	|
|Mobile		|

@PCC_Mobile_Search_Validations
Scenario Outline: Validate Search Functionality 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Validate Mobile Search Icon for non loggedin user
Then search any text
Then Validate the Results with Search results tabs results
Then Click Article sub field in search results Page and Validate Results "<Search_Result_count>" and "<Search_Page_Last>"
Then Click SpotLight sub field in search results Page and Validate Results "<Spotlight_Number>" and "<Search_Page_Last>"
Then Click Toolkits sub field in search results Page and Validate Results "<Toolkit_Number>" and "<Search_Page_Last>"
Then Click Events sub field in search results Page and Validate Results "<Event_Number>" and "<Search_Page_Last>"

Examples: 
|browser	|Search_Result_count			|Search_Page_Last|Spotlight_Number				|Toolkit_Number					|Event_Number				|
|Mobile		|Search_Result_count_Articles	|Search_Page_Last|Search_Result_count_Spotlight	|Search_Result_count_toolkits	|Search_Result_count_Events	|

@PCC_Mobile_Home_Page_Articles
Scenario Outline: Verify Home Page Articles 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Validate Fields title in the home page "<Field_Title_Article>" and "<Actual_Field_Title_Article>"
Then Validate view all button in the Latest Articles field
Then Validate Mobile Page nation in Home page "<Latest_Article>" and "<PageNation_Webelement>"
Then Validate Fields title in the home page "<Field_Title>" and "<Actual_Field_Title>"
Then Validate Page nation in Home page "<SpotLight>" and "<PageNation_Spotlight>"
Then Validate Fields title in the home page "<Discover_Title>" and "<Actual_Discover_Title>"
Then Validate Mobile Page nation in Home page "<Discover_our_content_cards>" and "<PageNation_Discover>"

Examples: 
|browser	|Latest_Article		|PageNation_Webelement	|Field_Title_Article			|Actual_Field_Title_Article			|Field_Title				|Actual_Field_Title			|SpotLight				|PageNation_Spotlight		|Discover_Title			|Actual_Discover_Title	|Discover_our_content_cards	|PageNation_Discover|
|Mobile		|Latest_Count_Home	|Home_Page_Pagenation	|get_Latest_Article_Title_home|Actual_Latest_Article_Title_home	|get_Spotlight_Title_home	|Actual_Spotlight_Title_home|Spotlight_count_Home	|Spotlight_Pagenation_Count	|Discover_Title_Home	|Actual_Discover_Title	|Discover_our_content		|PageNation_Discover_Mobile|

