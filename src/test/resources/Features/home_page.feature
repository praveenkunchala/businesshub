@PCC_Home_page
Feature: Navigate to the Royal Bank of Scotland site

@PCC_Footer&MenuOptions
Scenario Outline: Open the browser and navigate to the site
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
#And click view all article button
Then Verify the Followon links - Linkedin, Twitter
And Verify the Footer links - Accessibility, Privacy, Terms and Conditions
Then Verify RBS Logo
Then Validate Menu Options "Business Guidence"
Then Validate Menu Options "Market Trends"
Then Validate Menu Options "Sectors"
Then Validate Menu Toolkits or Events Options "Toolkits"
Then Validate Menu Toolkits or Events Options "Events"


Examples: Different browser parameter
|browser	|
|chrome		|
#|safari	|
#|edge		|
#|firefox	|

@PCC_Social_links
Scenario Outline: Validate Social Media Posts 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Navigate to first article
Then Verify article share functionality on Facebook
Then Check the post on Facebook
Then Navigate to first article
Then Verify article share functionality on Twitter
Then Check the post on Twitter
Then Click Linkden for logging in
Then Navigate to first article
Then Verify article share functionality on Linkden
Then Check the post on Linkden


Examples: 
|browser	|
|chrome		|
#|safari|
#|edge		|
#|firefox	|

@PCC_Search_Validations
Scenario Outline: Validate Search Functionality 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Validate Search Icon for non loggedin user
Then search any text
Then Validate the Results with Search results tabs results
Then Click Article sub field in search results Page and Validate Results "<Search_Result_count>" and "<Search_Page_Last>"
Then Click SpotLight sub field in search results Page and Validate Results "<Spotlight_Number>" and "<Search_Page_Last>"
Then Click Toolkits sub field in search results Page and Validate Results "<Toolkit_Number>" and "<Search_Page_Last>"
Then Click Events sub field in search results Page and Validate Results "<Event_Number>" and "<Search_Page_Last>"

Examples: 
|browser	|Search_Result_count			|Search_Page_Last|Spotlight_Number				|Toolkit_Number					|Event_Number				|
|chrome		|Search_Result_count_Articles	|Search_Page_Last|Search_Result_count_Spotlight	|Search_Result_count_toolkits	|Search_Result_count_Events	|

@PCC_Home_Page_Articles
Scenario Outline: Verify Home Page Articles 
Given Open site in "<browser>"  
Then navigate to the site
Then verify the home page title
And Accept the cookies
Then Validate Fields title in the home page "<Field_Title_Article>" and "<Actual_Field_Title_Article>"
Then Validate view all button in the Latest Articles field
Then Validate Page nation in Home page "<Latest_Article>" and "<PageNation_Webelement>"
Then Validate Fields title in the home page "<Field_Title>" and "<Actual_Field_Title>"
Then Validate Page nation in Home page "<SpotLight>" and "<PageNation_Spotlight>"
Then Validate Fields title in the home page "<Discover_Title>" and "<Actual_Discover_Title>"
Then Validate Page nation in Home page "<Discover_our_content_cards>" and "<PageNation_Discover>"

Examples: 
|browser	|Latest_Article		|PageNation_Webelement|Field_Title_Article			|Actual_Field_Title_Article			|Field_Title				|Actual_Field_Title			|SpotLight				|PageNation_Spotlight		|Discover_Title			|Actual_Discover_Title	|Discover_our_content_cards	|PageNation_Discover|
|chrome		|Latest_Count_Home	|PageNation_count_Home|get_Latest_Article_Title_home|Actual_Latest_Article_Title_home	|get_Spotlight_Title_home	|Actual_Spotlight_Title_home|Spotlight_count_Home	|Spotlight_Pagenation_Count	|Discover_Title_Home	|Actual_Discover_Title	|Discover_our_content		|PageNation_Discover|


@PCC_Appium
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



