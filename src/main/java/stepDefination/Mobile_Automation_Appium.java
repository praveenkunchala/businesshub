package stepDefination;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Mobile_Automation_Appium extends Baseclass{
	static int Home_Article_count=0;
	
	@Then("^Click Mobile Top menu button$")
	public static void Click_Mobile_Menu() {
		try {
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Top_Menu_Click"))).click();
			Baseclass.explicitlyWait(2);
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Unable to click Mobile Top Menu due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Mobile Toolkit cards in the Page$")
	public static void Validate_tookits_Dropdown() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Tookits"))).click();
			String Card_Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Get_Toolkits_cards_text"))).getText();
			if(Card_Text.equalsIgnoreCase(elementProperties.getProperty("Toolkits_cards_text")))
			{
				test.log(LogStatus.PASS, "Toolkits Text is populating fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Toolkits Text is not populating fine");
			}
			Baseclass.explicitlyWait(4);
			String Toolkit_Dropdown_Text=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).getText();
			if(Toolkit_Dropdown_Text.equalsIgnoreCase((elementProperties.getProperty("Toolkit_Text_Dropdown"))))
			{
				test.log(LogStatus.PASS, "Text in Toolkits Mobile Dropdown is populating the default text fine as : "+Toolkit_Dropdown_Text);
			}
			else
			{
				test.log(LogStatus.FAIL, "Text in Toolkits Mobile Dropdown is not populating the default text. it is getting populated as : "+Toolkit_Dropdown_Text);
			}
			System.out.println("First card");
			String Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			System.out.println("First card : "+Article_name);
			Baseclass.explicitlyWait(3);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).click();
			System.out.println("First card : "+Article_name);
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Menu_Pre_startup"))).click();
			String Article_name_afterclick = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			if(Article_name.equalsIgnoreCase(Article_name_afterclick))
			{
				test.log(LogStatus.FAIL, "Clicked Pre-start up button and related cards are not displaying");
			}
			else
			{
				test.log(LogStatus.PASS, "Clicked Pre-start up button and related cards are getting displaying");
				Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			}
			Baseclass.explicitlyWait(5);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).click();
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Menu_startup"))).click();
			Article_name_afterclick = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			if(Article_name.equalsIgnoreCase(Article_name_afterclick))
			{
				test.log(LogStatus.FAIL, "Clicked Start up button and related cards are not displaying");
			}
			else
			{
				test.log(LogStatus.PASS, "Clicked Start up button and related cards are getting displaying");
				Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			}
			Baseclass.explicitlyWait(5);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).click();
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Menu_SME"))).click();
			Article_name_afterclick = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			if(Article_name.equalsIgnoreCase(Article_name_afterclick))
			{
				test.log(LogStatus.FAIL, "Clicked SME button and related cards are not displaying");
			}
			else
			{
				test.log(LogStatus.PASS, "Clicked SME button and related cards are getting displaying");
				Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
				
			}
			Baseclass.explicitlyWait(3);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).click();
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Menu_Corporate"))).click();
			
			Article_name_afterclick = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			if(Article_name.equalsIgnoreCase(Article_name_afterclick))
			{
				test.log(LogStatus.FAIL, "Clicked Corporate button and related cards are not displaying");
			}
			else
			{
				test.log(LogStatus.PASS, "Clicked Corporate button and related cards are getting displaying");
				Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			}
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Unable to validate Toolkits articles due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Mobile article share functionality on Facebook$")
	public void Verify_Mobile_Facebook_Share() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Share"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_User_Mobile"))).sendKeys(elementProperties.getProperty("Facebook_Username"));
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Pass_Mobile"))).sendKeys(elementProperties.getProperty("Facebook_Password"));
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Login_Mobile"))).click();
				Baseclass.explicitlyWait(Baseclass.timeout);
			
			try 
			{
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_login_error"))).isDisplayed();
				test.log(LogStatus.FAIL, "Facebook Login credentials are wrong");
			}
			catch (TimeoutException e) {
				String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
				NavigateToSite.Article_Title = NavigateToSite.Article_Title+dateFormat;
				System.out.println("Actual: "+NavigateToSite.Article_Title);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Mobile_pop_Text"))).sendKeys(NavigateToSite.Article_Title);
//				Baseclass.explicitlyWait(Baseclass.timeout);
				
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Mobile_Pop_share"))).click();
				test.log(LogStatus.PASS, "Post is shared on the facebook wall");
			}
			Baseclass.switchToNewWindow();
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@Then("^Check the post on Mobile Facebook$")
	public void Check_post_Mobile_Facebook() {
		try {
			
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
			
			Baseclass.navigateUrl(elementProperties.getProperty("Facebook"));
			Baseclass.explicitlyWait(5);
			        
			
			System.out.println("Crossed");
			Baseclass.Handle_Alerts();
			
			
			String Text = null;
			Baseclass.explicitlyWait(5);
//			Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Justnow"))).getText();
			
//				System.out.println("Text  Article class "+article);
			for(int i=0;i<=2;i++)
			{
				try
				{
					Baseclass.RefreshPage();
					Baseclass.explicitlyWait(5);
					WebElement article = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Mobile_FB")));
					Text = article.findElement(By.xpath(elementProperties.getProperty("Facebook_Mobile_Check2"))).getText();
					System.out.println("Text "+Text);
//					WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[4]/div/div[2]/section/article[1]/div/div[1]/div/span/p"));
//					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
////					Thread.sleep(500); 
//					Baseclass.explicitlyWait(5);
//					Object theTextIWant = ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",element);
//					String Search_icon = (String) theTextIWant;
//					System.out.println("Text "+Search_icon);
					
					break;
				}
				catch(NoSuchElementException e)
				{
					try
					{
//					Baseclass.explicitlyWait(Baseclass.timeout);
//					Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Mobile_Home"))).click();
						WebElement article = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Mobile_FB2")));
						Text = article.findElement(By.xpath(elementProperties.getProperty("Facebook_Mobile_Check"))).getText();
						System.out.println("Text2 "+Text);
						break;
					}
					
					catch(Exception e1)
					{
						e.printStackTrace();
					}
				}
			}
			
//				System.out.println("Text "+Search_icon);
				if(Text.equalsIgnoreCase(NavigateToSite.Article_Title))
				{
					test.log(LogStatus.PASS, "Logged into Facebook and checked the Post is shared on the facebook wall");
				}
				else
				{
					Baseclass.scrollDown();
					String SecondPost = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_second_Post"))).getText();
					System.out.println("SecondPost "+SecondPost);
					if(SecondPost.equalsIgnoreCase(NavigateToSite.Article_Title))
					{
						test.log(LogStatus.PASS, "Logged into Facebook and checked the Post is shared on the facebook wall");
					}
					else
					{
						test.log(LogStatus.FAIL, "Checked latest posts and unable to find the shared Post in Facebook");
					}
				}
				Baseclass.navigateUrl(elementProperties.getProperty("url"));
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Validate Mobile Search Icon for non loggedin user$")
	public static void Validate_Mobile_Search_Icon() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			System.out.println("Crossed");
		 	Object obj = jse.executeScript("return document.getElementsByTagName('form')[0].getAttribute('class')");
		 	System.out.println("Crossed2");
		 	String Search_icon = (String) obj;
		 	System.out.println("Crossed :"+Search_icon);
			if(Search_icon.startsWith("j"))
			{
				test.log(LogStatus.PASS, "Search icon is getting displayed without any search bar");
			}
			else
			{
				test.log(LogStatus.FAIL, "Search icon is getting displayed with search bar");
			}
			
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Top_Menu_Click"))).click();
			Baseclass.explicitlyWait(2);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("SVG_Search_Logo"))).click();
		    Baseclass.explicitlyWait(Baseclass.timeout);
			Object obj_After_Click = jse.executeScript("return document.getElementsByTagName('form')[0].getAttribute('class')");
		 	String Search_icon_After_Click = (String) obj_After_Click;
			if(Search_icon_After_Click.startsWith("j"))
			{
				test.log(LogStatus.PASS, "Search icon is getting displayed with search bar after clicked on search icon");
			}
			else
			{
				test.log(LogStatus.FAIL, "Search icon is getting displayed without any search bar after clicked on search icon");
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Validate Mobile Page nation in Home page \"(.*?)\" and \"(.*?)\"$")
	public static void Validate_Mobile_Page_nation_in_Home_page(String Article_Webelement, String PageNation_Webelement) {
		try {
			Home_Article_count=0;
			Baseclass.explicitlyWait(Baseclass.timeout);
			int count_articles = Baseclass.get_Count(elementProperties.getProperty(Article_Webelement));
			for(int i=0;i<4;i++)
			{
			try
			{
				Baseclass.explicitlyWait(2);
				boolean disabled = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty(PageNation_Webelement))).getAttribute("aria-disabled") != null;
				System.out.println("count "+disabled);
				if(disabled==false)
				{
					 int k = 0 / 0;
					 k++;
				}
				System.out.println("count2 "+disabled);
				break;
			}
			catch(ArithmeticException e) {
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty(PageNation_Webelement))).click();
				Home_Article_count++;
			}
			}
			System.out.println("count_PageNation "+Home_Article_count);
			
			if((Home_Article_count%3)==0)
			{
				count_articles = count_articles/4;
				Home_Article_count=(Home_Article_count+1)/2;
				if(count_articles==Home_Article_count)
				{
					test.log(LogStatus.PASS, "Number of articles in the home page are "+(count_articles*4)+" and right page nation is clickable for "+((Home_Article_count*2)-1)+" times");
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of articles in the home page are "+(count_articles*4)+" but right page nation is clickable for "+((Home_Article_count*2)-1)+" times");
				}
			}
			else
			{
				int Card_articles= count_articles/4;
				if((Card_articles+1)==Home_Article_count)
				{
					test.log(LogStatus.PASS, "Number of articles in the home page are "+count_articles+" and Pagenations populated are "+Home_Article_count);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of articles in the home page are "+count_articles+" and but the Pagenations populated are "+Home_Article_count);
				}
			}
				
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	
		@Then("^Mobile Search for the acast page on frontend eg:technically speaking$")
		public static void Mobile_search_for_the_acast_page_on_frontend_eg_technically_speaking() throws Throwable {
		    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("SVG_Search_Logo"))).click();
		    Baseclass.explicitlyWait(Baseclass.timeout);
		    Actions action = new Actions(driver);
			action.sendKeys(elementProperties.getProperty("Input_Text1")).perform();
			Baseclass.explicitlyWait(Baseclass.timeout);
			action.sendKeys(Keys.RETURN).perform();
