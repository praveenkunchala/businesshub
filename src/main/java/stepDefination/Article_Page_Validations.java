package stepDefination;

import java.io.Console;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Article_Page_Validations extends Baseclass {
	static int Subscribe_article;
	String Split;
	int Article_Counts = 0;
	int article_count;
	String Article_Title;
	String Last_Updated;
	String Share_field;
	static int Preference_article;
	
	@And("^Click View All Article Button$")
	public void Click_View_All_Article_Button() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Article_Button"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			String Page_title=Baseclass.getPageTitle();
			if(Page_title.equals(elementProperties.getProperty("All_Article_Page_Title")))
			{
			test.log(LogStatus.PASS, "Article Button is clicked and user is re-directed to 'All Article' Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to click Article Button");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Unable to click Article Button");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Page Title Text of All Article page$")
	public void Verify_Page_Title_Text() {
		try {
			String Header_Text=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Article_Header_Title"))).getText().trim();
			System.out.println("Header_Text "+Header_Text);
			String Header_Description=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Article_Desc"))).getText().trim();
			System.out.println("Header_Description "+Header_Description);
			if(((Header_Text.trim()).equals(elementProperties.getProperty("All_Articles_Header_Text")))&&((Header_Description.trim()).equals(elementProperties.getProperty("All_Articles_Header_Desc"))))
			{
			test.log(LogStatus.PASS, "Header Text and Descriptions are Displaying as expected");
			}
			else
			{
				test.log(LogStatus.FAIL, "Header Text and Descriptions are not Displaying as expected");
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Header Text and Descriptions are not Displaying as expected due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify PageNation$")
	public void verify_Pagenation() {
		try {
			Baseclass.scrollDownFull();
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Next"))).isEnabled())
			{
				test.log(LogStatus.PASS, "Able to Click Next Button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to Click Next Button");
			}
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Previous"))).isEnabled())
			{
				test.log(LogStatus.FAIL, "Previous Button is enabled in 1st page");
			}
			else
			{
				test.log(LogStatus.PASS, "Previous Button is disabled in 1st page");
			}
			try
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_1"))).isEnabled())
				{
					test.log(LogStatus.FAIL, "1 option is not getting highlighted ");
				}
				else
				{
					test.log(LogStatus.PASS, "1 option is getting highlighted");
				}
			}
			catch(TimeoutException e)
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_1_Catch"))).isEnabled())
				{
					test.log(LogStatus.PASS, "1 option is getting highlighted ");
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to see 1 page option in the page nation");
				}
			}
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_2"))).isEnabled())
			{
				test.log(LogStatus.PASS, "Able to Click 2nd Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to Click 2nd Page");
			}
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_3"))).isEnabled())
			{
				test.log(LogStatus.PASS, "Able to Click 3rd Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to Click 2rd Page");
			}
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_dots"))).isEnabled())
			{
				test.log(LogStatus.FAIL, "Dots in the page nation are enabled");
			}
			else
			{
				test.log(LogStatus.PASS, "Dots in the page nation are displayed fine");
			}
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Last"))).isEnabled())
			{
				test.log(LogStatus.PASS, "Last Page number is displyed and is clickable");
			}
			else
			{
				test.log(LogStatus.PASS, "Last Page number is not displyed and is not clickable");
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Next"))).click();
			try
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_1"))).isEnabled())
				{
					test.log(LogStatus.PASS, "1 option is not getting highlighted in Page 2 ");
				}
				else
				{
					test.log(LogStatus.FAIL, "1 option is getting highlighted in Page 2");
				}
			}
			catch(TimeoutException e)
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_1_Catch"))).isEnabled())
				{
					test.log(LogStatus.FAIL, "1 option is getting highlighted in Page 2 ");
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to see 1 page option in the page nation in Page 2");
				}
			}
			try
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_2"))).isEnabled())
				{
					test.log(LogStatus.FAIL, "2 option is not getting highlighted in Page 2 ");
				}
				else
				{
					test.log(LogStatus.PASS, "2 option is getting highlighted in Page 2");
				}
			}
			catch(TimeoutException e)
			{
				if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_2_Catch"))).isEnabled())
				{
					test.log(LogStatus.PASS, "2 option is getting highlighted in Page 2 ");
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to see 2 page option in the page nation in Page 2");
				}
			}
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Previous"))).isEnabled())
			{
				test.log(LogStatus.PASS, "Previous Button is enabled in 2nd page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Previous Button is disabled in 2nd page");
			}
		
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Filter option in the Articles Page$")
	public void Verify_Filter_option() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Filter_Option_All_Articles"))).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Filter_Select_all"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Click Linkden for logging in$")
	public void Linkden_login() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkedn_Click"))).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Poup"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Username"))).sendKeys(elementProperties.getProperty("Linkden_User_name"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Password"))).sendKeys(elementProperties.getProperty("Linkden_password"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Signup"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Baseclass.explicitlyWait(10);
			String Url = Baseclass.get_Url();
			System.out.println("Url  :"+Url);
			if(Url.contains(elementProperties.getProperty("Profile_Page")))
			{
				test.log(LogStatus.PASS, "Site is getting re-directing to User profile page after login");
			}
			else
			{
				test.log(LogStatus.FAIL, "Site is not getting re-directing to User profile page after login");
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
						
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify image after logging in$")
	public void Image_after_login() throws InterruptedException, IOException {
		try {
			Baseclass.explicitlyWait(5);
			String Image =  Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Login_Image_after_login"))).getAttribute("src");
			HttpClient client = HttpClientBuilder.create().build(); 
			HttpGet request = new HttpGet(Image); 
			HttpResponse response = client.execute(request) ;
			System.out.println("Code : "+response.getCode());
			if (response.getCode() == 200)
				{
					test.log(LogStatus.PASS, "Image is getting populated as expected after user logging in"); 
				}
			else
			   {
				   test.log(LogStatus.FAIL, "Image is getting not populated as expected after user logging in");
			   }
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^verify Toolkit cards in the Page$")
	public void Toolkit_cards() throws InterruptedException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Tookits"))).click();
			
			String Card_Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Get_Toolkits_cards_text"))).getText();
			System.out.println("Card_Text : "+Card_Text);
			System.out.println("Card_Text2 : "+elementProperties.getProperty("Toolkits_cards_text"));
			
			if(Card_Text.equalsIgnoreCase(elementProperties.getProperty("Toolkits_cards_text")))
			{
				test.log(LogStatus.PASS, "Toolkits Text is populating fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Toolkits Text is not populating fine");
			}
			Actions actions = new Actions(driver);
			String Colour1 = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Pre_Start_up"))).getCssValue("background-color");
			System.out.println("Colour : "+Colour1);
			actions.moveToElement(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Pre_Start_up")))).perform();
			Baseclass.explicitlyWait(10);
			String Colour = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Pre_Start_up"))).getCssValue("background-color");
			System.out.println("Colour : "+Colour);
			if(Colour.equals(elementProperties.getProperty("Cards_Colour")))
			{
				test.log(LogStatus.PASS, "Colour is changing to White if hovered over the button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Colour is not changing to White if hovered over the button");
			}
			
			String Article_name = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).getText();
			Baseclass.explicitlyWait(5);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Pre_Start_up"))).click();
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
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Start_up"))).click();
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
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_SME"))).click();
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
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Corporate"))).click();
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
			test.log(LogStatus.FAIL, "Unable to automate Toolkits cards due to exception");
			e.printStackTrace();
		}
	}
	
	
	@Then("^Verify the Toolkit article redirection feature$")
	public void Toolkit_article() throws InterruptedException {
		try {
			if(browser.equalsIgnoreCase("Mobile"))
			{
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Mobile_dropdown"))).click();
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Mobile_Menu_Pre_startup"))).click();
				Baseclass.explicitlyWait(2);
				Baseclass.scrollDownFull();
			}
			else
			{
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Pre_Start_up"))).click();
			}
			Baseclass.explicitlyWait(5);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_card_text"))).click();
			Baseclass.explicitlyWait(5);
			String toolkits=driver.getCurrentUrl();
			String[] Url = toolkits.split("/");
			String Toolkit = Url[3];
			if(Toolkit.startsWith("toolkits"))
			{
				test.log(LogStatus.PASS, "Clicked Pre Start up button and selected first card in the page. Site is re-directed to toolkit's article page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clicked Pre Start up button and selected first card in the page. Site is not getting re-directed to toolkit's article page");
			}
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate Toolkit article re-direction");
			e.printStackTrace();
		}
	}
	
	@Then("^Click Required Article in the Home page$")
	public void Click_Required_Article() throws InterruptedException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance"))).click();
			Baseclass.explicitlyWait(4);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Cyber_Security_Bussiness"))).click();
			Baseclass.explicitlyWait(4);
			for(int k=1;k<=8;k++)
			{
				try
				{
					String Tag_Atricle = Baseclass.WaitElementVisible(driver, By.xpath("//*[@id=\"page-wrapper\"]/main/div[3]/div[1]/div[2]/div/div/div/div["+k+"]/article/a/div[2]/div[2]/div")).getText();
					System.out.println("Tag_Atricle : "+Tag_Atricle);
					if(Tag_Atricle.equalsIgnoreCase("Cyber Security"))
					{
						Baseclass.WaitElementVisible(driver, By.xpath("//*[@id=\"page-wrapper\"]/main/div[3]/div[1]/div[2]/div/div/div/div["+k+"]/article/a")).click();
						Subscribe_article = k;
						break;
					}
				}
				catch(TimeoutException e)
				{
					System.out.println("k : "+k);
				}
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Click required option due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^get Subscribe button color and Click Subscribe$")
	public void Click_Subscribe_Button() throws InterruptedException {
		try {
			Baseclass.explicitlyWait(3);
			//Scroll down and see if the Subscribe field is floating
//			Baseclass.scrollDown();
			try
			{
			String Subscribe_Color = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Subscribe"))).getCssValue("color");
			System.out.println("Subscribe_Color : "+Subscribe_Color);
			String Title = Baseclass.getPageTitle();
			System.out.println("Title : "+Title);
			if(Title.contains("RBS |"))
			{
				if(Subscribe_Color.equals(elementProperties.getProperty("RBS_Subscribe")))
				{
					test.log(LogStatus.PASS, "Subscribe button color is populating fine for RBS site");
				}
				else
				{
					test.log(LogStatus.FAIL, "Subscribe button color is not populating fine for RBS site");
				}
			}
			else if(Title.contains("NatWest |"))
			{
				if(Subscribe_Color.equals(elementProperties.getProperty("Natwest_Subscribe")))
				{
					test.log(LogStatus.PASS, "Subscribe button color is populating fine for Natwest site");
				}
				else
				{
					test.log(LogStatus.FAIL, "Subscribe button color is not populating fine for Natwest site");
				}
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Subscribe"))).click();
			Baseclass.explicitlyWait(5);
			String Subscribed = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_after_Click"))).getText();
			System.out.println("Subscribed : "+Subscribed);
			
			if(Subscribed.equals("SUBSCRIBED"))
			{
				test.log(LogStatus.PASS, "Subscribe button is changed to 'Subscribed' upon clicking on the button");
				driver.navigate().refresh();
				try
				{
					Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Tick")));
					test.log(LogStatus.PASS, "Tick Mark is populated upon clicking the subscribe button");
					test.log(LogStatus.PASS, "Subscribed button is populated fine upon refresing the page");
				}
				catch(TimeoutException el)
				{
					test.log(LogStatus.FAIL, "Tick Mark is not populated upon clicking subscribe button");
					test.log(LogStatus.FAIL, "Subscribed button is not populated fine upon refresing the page");
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "Subscribe button is not changed to 'Subscribed' upon clicking on the button");
			}
			}
			catch(TimeoutException e)
			{
				String Subscribed = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_after_Click"))).getText();
				System.out.println("Subscribed : "+Subscribed);
				
				if(Subscribed.equals("SUBSCRIBED"))
				{
					test.log(LogStatus.PASS, "Subscribe button is changed to 'Subscribed' upon clicking on the button");
					try
					{
						Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Tick")));
						test.log(LogStatus.PASS, "Tick Mark is populated upon clicking subscribe button");
					}
					catch(TimeoutException el)
					{
						test.log(LogStatus.FAIL, "Tick Mark is not populated upon clicking subscribe button");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Subscribe button is not changed to 'Subscribed' upon clicking on the button");
				}
				
			}
//			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Click subscribe button in the Article Page$")
	public void Click_Subscribe_Button_Article_Page() throws InterruptedException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Hover_Subscribe"))).click();
			Baseclass.explicitlyWait(5);
			String Title= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Popup_Title"))).getText();
			String Para= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Popup_Para"))).getText();
			System.out.println("Title :"+Title);
			if((Title.equals("Never miss an update on Cyber Security"))&&(Para.contains("subscribe to your favourite topics and to hear about our business events")))
			{
				test.log(LogStatus.PASS, "Title and Para in the popup are populating fine as expected");
			}
			else
			{
				test.log(LogStatus.FAIL, "Title and Para in the popup are not populating as expected");
			}
			System.out.println("Para :"+Para);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Linkden_Poup"))).click();
			Baseclass.explicitlyWait(3);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Poup"))).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Username"))).sendKeys(elementProperties.getProperty("Linkden_User_name"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Password"))).sendKeys(elementProperties.getProperty("Linkden_password"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Signup"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Baseclass.explicitlyWait(10);
			String Url = Baseclass.get_Url();
			System.out.println("Url  :"+Url);
			if(Url.contains(elementProperties.getProperty("Profile_Page")))
			{
				test.log(LogStatus.PASS, "Able to login to linkden from Article page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to login to linkden from Article page");
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^verify if other articles tagged to the same category are subscribed$")
	public void Verify_Subscribed() throws InterruptedException {
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance"))).click();
		Baseclass.explicitlyWait(4);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Cyber_Security_Bussiness"))).click();
		Baseclass.explicitlyWait(4);
		try {
			for(int j=Subscribe_article+1;j<=8;j++)
			{
				try
				{
					String Tag_Atricle = Baseclass.WaitElementVisible(driver, By.xpath("//*[@id=\"page-wrapper\"]/main/div[3]/div[1]/div[2]/div/div/div/div["+j+"]/article/a/div[2]/div[2]/div")).getText();
					System.out.println("Tag_Atricle_verify : "+Tag_Atricle);
					if(Tag_Atricle.equalsIgnoreCase("Cyber Security"))
					{
					Baseclass.WaitElementVisible(driver, By.xpath("//*[@id=\"page-wrapper\"]/main/div[3]/div[1]/div[2]/div/div/div/div["+j+"]/article/a")).click();
					break;
					}
					
				}
				catch(TimeoutException e)
				{
					System.out.println("j : "+j);
				}
			}
			try
			{
				String Subscribed = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_after_Click"))).getText();
				System.out.println("Subscribed : "+Subscribed);
				
				if(Subscribed.equals("SUBSCRIBED"))
				{
					test.log(LogStatus.PASS, "Subscribe button is changed to 'Subscribed' for remaining articles of same category");
					try
					{
						Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Tick")));
						test.log(LogStatus.PASS, "Tick Mark is populated for remaining articles of same category");
					}
					catch(TimeoutException el)
					{
						test.log(LogStatus.FAIL, "Tick Mark is not populated for remaining articles of same category");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Subscribe button is not changed to 'Subscribed' for remaining articles of same category");
				}
			}
			catch(TimeoutException e)
			{
				test.log(LogStatus.FAIL, "Subscribe button is not changed to 'Subscribed' for remaining articles of same category");
			}
			
		}
	catch (StaleElementReferenceException | ElementNotInteractableException e) {
		test.log(LogStatus.FAIL, "Unable to automate next button due to exception");
		e.printStackTrace();
	}
}
	@Then("^Check Preferences saved$")
	public void Check_Preferences_saved() throws InterruptedException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Login_Image_after_login"))).click();
			Baseclass.explicitlyWait(4);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Your_Intrests"))).click();
			Baseclass.explicitlyWait(4);
			Baseclass.scrollDown();
			String Preference = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preference"))).getAttribute("class");
			System.out.println("Preference : "+Preference);
			String[] Url = Preference.split("c");
			try
			{
				Split=Url[6];
				System.out.println("Split : "+Split);
				((JavascriptExecutor)driver).executeScript("scroll(0,200)");
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Email_Checkbox"))).click();
				System.out.println("Split2 : "+Split);
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preference_toggle"))).click();
				Baseclass.explicitlyWait(2);
				Baseclass.scrollDownFull();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preference_Button"))).click();
				test.log(LogStatus.PASS, "Preference is updated for testing");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				test.log(LogStatus.PASS, "Preference is already updated as expected");
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Check Preference due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Video option in the article$")
	public void Video_option_article() {
		try {
			article_count = Baseclass.get_Count(elementProperties.getProperty("All_Article_count"));
			for(int i=2;i<article_count;i++)
			{
				try {
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div[1]/div/div/div/div["+i+"]/article/a/div[1]/div/div[2]"));
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div[1]/div/div/div/div["+i+"]/article/a")).click();
					Baseclass.explicitlyWait(5);
					try
					{
						String youtube_Link=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Youtube_Video_Icon"))).getAttribute("style");
						System.out.println("youtube_Link : "+youtube_Link);
						test.log(LogStatus.PASS, "Video Icon is populating for video articles as expected");
						
					}
					catch(TimeoutException e)
					{
						try
						{
							String Article_Link=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Video_Article"))).getAttribute("poster");
							System.out.println("Article_Link : "+Article_Link);
							test.log(LogStatus.PASS, "Video Icon is populating for video articles as expected");
						}
						catch(TimeoutException e1)
						{
							try
							{
								String Article_Link_tag=Baseclass.WaitElementVisible(driver, By.tagName("video")).getAttribute("poster");
								System.out.println("Article_Link_tag : "+Article_Link_tag);
								test.log(LogStatus.PASS, "Video Icon is populating for video articles as expected");
							}
							catch(TimeoutException e2)
							{
								test.log(LogStatus.FAIL, "Video is not populating for video articles as expected");
							}
						}
					}
					break;
				}
				catch(NoSuchElementException e)
				{
					if(article_count-1==i-1)
					{
						Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Page_Nation_Last"))).click();
						Baseclass.explicitlyWait(5);
						int article_count2 = Baseclass.get_Count(elementProperties.getProperty("All_Article_count"));
						article_count = article_count+article_count2;
						i=i-39;
					}
					
				}
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Check Preference due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify individual article page$")
	public void Verify_Individual_Article_Page() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_Article"))).click();
			Baseclass.explicitlyWait(5);
			try {
				System.out.println("Try");
				Article_Title=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Title"))).getText();
				Last_Updated=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_date"))).getText();
				Share_field=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Share_field"))).getText();
				System.out.println("Last_Updated: "+Last_Updated);
			}
			catch (TimeoutException e) {
				System.out.println("Catch");
				Article_Title=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Title_Double"))).getText();
				Last_Updated=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_date_Double"))).getText();
				Share_field=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Share_field_Double"))).getText();
				System.out.println("Last_Updated: "+Last_Updated);
			}	
			int Title_size=0;
			Title_size=Article_Title.length();
			if(Title_size==0)
			{
				test.log(LogStatus.FAIL, "Title of the article is not populating fine");
			}
			else
			{
				test.log(LogStatus.PASS, "Title of the article is populating fine");
				if(Last_Updated.contains("Last updated:"))
				{
					test.log(LogStatus.PASS, "'Last updated:' field is populating fine");
					if(Last_Updated.length()>16)
					{
						test.log(LogStatus.PASS, "Date is populating as expected after 'Last updated:' field");
						if(Last_Updated.length()>30)
						{
							test.log(LogStatus.PASS, "Read Time is also populating in the page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Read Time is not populating in the page");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Date is not populating as expected after 'Last updated:' field");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "'Last updated:' field is not populating");
				}
				if(Share_field.length()>7)
				{
					test.log(LogStatus.PASS, "'Share This' field is populating fine");
				}
				else
				{
					test.log(LogStatus.FAIL, "'Share This' field is not populating fine");
				}
			}
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Check Preference due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify fields in the bottom of the page$")
	public void Verify_fields_bottom_page() {
		try {
			String More_Topics=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("More_Topics_Articles"))).getText();
			String Also_like=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("You_might_Also_Like"))).getText();
			if(More_Topics.equalsIgnoreCase(elementProperties.getProperty("More_Topics_Actual")))
			{
				test.log(LogStatus.PASS, "'More topics to interest you' field is populating fine in the bottom of article page");
				if(Also_like.equalsIgnoreCase(elementProperties.getProperty("Also_like_Actual")))
				{
					test.log(LogStatus.PASS, "'You might also like' field is populating fine in the bottom of article page");
				}
				else
				{
					test.log(LogStatus.FAIL, "'You might also like' field is not populating fine in the bottom of article page");
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "'More topics to interest you' field is not populating fine in the bottom of article page");
			}
			
			driver.navigate().back();
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Check Preference due to exception");
			e.printStackTrace();
		}
	}
	@Then("^Verify Events Article Page$")
	public static void Verify_Events_Article_Page() throws IOException {
		try {
			
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Events"))).click();
			Baseclass.explicitlyWait(5);
			try
			{
				HttpClient client = HttpClientBuilder.create().build();
				String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Events"))).getAttribute("src");
				System.out.println("Image "+Image);
				HttpGet request = new HttpGet(Image); 
				HttpResponse response = client.execute(request) ;
				System.out.println("Code : "+response.getCode());
				   if (response.getCode() == 200)
				   {
					   test.log(LogStatus.PASS, "Image is populating fine for no results"); 
				   }
				   else
				   {
					   test.log(LogStatus.FAIL, "Image is not populating fine for no results");
				   }
				   String Title_No_result=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Events_Text_Title"))).getText();
				   String Desc_No_result=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Events_Text_Desc"))).getText();
				   if((Title_No_result.equalsIgnoreCase("Sorry, there are no events on at the moment."))&&(Desc_No_result.equals("Check back again soon to see what's going on in your area.")))
					{
						test.log(LogStatus.PASS, "No results Title and Description in the Event article are populating fine if no results found");
					}
				   else
				   {
					   test.log(LogStatus.FAIL, "No results Title and Description in the Event article are not 	populating fine if no results found");
				   }
			}
			catch(NoSuchElementException | TimeoutException e)
			{
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_Event"))).click();
			Baseclass.explicitlyWait(5);
			String Title=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Event_Title"))).getText();
			if(Title.length()==0)
			{
				test.log(LogStatus.FAIL, "Title in the Event article is not populating fine for the Event : "+Title);
			}
			else
			{
				test.log(LogStatus.PASS, "Title in the Event article is populating fine for the Event : "+Title);
				String Subtitle=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Event_SubTitle"))).getText();
				try {
				if(Subtitle.length()==0)
				{
					test.log(LogStatus.FAIL, "Sub-Title in the Event article is not populating fine for the Event : "+Title);
				}
				else
				{
					test.log(LogStatus.PASS, "Sub-Title in the Event article is populating fine for the Event : "+Title);
					Baseclass.scrollDown();
					HttpClient client = HttpClientBuilder.create().build();
					String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Events_Image"))).getAttribute("src");
					System.out.println("Image "+Image);
					HttpGet request = new HttpGet(Image); 
					HttpResponse response = client.execute(request) ;
					System.out.println("Code : "+response.getCode());
					   if (response.getCode() == 200)
					   {
						   test.log(LogStatus.PASS, "Image is populating fine for the Event : "+Title); 
					   }
					   else
					   {
						   test.log(LogStatus.FAIL, "Image is not populating fine for the Event : "+Title);
					   }
				}
				}
				catch(TimeoutException e1)
				{
					test.log(LogStatus.FAIL, "Sub-Title/Image in the Event article is not populating fine for the Event : "+Title);
				}
				
			}
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Unable to automate Events article page due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Change a preference to subscribed$")
	public void Change_Preferences() throws InterruptedException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Login_Image_after_login"))).click();
			Baseclass.explicitlyWait(4);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Your_Intrests"))).click();
			Baseclass.explicitlyWait(4);
			Baseclass.scrollDown();
			String Preference = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Change_Preference"))).getAttribute("class");
			System.out.println("Preference : "+Preference);
			String[] Url = Preference.split("c");
			try
			{
				Split=Url[6];
				System.out.println("Split : "+Split);
				((JavascriptExecutor)driver).executeScript("scroll(0,200)");
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Email_Checkbox"))).click();
				System.out.println("Split2 : "+Split);
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Change_Preference_toggle"))).click();
				Baseclass.explicitlyWait(2);
				Baseclass.scrollDownFull();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preference_Button"))).click();
				Preference_article=1;
				test.log(LogStatus.PASS, "Preference is updated (Unsubscribed) for testing");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				((JavascriptExecutor)driver).executeScript("scroll(0,200)");
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Email_Checkbox"))).click();
				System.out.println("Split2 : "+Split);
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Change_Preference_toggle"))).click();
				Baseclass.explicitlyWait(2);
				Baseclass.scrollDownFull();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preference_Button"))).click();
				Preference_article=0;
				test.log(LogStatus.PASS, "Preference is updated (Subscribed) for testing");
			}
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to Save Preference due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify if the subscribed categorie is changed to subscribe$")
	public void Verify_Subscribed_Market_Trends() throws InterruptedException {
		try {
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("MarketTrends"))).click();
		Baseclass.explicitlyWait(4);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Market_Economics_Weekly"))).click();
		Baseclass.explicitlyWait(4);
		System.out.println("Preference_article"+Preference_article);
		if(Preference_article==0)
				{
				String Subscribed = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Preference"))).getText();
				if(Subscribed.equals("SUBSCRIBED"))
				{
					test.log(LogStatus.PASS, "Subscribe button is changed to 'Subscribed' for remaining articles of same category");
					try
					{
						Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Preference_Subscribe_Tick")));
						test.log(LogStatus.PASS, "Tick Mark is populated for the Subscribed category");
					}
					catch(TimeoutException el)
					{
						test.log(LogStatus.FAIL, "Tick Mark is not populated for the Subscribed category");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Subscribe button is not changed to 'Subscribed' for remaining articles of same category");
				}
				}
		else if(Preference_article==1)
				{
					String Subscribed = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_Preference_button"))).getText();
					if(Subscribed.equals("SUBSCRIBE"))
					{
						test.log(LogStatus.PASS, "Subscribed button is changed to 'Subscribe' if changed in the preference page");
					}
					else
					{
						test.log(LogStatus.FAIL, "Subscribed button is not changed to 'Subscribe' if changed in the preference page");
					}
				}
		}
	catch (StaleElementReferenceException | ElementNotInteractableException e) {
		test.log(LogStatus.FAIL, "Unable to check Subscribe due to exception");
		e.printStackTrace();
	}
}
	
	@Then("^Verify Header Title and Text$")
	public void Verify_Header_Title_Text() throws InterruptedException {
		try {
			String All_Article_Title = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Articles_Title"))).getText();
			if(All_Article_Title.equals(elementProperties.getProperty("Actual_All_Articles_Title")))
			{
				test.log(LogStatus.PASS, "All Article title is Populating fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "All Article title is not Populating fine");
			}
			String All_Article_Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Articles_Text"))).getText();
			if(All_Article_Text.length()==225)
			{
				test.log(LogStatus.PASS, "All Article Text is Populating fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "All Article Text is disturbed(Whole text is not populating)");
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to check Subscribe due to exception");
			e.printStackTrace();
		}
	}
	
	@Then("^Verify articles according to Pagenation$")
	public void Verify_articles_Pagenation() throws InterruptedException {
		try {
			String Last_Page_Number = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Articles_Pagenation"))).getText();
			int Last_Number = Integer.parseInt(Last_Page_Number);
			if(Last_Number>1)
			{
				int Card_Number=Baseclass.get_Count(elementProperties.getProperty("All_Articles_cards"));
				if(Card_Number==40)
				{
					test.log(LogStatus.PASS, "Pages number one is populating 40 cards if there is more than one page in the pagenation in All Article page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Pages number one is not populating 40 cards if there is more than one page in the pagenation in All Article page");
				}
				for(int i=1;i<=Card_Number;i++)
				{
					String Title = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div[1]/div/div/div/div["+i+"]/article/a/div[2]/div/p")).getText();
					if(Title.length()>1)
					{
						test.log(LogStatus.PASS, "Title of the card "+i+" is populated fine in the All Articles page");
					}
					else
					{
						test.log(LogStatus.FAIL, "Title of the card "+i+" is not populated fine in the All Articles page");
					}
				}
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("All_Articles_Pagenation"))).click();
				Baseclass.scrollDownFull();
				Baseclass.explicitlyWait(3);
				int Last_Page_Card_Number=Baseclass.get_Count(elementProperties.getProperty("All_Articles_cards"));
				if(Last_Page_Card_Number>1)
				{
					test.log(LogStatus.PASS, "Last Page is not populating empty in All Article page as expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Last Page is populating empty in All Article page");
				}	
				Baseclass.scrollDownFull();
				Baseclass.explicitlyWait(2);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Last_Full_Page"))).click();
				Baseclass.explicitlyWait(3);
				int Count_Card_Number=Baseclass.get_Count(elementProperties.getProperty("All_Articles_cards"));
				Baseclass.scrollDownFull();
				Baseclass.explicitlyWait(2);
				if(Count_Card_Number==40)
				{
					test.log(LogStatus.PASS, "Last but one page is populating 40 cards in All Article page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Last but one page is not populating 40 cards in All Article page");
				}
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Unable to check Subscribe due to exception");
			e.printStackTrace();
		}
	}
}