//		    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Input_Text"))).sendKeys(elementProperties.getProperty("Input_Text1")+Keys.ENTER);
		    Baseclass.explicitlyWait(Baseclass.timeout);
		    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Technical_Text"))).click();
		    
		}
		
		 @Then("^Verify The Mobile page displays an 'successfully saved' message$")
		    public static void verify_the_Mobile_page_displays_an_successfully_saved_message() throws Throwable {
		    	try {
					String success_msg=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Successfull_Msg"))).getText();
					Baseclass.explicitlyWait(Baseclass.timeout);
					System.out.println("success_msg");
					if(success_msg.equals(elementProperties.getProperty("Msg_text")))
					{
					test.log(LogStatus.PASS, "Successfully saved message is  Displayed");
					}
					else if(success_msg.equals(elementProperties.getProperty("No_data")))
					{
						Baseclass.RefreshPage();
						test.log(LogStatus.PASS, "'No changes to save' message is  Displayed");
						Mobile_Automation_Appium.select_Mobile_preferences_for_your_business_section();
						Business_Preferences_Saving.click_save_preferences();
						Mobile_Automation_Appium.verify_the_Mobile_page_displays_an_successfully_saved_message_After();
					}
					else
					{
						test.log(LogStatus.FAIL, "Successfully saved Message is not displayed");
					}
				} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
					test.log(LogStatus.FAIL, "Successfully saved Message is not displayed");
					e.printStackTrace();
				}
		    }
		 
		 @Then("^Select Mobile preferences for 'your business' section$")
		    public static void select_Mobile_preferences_for_your_business_section() throws Throwable {
				WebElement flag = Baseclass.driver
						.findElement(By.xpath(elementProperties.getProperty("Delete_button")));
				((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
		        Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Tab"))).click();
		       WebElement bt= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Type")));
		    Select s=new Select(bt);
		    s.selectByIndex(3);
		    WebElement bto=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_turnover")));
		    Select t=new Select(bto);
		    t.selectByIndex(1);
		    WebElement bl=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_location")));
		    Select r=new Select(bl);
		    r.selectByIndex(2);
		    Baseclass.scrollDownFull();
		   
		    
		    }
		 
		 public static void verify_the_Mobile_page_displays_an_successfully_saved_message_After() throws Throwable {
		    	try {
		    		Baseclass.explicitlyWait(3);
		    		String success_msg=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Successfull_Msg"))).getText();
					Baseclass.explicitlyWait(Baseclass.timeout);
					System.out.println("success_msg");
					if(success_msg.equals(elementProperties.getProperty("Msg_text")))
					{
					test.log(LogStatus.PASS, "Successfully saved message is  Displayed");
					}
					else if(success_msg.equals(elementProperties.getProperty("No_data")))
					{
						Baseclass.RefreshPage();
						test.log(LogStatus.FAIL, "Failed to save preference");
					}
					else
					{
						test.log(LogStatus.FAIL, "Successfully saved Message is not displayed");
					}
				} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
					test.log(LogStatus.FAIL, "Successfully saved Message is not displayed");
					e.printStackTrace();
				}
		    }

		 @Then("^Mobile Search for a word from the campaign list on the searchbox in the front end$")
			public void Mobile_search_for_a_word_from_the_campaign_list_on_the_searchbox_in_the_front_end() throws Throwable {
				WebElement flag = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Spot_Light")));
				((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("SVG_Search_Logo"))).click();
				Baseclass.explicitlyWait(Baseclass.timeout);
				Actions action = new Actions(driver);
				action.sendKeys(elementProperties.getProperty("Spot_Light_Text")).perform();
				Baseclass.explicitlyWait(Baseclass.timeout);
				action.sendKeys(Keys.RETURN).perform();
				Baseclass.explicitlyWait(Baseclass.timeout);
			}
}
