package stepDefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.validator.Var;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NavigateToSite extends Baseclass {
	
	public static int i=0;
	String Title_Text;
	public static String Article_Title;
	static String Image;
	public static String Actual_Current_Url;
	static String Total_Number;
	static int Spotlight_Number;
	static int Toolkit_Number;
	static int Articles_Number;
	static int Events_Number;
	static int Sub_Tab;
	static int resultcount;
	static int Logo;
	static String Type;
	AppiumDriver d;
	
	
	@Given("^Open site in \"(.*?)\"$")
	public void Open_site_in_browser(String browserName) {
		try {
			Baseclass.openBrowser(browserName);
		} catch (Exception e) {

		}
	}

	@Then("^navigate to the site$")
	public void navigated_to_the_site() {
		try {
			Baseclass.windowmaximize();
			Baseclass.navigateUrl(elementProperties.getProperty("url"));
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@Then("^verify the home page title$")
	public void verify_the_home_page_title() throws AWTException {
		try {
			Baseclass.explicitlyWait(2);
			if(browser.equalsIgnoreCase("Mobile"))
			{
				NavigateToSite.Window_Popup_Mobile();
			}
			else {
			NavigateToSite.Window_Popup();
			}
			Baseclass.explicitlyWait(10);
			String pageTitle = Baseclass.getPageTitle();
			Assert.assertEquals(pageTitle, elementProperties.getProperty("homepagetitle"));
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	public static void Window_Popup_Mobile() throws AWTException {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_P);
			rb.keyPress(KeyEvent.VK_R);
			rb.keyPress(KeyEvent.VK_O);
			rb.keyPress(KeyEvent.VK_G);
			rb.keyPress(KeyEvent.VK_R);
			rb.keyPress(KeyEvent.VK_E);
			rb.keyPress(KeyEvent.VK_S);
			Baseclass.explicitlyWait(2);
			rb.keyPress(KeyEvent.VK_S);
			rb.keyPress(KeyEvent.VK_I);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_E);
			  rb.keyPress(KeyEvent.VK_TAB);
	            rb.keyRelease(KeyEvent.VK_TAB);
	            rb.keyPress(KeyEvent.VK_C);
	            rb.keyPress(KeyEvent.VK_O);
	            rb.keyPress(KeyEvent.VK_N);
	            rb.keyPress(KeyEvent.VK_T);
	            rb.keyPress(KeyEvent.VK_E);
	            rb.keyPress(KeyEvent.VK_N);
	            rb.keyPress(KeyEvent.VK_T);
	            
	            rb.keyPress(KeyEvent.VK_TAB);
	            rb.keyRelease(KeyEvent.VK_TAB);
	            
	            rb.keyPress(KeyEvent.VK_TAB);
	            rb.keyRelease(KeyEvent.VK_TAB);
				
	            //press enter
	            rb.keyPress(KeyEvent.VK_ENTER);
	            rb.keyRelease(KeyEvent.VK_ENTER);
				 
			}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}	 

	
	public static void Window_Popup() throws AWTException {
		try {
			 Robot rb = new Robot();

	            //Enter user name by ctrl-v
	            StringSelection username = new StringSelection("progressive");
	            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);            
	            rb.keyPress(KeyEvent.VK_CONTROL);
	            rb.keyPress(KeyEvent.VK_V);
	            rb.keyRelease(KeyEvent.VK_V);
	            rb.keyRelease(KeyEvent.VK_CONTROL);

	            //tab to password entry field
	            rb.keyPress(KeyEvent.VK_TAB);
	            rb.keyRelease(KeyEvent.VK_TAB);
	            Baseclass.explicitlyWait(3);

	            //Enter password by ctrl-v
	            StringSelection pwd = new StringSelection("content");
	            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
	            rb.keyPress(KeyEvent.VK_CONTROL);
	            rb.keyPress(KeyEvent.VK_V);
	            rb.keyRelease(KeyEvent.VK_V);
	            rb.keyRelease(KeyEvent.VK_CONTROL);

	            //press enter
	            rb.keyPress(KeyEvent.VK_ENTER);
	            rb.keyRelease(KeyEvent.VK_ENTER);
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@And("^Accept the cookies$")
	public void Accept_the_cookies(){
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("acceptcookies"))).click();
	}

	@And("^click view all article button$")
	public void click_view_all_article_button() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("viewallarticle"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Verify RBS Logo$")
	public void Verify_RBS_Logo() throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String Hearder_Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).getAttribute("src");
			Baseclass.scrollDownFull();
			String Footer_Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).getAttribute("src");
			
			for(int j=0;j<2;j++)
			{
				if(j==0)
				{
					Image = Hearder_Image;
					Type = "Header Logo";
				}
				else
				{
					Image = Footer_Image;
					Type = "Footer Logo";
				}
			HttpClient client = HttpClientBuilder.create().build(); 
			HttpGet request = new HttpGet(Image); 
			HttpResponse response = client.execute(request) ;
			System.out.println("Code : "+response.getCode());
			   if (response.getCode() == 200)
			   {
				test.log(LogStatus.PASS, Type+" Image is populating as expected"); 
			   }
			   else
			   {
				   test.log(LogStatus.FAIL, Type+" Image is not populating as expected");
			   }
			}
			if(browser.equalsIgnoreCase("Mobile"))
			{
				Mobile_Automation_Appium.Click_Mobile_Menu();
			}
			WebElement Click_Bussiness = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance")));
			Baseclass.JavaScriptExec_click(Click_Bussiness);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Header_Logo"))).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			Baseclass.navigateUrl(elementProperties.getProperty("url"));
			test.log(LogStatus.PASS, "Header and Footer logo is loading fine upon re-directing to other pages other than Home page");
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@Then("^Verify the Followon links - Linkedin, Twitter$")
	public void Verify_the_Followon_links_Linkedin_Twitter() {
		try {
			
			//clicks on the twitter footer link
			if(browser!=null)
			{
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.scrollDownFull();
				String Twitter = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footertwitter"))).getAttribute("href");
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.navigateUrl(Twitter);
				Baseclass.navigateBack();
				Baseclass.explicitlyWait(Baseclass.timeout);
				
				//clicks on the linkedIn footer link
				String Linkden = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footerlinkedin"))).getAttribute("href");
				Baseclass.navigateUrl(Linkden);
				Baseclass.navigateBack();
				Baseclass.explicitlyWait(Baseclass.timeout);
				
			}
			else {
			
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.scrollDownFull();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footertwitter"))).click();;
				Baseclass.switchToNewWindow();
				Baseclass.explicitlyWait(Baseclass.timeout);
				driver.close();
				Baseclass.switchToNewWindow();
			
				//clicks on the linkedIn footer link
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footerlinkedin"))).click();
				Baseclass.switchToNewWindow();
				Baseclass.explicitlyWait(Baseclass.timeout);
				driver.close();
				Baseclass.switchToNewWindow();
			}
			
						
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@And("^Verify the Footer links - Accessibility, Privacy, Terms and Conditions$")
	public void Verify_the_Footer_links_Accessibility_Privacy_Terms_and_Conditions(){
		try{
		Baseclass.scrollDownFull();
		WebElement accessibility = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("accessibility1")));
		Baseclass.JavaScriptExec_click(accessibility);
//		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("accessibility1"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String pageHeader= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("accessibilitypageheader"))).getText();
		Assert.assertEquals(pageHeader,elementProperties.getProperty("accessibilityTitle"));
		Baseclass.navigateBack();
		Baseclass.explicitlyWait(Baseclass.timeout);
		
		Baseclass.scrollDownFull();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement privacypageheader = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("privacy")));
		Baseclass.JavaScriptExec_click(privacypageheader);
//		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("privacy"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String privacy= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("privacypageheader"))).getText();
		Assert.assertEquals(privacy,elementProperties.getProperty("privacytitle"));
		Baseclass.navigateBack();
		Baseclass.explicitlyWait(Baseclass.timeout);
		
		Baseclass.scrollDownFull();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement terms_conditions = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("terms&conditions")));
		Baseclass.JavaScriptExec_click(terms_conditions);
//		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("terms&conditions"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String terms_condition= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("terms&conditiontitle"))).getText();
		Assert.assertEquals(terms_condition,elementProperties.getProperty("terms&conditionpageheader"));
		Baseclass.navigateBack();
		
		}catch(StaleElementReferenceException | ElementNotInteractableException e){
			e.printStackTrace();
		}
	}
	
	@Then("^Validate Menu Toolkits or Events Options \"(.*?)\"$")
	public void Validate_Toolkits_Options(String Menuname) throws IOException, AWTException {
		try {
			
			if(Menuname.equalsIgnoreCase("Toolkits"))
			{
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Tookits"))).click();
			Baseclass.explicitlyWait(10);
			String Toolkits= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkits_Text"))).getText();
			Actual_Current_Url = elementProperties.getProperty("Current_URL_toolkits");
			if((Baseclass.get_Url()).equalsIgnoreCase(Actual_Current_Url))
			{
				
				test.log(LogStatus.PASS, "Url is populating fine with the tag /"+(Baseclass.get_Url())+" for the page "+(elementProperties.getProperty("Actual_Tookits")));
				if(Toolkits.equals(elementProperties.getProperty("Actual_Tookits")))
				{
					test.log(LogStatus.PASS, "Tookits Title is populating fine");
				}
				else
				{
					test.log(LogStatus.FAIL, "Tookits Title is not populating fine");
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "Url is not populating with the tag /"+(Baseclass.get_Url())+" for the page "+(elementProperties.getProperty("Actual_Tookits")));
				
			}
			int forms = Baseclass.get_Count(elementProperties.getProperty("Toolkits_count"));
			for(i=1;i<=forms;i++)
			{
//				String business_guidance_loop= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance_text_loop"))).getText();
				if(browser.contentEquals("Mobile"))
				{
				if(i>2)
				{
					WebElement webElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+(i-1)+"]/article/a"));
					webElement.sendKeys(Keys.TAB);
				}
				}
				String business_guidance_loop = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+i+"]/article/a/div[2]/p[2]")).getText();
				if(business_guidance_loop.equals(elementProperties.getProperty("Actual_Tookits")))
				{
					test.log(LogStatus.PASS, "Tookits Card "+(i)+" is populating fine");
					//*[@id="page-wrapper"]/main/section/div/div/div/div[3]/div/div[1]/article/a/div[1]/div/div/div/img[2]
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					HttpClient client = HttpClientBuilder.create().build();
					Baseclass.explicitlyWait(2);
					if(i==5)
					{
						System.out.println("i="+i);
						Baseclass.scrollDown();
						Baseclass.explicitlyWait(2);
					}
					else if(i==14)
					{
						System.out.println("i="+i);
						WebElement scrolldown = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+(i+4)+"]/article/a/div[2]/p[2]"));
						Actions actions = new Actions(driver);
						actions.moveToElement(scrolldown).perform();
						Baseclass.explicitlyWait(2);
					}
					else if(i==22)
					{
						System.out.println("i="+i);
//						Baseclass.scrollDown();
						WebElement scrolldown = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+(i+4)+"]/article/a/div[2]/p[2]"));
						Actions actions = new Actions(driver);
						actions.moveToElement(scrolldown).perform();
						Baseclass.explicitlyWait(2);
					}
					else if(i==30)
					{
						System.out.println("i="+i);
//						Baseclass.scrollDown();
						WebElement scrolldown = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+(i+1)+"]/article/a/div[2]/p[2]"));
						Actions actions = new Actions(driver);
						actions.moveToElement(scrolldown).perform();
						Baseclass.explicitlyWait(2);
					}
					String Image = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/section/div/div/div/div[3]/div/div["+i+"]/article/a/div[1]/div/div/div/img[2]")).getAttribute("src");
					HttpGet request = new HttpGet(Image); 
					HttpResponse response = client.execute(request) ;
					System.out.println("Code : "+response.getCode());
					   if (response.getCode() == 200)
					   {
						   test.log(LogStatus.PASS, "Image is populating fine in the card : "+(i)); 
					   }
					   else
					   {
						   test.log(LogStatus.FAIL, "Image is not populating fine in the card : "+(i-1));
					   }
				}
				else
				{
					test.log(LogStatus.FAIL, "Tookits Card "+(i)+" is not populating fine");
				}
			}
			Baseclass.navigateBack();
			}
			else if(Menuname.equalsIgnoreCase("Events"))
			{
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Events"))).click();
				Baseclass.explicitlyWait(10);
				Title_Text = elementProperties.getProperty("Actual_Events");
				String business_guidance= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Events_Text"))).getText();
				Actual_Current_Url = elementProperties.getProperty("Current_URL_events");
				if((Baseclass.get_Url()).equalsIgnoreCase(Actual_Current_Url))
				{
					test.log(LogStatus.PASS, "Url is populating fine with the tag /"+(Baseclass.get_Url())+" for the page "+(elementProperties.getProperty("Actual_Tookits")));
					
					if(business_guidance.equals(Title_Text))
					{
						test.log(LogStatus.PASS, "Events Title is populating fine");
					}
					else
					{
						test.log(LogStatus.FAIL, "Events Title is not populating fine");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Url is not populating with the tag /"+(Baseclass.get_Url())+" for the page "+(elementProperties.getProperty("Actual_Tookits")));
					
				}
				Baseclass.navigateBack();
				
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Validate Menu Options \"(.*?)\"$")
	public void Validate_Menu_Options(String MenuType) throws IOException, AWTException {
		try {
			switch (MenuType) {
			case "Business Guidence":
				System.out.println("Bussiness");
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance"))).click();
				System.out.println("Bussiness");
				Title_Text = elementProperties.getProperty("Actual_business_guidance");
				Baseclass.explicitlyWait(10);
				Actual_Current_Url = elementProperties.getProperty("Current_URL_Bussiness");
				break;

			case "Market Trends":
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("MarketTrends"))).click();
				Title_Text = elementProperties.getProperty("Actual_Market_Trend");
				Actual_Current_Url = elementProperties.getProperty("Current_URL_Market");
				Baseclass.explicitlyWait(10);
				break;
				
			case "Sectors":
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Sectors"))).click();
				Title_Text = elementProperties.getProperty("Actual_Sectors");
				Actual_Current_Url = elementProperties.getProperty("Current_URL_Sectors");
				Baseclass.explicitlyWait(10);
				break;
			}
			String business_guidance= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("business_guidance_text"))).getText();
			
			if((Baseclass.get_Url()).equalsIgnoreCase(Actual_Current_Url))
			{
				test.log(LogStatus.PASS, "Url is populating fine with the tag /"+(Baseclass.get_Url())+" for the page "+Title_Text);
				if(business_guidance.equals(Title_Text))
				{
					test.log(LogStatus.PASS, Title_Text+" Title is populating fine");
				}
				else
				{
					test.log(LogStatus.FAIL, Title_Text+" Title is not populating fine");
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "Url is not populating fine with the tag /"+(Baseclass.get_Url())+" for the page "+Title_Text);
			}
			int forms = Baseclass.get_Count(elementProperties.getProperty("Cards_count"));
			for(i=2;i<=forms;i++)
			{
				if(browser.contentEquals("Mobile"))
				{
					if(i>9)
					{
						WebElement webElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div/div/div/div["+(i-1)+"]/article/a"));
						webElement.sendKeys(Keys.TAB);
					}
				}
				String business_guidance_loop = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div/div/div/div["+i+"]/article/a/div[2]/p[2]")).getText();
				if(business_guidance_loop.equals(Title_Text))
				{
					test.log(LogStatus.PASS, Title_Text+" Card "+(i-1)+" is populating fine");
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					HttpClient client = HttpClientBuilder.create().build();
					Baseclass.explicitlyWait(2);
					System.out.println("i= "+i);
					if(i==6)
					{
						((JavascriptExecutor)driver).executeScript("scroll(0,1100)");
					}
					String Image = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/main/div/div/div/div/div["+i+"]/article/a/div[1]/div/div/div/img[2]")).getAttribute("src");
					HttpGet request = new HttpGet(Image); 
					HttpResponse response = client.execute(request) ;
					System.out.println("Code : "+response.getCode());
					   if (response.getCode() == 200)
					   {
						   test.log(LogStatus.PASS, "Image is populating fine in the card : "+(i-1)); 
					   }
					   else
					   {
						   test.log(LogStatus.FAIL, "Image is not populating fine in the card : "+(i-1));
					   }
				}
				else
				{
					test.log(LogStatus.FAIL, Title_Text+" Card "+(i-1)+" is not populating fine");
				}
				
			}
			Baseclass.navigateBack();
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Navigate to first article$")
	public static void Navigate_Article() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Defaultarticle"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Article_Title = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Article_Text"))).getText();
			System.out.println("Defaultarticle "+Article_Title);
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Verify article share functionality on Facebook$")
	public void Verify_Facebook_Share() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Share"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_user"))).sendKeys(elementProperties.getProperty("Facebook_Username"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Pass"))).sendKeys(elementProperties.getProperty("Facebook_Password"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Login"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			try 
			{
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_login_error"))).isDisplayed();
				test.log(LogStatus.FAIL, "Facebook Login credentials are wrong");
			}
			catch (TimeoutException e) {
				String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
				Article_Title = Article_Title+dateFormat;
				System.out.println("Actual: "+Article_Title);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_pop_Text"))).sendKeys(Article_Title);
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Pop_share"))).click();
				
				test.log(LogStatus.PASS, "Post is shared on the facebook wall");
			}
			Baseclass.switchToNewWindow();
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Check the post on Facebook$")
	public void Check_post_Facebook() {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
			Baseclass.navigateUrl(elementProperties.getProperty("Facebook"));
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(browser.contentEquals("Mobile"))
			{
				Actions builder = new Actions(driver);
				builder.sendKeys(Keys.ENTER).build().perform();
			}
			Baseclass.Handle_Alerts();
			
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Check_Home"))).click();
			String Text = null;
				Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Check"))).getText();
				System.out.println("Text "+Text);
				if(Text.equalsIgnoreCase(Article_Title))
				{
					test.log(LogStatus.PASS, "Logged into Facebook and checked the Post is shared on the facebook wall");
				}
				else
				{
					Baseclass.scrollDown();
					String SecondPost = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_second_Post"))).getText();
					System.out.println("SecondPost "+SecondPost);
					if(SecondPost.equalsIgnoreCase(Article_Title))
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
	
	@Then("^Verify article share functionality on Twitter$")
	public void Verify_Twitter_Share() {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.navigateUrl(elementProperties.getProperty("Twitter_URL"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_user"))).sendKeys(elementProperties.getProperty("Twitter_Username"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Pass"))).sendKeys(elementProperties.getProperty("Twitter_Password"));
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Login_Main"))).click();
			try 
			{
				String Error = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_login_error"))).getText();
				test.log(LogStatus.FAIL, "Twitter Page is throwing error as : "+Error);
			}
			catch (TimeoutException e) {
				Baseclass.navigateUrl(elementProperties.getProperty("url"));
				Baseclass.explicitlyWait(Baseclass.timeout);
				NavigateToSite.Navigate_Article();
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Share"))).click();
				Baseclass.switchToNewWindow();
				String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
				Article_Title = (Article_Title+dateFormat).trim();
				System.out.println("Twitter: "+Article_Title);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Text"))).sendKeys(Article_Title);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Pop_share"))).click();
				test.log(LogStatus.PASS, "Post is shared on the Twitter wall");
			}		
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Check the post on Twitter$")
	public void Check_post_Twitter() {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.windowmaximize();
			String Text = null;
			Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_Shared_Post"))).getText().trim();
			System.out.println("Text "+Text);
			if(Text.equalsIgnoreCase(Article_Title))
			{
				test.log(LogStatus.PASS, "Logged into Twitter and checked the Post is shared on the Twitter wall");
			}
			else
			{
				String SecondPost = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Twitter_second_Post"))).getText();
				System.out.println("SecondPost "+SecondPost);
				if(SecondPost.equalsIgnoreCase(Article_Title))
				{
					test.log(LogStatus.PASS, "Logged into Twitter and checked the Post is shared on the Twitter wall");
				}
				else
				{
					test.log(LogStatus.FAIL, "Checked latest posts and unable to find the shared Post in Twitter");
				}
			}
			Baseclass.navigateUrl(elementProperties.getProperty("url"));
	} catch (StaleElementReferenceException | ElementNotInteractableException e) {
		e.printStackTrace();
		}
	}
	
	@Then("^Verify article share functionality on Linkden$")
	public void Verify_Linkden_Share() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Article_Share"))).click();
			Baseclass.switchToNewWindow();
			Baseclass.explicitlyWait(Baseclass.timeout);
			System.out.println("Post :");
			
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Share_Post"))).click();
			System.out.println("Post2 :");
			String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
			Article_Title = (Article_Title+dateFormat).trim();
			System.out.println("Article_Title :"+Article_Title);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Post_Text"))).sendKeys(Article_Title);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Baseclass.scrollDownFull();
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_post_share"))).click();
//			Baseclass.getParentWindow();
			test.log(LogStatus.PASS, "Logged into Linkden Posted the article");
		}catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Linkden article share failed");
			e.printStackTrace();
			}
	}
	
	@Then("^Check the post on Linkden$")
	public static void Check_Linkden_post() throws AWTException {
		try {
			Robot rb = new Robot();
			Baseclass.explicitlyWait(5);
			//tab to password entry field
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Baseclass.explicitlyWait(3);
            System.out.println("ROBOT ");
            Baseclass.switchToNewWindow();
            Baseclass.explicitlyWait(Baseclass.timeout);
            
            System.out.println("Verify_Button_else");
			String Now = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_view_share"))).getText();
			System.out.println("Now: "+Now);
			if(Now.contains("now •"))
			{
				Baseclass.explicitlyWait(Baseclass.timeout);
				String Verify_Linkden = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Verify_linkden"))).getText();
				System.out.println("Verify_Linkden : "+Verify_Linkden);
				if(Verify_Linkden.equalsIgnoreCase("RBS | "+Article_Title))
				{
					test.log(LogStatus.PASS, "Logged into Linkden and checked the Post is shared on the Linkden wall");
				}
				else
				{
					test.log(LogStatus.FAIL, "Checked latest posts and unable to find the shared Post in Linkden wall");
				}
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Linkden article share failed");
			e.printStackTrace();
			}
	}
	
	@Then("^Validate Search Icon for non loggedin user$")
	public static void Validate_Search_Icon() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
		 	Object obj = jse.executeScript("return document.getElementsByTagName('form')[0].getAttribute('class')");
		 	String Search_icon = (String) obj;
			if(Search_icon.startsWith("j"))
			{
				test.log(LogStatus.PASS, "Search icon is getting displayed without any search bar");
			}
			else
			{
				test.log(LogStatus.FAIL, "Search icon is getting displayed with search bar");
			}
			Actions builder = new Actions(driver);
		    builder.click(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Search_icon")))).perform();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Object obj_After_Click = jse.executeScript("return document.getElementsByTagName('form')[0].getAttribute('class')");
		 	String Search_icon_After_Click = (String) obj_After_Click;
			if(Search_icon_After_Click.startsWith("j"))
			{
				test.log(LogStatus.FAIL, "Search icon is getting displayed without any search bar after clicked on search icon");
			}
			else
			{
				test.log(LogStatus.PASS, "Search icon is getting displayed with search bar after clicked on search icon");
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^search any text$")
	public static void search_any_text() {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(elementProperties.getProperty("Search_text")).perform();
			Baseclass.explicitlyWait(Baseclass.timeout);
			action.sendKeys(Keys.RETURN).perform();
			Baseclass.explicitlyWait(Baseclass.timeout);
			String Search_Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Search_Field"))).getAttribute("value");
			if(elementProperties.getProperty("Search_text").equals(Search_Text))
			{
				test.log(LogStatus.PASS, "Searched with the text '"+Search_Text);
				test.log(LogStatus.PASS, "Text searched as '"+Search_Text+"', is populating fine in the search box in search page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Text searched as '"+Search_Text+"', is populating wrong in the search box in search page");
			}
			String Result_Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Result_Text"))).getText();
			System.out.println("Search_Text "+Result_Text);
			if(Result_Text.contains(elementProperties.getProperty("Result_text")))
			{
				test.log(LogStatus.PASS, "Results text is popualting fine. Number of results populated are "+Result_Text);
			}
			else
			{
				test.log(LogStatus.FAIL, "Results text is not popualting.");
			}
			String[] Total_results = Result_Text.split(" ");
			Total_Number= Total_results[0];
			String Articles_highlight = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Articles_Number"))).getAttribute("aria-selected");			
			if(Articles_highlight.equalsIgnoreCase("true"))
			{
				test.log(LogStatus.PASS, "Article field selected and is highlighted as expected ");
			}
			else
			{
				test.log(LogStatus.FAIL, "Article field selected and is highlighted as expected ");
			}
			
		}catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
}
	@Then("^Validate the Results with Search results tabs results$")
	public static void Validate_Results() {
		try {
			
			if(Baseclass.browser!=null)
			{
				System.out.println("Articles_Field safari:");
				
				String Articles_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Articles_Number"))).getText().trim();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Articles_Field = Articles_Field.replace("Articles (", "");
				Articles_Field = Articles_Field.replace("ARTICLES (", "");
				System.out.println("Articles_Field :"+Articles_Field);
				Articles_Field = Articles_Field.replace(")", "");
				Articles_Number = Integer.parseInt(Articles_Field);
				
				String Spotlight_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Spotlight_Number"))).getText().trim();
				Spotlight_Field = Spotlight_Field.replace("Spotlight (", "").replace(")", "");
				Spotlight_Field = Spotlight_Field.replace("SPOTLIGHT (", "");
				Spotlight_Number = Integer.parseInt(Spotlight_Field);
				
				String Toolkit_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkit_Number"))).getText().trim();
				Toolkit_Field = Toolkit_Field.replace("Toolkits (", "").replace(")", "");
				Toolkit_Field = Toolkit_Field.replace("TOOLKITS (", "");
				Toolkit_Number = Integer.parseInt(Toolkit_Field);
				
				
				String Events_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Event_Number"))).getText().trim();
				Events_Field = Events_Field.replace("Events (", "").replace(")", "");
				Events_Field = Events_Field.replace("EVENTS (", "");
				Events_Number = Integer.parseInt(Events_Field);
				
				int Total = Integer.parseInt(Total_Number);
							
				if((Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number)==Total)
				{
					test.log(LogStatus.PASS, "Total Results is getting matched with Sum of all Search results tabs results. Total = "+Total+" where Sum = "+(Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number));
				}
				else
				{
					test.log(LogStatus.FAIL, "Total Results is not getting matched with Sum of all Search results tabs results. Total = "+Total+" where Sum = "+(Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number));
				}
				
			}
			else
			{
			
			String Articles_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Articles_Number"))).getText().trim();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Articles_Field = Articles_Field.replace("ARTICLES (", "");
			System.out.println("Articles_Field :"+Articles_Field);
			Articles_Field = Articles_Field.replace(")", "");
			Articles_Number = Integer.parseInt(Articles_Field);
			
			String Spotlight_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Spotlight_Number"))).getText().trim();
			Spotlight_Field = Spotlight_Field.replace("SPOTLIGHT (", "").replace(")", "");
			Spotlight_Number = Integer.parseInt(Spotlight_Field);
			
			String Toolkit_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkit_Number"))).getText().trim();
			Toolkit_Field = Toolkit_Field.replace("TOOLKITS (", "").replace(")", "");
			Toolkit_Number = Integer.parseInt(Toolkit_Field);
			
			
			String Events_Field = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Event_Number"))).getText().trim();
			Events_Field = Events_Field.replace("EVENTS (", "").replace(")", "");
			Events_Number = Integer.parseInt(Events_Field);
			
			int Total = Integer.parseInt(Total_Number);
						
			if((Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number)==Total)
			{
				test.log(LogStatus.PASS, "Total Results is getting matched with Sum of all Search results tabs results. Total = "+Total+" where Sum = "+(Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number));
			}
			else
			{
				test.log(LogStatus.FAIL, "Total Results is not getting matched with Sum of all Search results tabs results. Total = "+Total+" where Sum = "+(Articles_Number+Spotlight_Number+Toolkit_Number+Events_Number));
			}
			}
			
		}catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
}
	
	public static int Very_Count_Sub_Tasks(String Search_Result_count,String Search_Page_Last) {
		try {
			try
			{
			String Search_Page_Last_Number="//*[@id=\"results-tabpanel-"+Sub_Tab+"\"]/div/div/div[2]/div/div/button";
			int get_Last_page_Number = Baseclass.get_Count(Search_Page_Last_Number);
			String Search_Page_get_count="//*[@id=\"results-tabpanel-"+Sub_Tab+"\"]/div/div/div[1]/div";
			int get_count = Baseclass.get_Count(Search_Page_get_count);
			String PageNation = driver.findElement(By.xpath("//*[@id=\"results-tabpanel-"+Sub_Tab+"\"]/div/div/div[2]/div/div/button["+(get_Last_page_Number-1)+"]")).getText().trim();
			int Page_count = Integer.parseInt(PageNation);
			Page_count=Page_count-1;
			Page_count=Page_count*get_count;
			driver.findElement(By.xpath("//*[@id=\"results-tabpanel-"+Sub_Tab+"\"]/div/div/div[2]/div/div/button["+(get_Last_page_Number-1)+"]")).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			int get_count_Last = Baseclass.get_Count(Search_Page_get_count);
			Page_count=get_count_Last+Page_count;
			resultcount = 0;
			resultcount = Page_count;
			}
			catch (TimeoutException | NoSuchElementException e) {
				String Search_Page_get_count="//*[@id=\"results-tabpanel-"+Sub_Tab+"\"]/div/div/div[1]/div";
				int get_count2 = Baseclass.get_Count(Search_Page_get_count);
				resultcount = 0;
				resultcount = get_count2;
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
		return resultcount;
	}
	
	
	public static void Verify_Zero_Results(String Image,String Text) throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			HttpClient client = HttpClientBuilder.create().build(); 
			HttpGet request = new HttpGet(Image); 
			HttpResponse response = client.execute(request) ;
			System.out.println("Code : "+response.getCode());
			   if (response.getCode() == 200)
			   {
				   test.log(LogStatus.PASS, "No results image is populating fine in the Articles Tab for the searched text : "+(elementProperties.getProperty("Search_text"))); 
			   }
			   else
			   {
				   test.log(LogStatus.FAIL, "No results image is not populating fine in the Articles Tab for the searched text : "+(elementProperties.getProperty("Search_text")));
			   }
			   
			   if(Text.contains(elementProperties.getProperty("Actual_Text_No_Results"))) 
			   {
				   test.log(LogStatus.PASS, "Text is populating fine if no search results are found "); 
			   }
			   else
			   {
				   test.log(LogStatus.FAIL, "Text is not populating fine if no search results are found "); 
			   }
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Click Article sub field in search results Page and Validate Results \"(.*?)\" and \"(.*?)\"$")
	public static void Click_Article_and_Validate(String Search_Result_count,String Search_Page_Last) throws IOException {
		try {
			
			Sub_Tab =0;
			if(Articles_Number!=0)
			{
			int Sub_Count_Article=NavigateToSite.Very_Count_Sub_Tasks(Search_Result_count, Search_Page_Last);
			if(Articles_Number==Sub_Count_Article)
			{
				test.log(LogStatus.PASS, "Count coming in the Article Field is getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Count coming in the Article Field is not getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
		}
			else if(Articles_Number==0)
			{
				test.log(LogStatus.PASS, "Article Count is populating '0' for the searched text :"+(elementProperties.getProperty("Search_text")));
				String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Image_Article"))).getAttribute("src");
				String Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Text_Article"))).getText();
				System.out.println("Text : "+Text);
				NavigateToSite.Verify_Zero_Results(Image,Text);
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Click SpotLight sub field in search results Page and Validate Results \"(.*?)\" and \"(.*?)\"$")
	public static void Click_SpotLight_and_Validate(String Search_Result_count,String Search_Page_Last) throws IOException {
		try {
			Sub_Tab =1;
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Spotlight_Number"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(Spotlight_Number!=0)
			{
			int Sub_Count=NavigateToSite.Very_Count_Sub_Tasks(Search_Result_count, Search_Page_Last);
			if(Spotlight_Number==Sub_Count)
			{
				test.log(LogStatus.PASS, "Count coming in the SpotLight Field is getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Count coming in the SpotLight Field is not getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
		}
			else if(Spotlight_Number==0)
			{
				test.log(LogStatus.PASS, "SpotLight Count is populating '0' for the searched text :"+(elementProperties.getProperty("Search_text")));
				String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Image_Spotlight"))).getAttribute("src");
				String Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Text_Spotlight"))).getText();
				NavigateToSite.Verify_Zero_Results(Image,Text);
			}
		
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Click Toolkits sub field in search results Page and Validate Results \"(.*?)\" and \"(.*?)\"$")
	public static void Click_Toolkits_and_Validate(String Search_Result_count,String Search_Page_Last) throws IOException {
		try {
			Sub_Tab =2;
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Toolkit_Number"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(Toolkit_Number!=0)
			{
			int Sub_Count=NavigateToSite.Very_Count_Sub_Tasks(Search_Result_count, Search_Page_Last);
			if(Toolkit_Number==Sub_Count)
			{
				test.log(LogStatus.PASS, "Count coming in the Toolkits Field is getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Count coming in the Toolkits Field not is getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
		}
			else if(Toolkit_Number==0)
			{
				test.log(LogStatus.PASS, "Toolkits Count is populating '0' for the searched text :"+(elementProperties.getProperty("Search_text")));
				String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Image_Toolkits"))).getAttribute("src");
				String Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Text_Toolkits"))).getText();
				NavigateToSite.Verify_Zero_Results(Image,Text);
			}
		
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Click Events sub field in search results Page and Validate Results \"(.*?)\" and \"(.*?)\"$")
	public static void Click_Events_and_Validate(String Search_Result_count,String Search_Page_Last) throws IOException {
		try {
			Sub_Tab =3;
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Event_Number"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(Events_Number!=0)
			{
			int Sub_Count=NavigateToSite.Very_Count_Sub_Tasks(Search_Result_count, Search_Page_Last);
			if(Events_Number==Sub_Count)
			{
				test.log(LogStatus.PASS, "Count coming in the Events Field is getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Count coming in the Events Field is not getting matched with the results populating for the searched text :"+(elementProperties.getProperty("Search_text")));
			}
		}
			else if(Events_Number==0)
			{
				test.log(LogStatus.PASS, "Events Count is populating '0' for the searched text :"+(elementProperties.getProperty("Search_text")));
				String Image = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Image_Events"))).getAttribute("src");
				String Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("No_Results_Text_Events"))).getText();
				NavigateToSite.Verify_Zero_Results(Image,Text);
			}
			
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	@Then("^Validate Fields title in the home page \"(.*?)\" and \"(.*?)\"$")
	public static void Validate_Latest_Articles_title_home_page(String Field_Title, String Actual_Field_Title ) {
		try {
			String Latest_Title = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty(Field_Title))).getText().trim();
			if(Latest_Title.equals(elementProperties.getProperty(Actual_Field_Title)))
			{
				test.log(LogStatus.PASS, Latest_Title+" Title is populating fine in the Home page");
			}
			else
			{
				test.log(LogStatus.FAIL, Latest_Title+" Title is not populating fine in the Home page");
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Validate view all button in the Latest Articles field$")
	public static void Latest_Articles_View_all() {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Latest_View_All"))).isDisplayed())
			{
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Latest_View_All"))).click();
				Baseclass.explicitlyWait(Baseclass.timeout);
				if((Baseclass.get_Url()).equals(elementProperties.getProperty("Current_URL_articles")))
				{
					test.log(LogStatus.PASS, "Upon clicking 'View all' button page is redirected to "+(Baseclass.get_Url())+" Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Upon clicking 'View all' button page is getting redirected to "+(Baseclass.get_Url())+" Page");
				}
				Baseclass.navigateBack();
			}
			else
			{
				test.log(LogStatus.FAIL, "'View All' button is not getting populated for ");
			}
			
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Validate Page nation in Home page \"(.*?)\" and \"(.*?)\"$")
	public static void Validate_Page_nation_in_Home_page(String Article_Webelement, String PageNation_Webelement) {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			int count_articles = Baseclass.get_Count(elementProperties.getProperty(Article_Webelement));
			int count_PageNation = Baseclass.get_Count(elementProperties.getProperty(PageNation_Webelement));
			
			System.out.println("count_PageNation "+count_PageNation+" "+count_articles);
			
			if((count_articles%4)==0)
			{
				count_articles= count_articles/4;
				if(count_articles==count_PageNation)
				{
					test.log(LogStatus.PASS, "Number of articles in the home page are "+(count_articles*4)+" and Pagenations populated are "+count_PageNation);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of articles in the home page are "+(count_articles*4)+" and but the Pagenations populated are "+count_PageNation);
				}
			}
			else
			{
				int Card_articles= count_articles/4;
				if((Card_articles+1)==count_PageNation)
				{
					test.log(LogStatus.PASS, "Number of articles in the home page are "+count_articles+" and Pagenations populated are "+count_PageNation);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of articles in the home page are "+count_articles+" and but the Pagenations populated are "+count_PageNation);
				}
			}
				
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^Login from footer section$")
	public static void Login_footer_section() {
		try {
			Baseclass.scrollDownFull();
			Baseclass.explicitlyWait(4);
//			String Linkden = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footerlinkedin"))).getAttribute("href");
//			Baseclass.navigateUrl(Linkden);
//			Baseclass.explicitlyWait(Baseclass.timeout);
	String link = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footerlinkedin"))).getAttribute("href");
	System.out.println("link "+link);
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("footerlinkedin"))).click();
	Baseclass.explicitlyWait(2);
	Baseclass.switchToNewWindow();
	Baseclass.explicitlyWait(Baseclass.timeout);
	
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Footer_Follow"))).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Username"))).sendKeys(elementProperties.getProperty("Linkden_User_name"));
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Password"))).sendKeys(elementProperties.getProperty("Linkden_password"));
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Signup"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Baseclass.explicitlyWait(5);
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkden_Visit_Site"))).click();
	Baseclass.explicitlyWait(5);
	test.log(LogStatus.PASS, "Follow button is clicked and page is re-directed to login page as expected");
	test.log(LogStatus.PASS, "Upon logging in page is re-directed to official page as expected");
	
	driver.close();
	Baseclass.switchToNewWindow();
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Follow button functionality is not working properly");
			
			e.printStackTrace();
		}
	}
		
	@Then("^go to Events Page and verify Cards$")
	public void Events_Page_cards() throws IOException {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Events"))).click();
			Baseclass.explicitlyWait(3);
			try
			{
				int Card_Count=Baseclass.get_Count(elementProperties.getProperty("Events_Cards"));
				for(i=1;i<=Card_Count;i++)
				{
					String Card_Title = driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/p[1]")).getCssValue("font-family");
					String Card_Title_colour=driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/p[1]")).getCssValue("color");
					String Card_Sub_Title = driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/span")).getCssValue("font-family");
					String Card_Sub_Title_colour=driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/span")).getCssValue("color");
					String Card_Time = driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/p[2]")).getCssValue("font-family");
					String Card_Time_Color=driver.findElement(By.xpath("//*[@id=\"item-list\"]/div/div/div/div["+i+"]/article/div/div[2]/a/p[2]")).getCssValue("color");
					
					System.out.println("Card_Title :"+Card_Title+" Card_Title :"+Card_Title_colour+" Card_Sub_Title :"+Card_Sub_Title+" Card_Sub_Title_colour :"+Card_Sub_Title_colour+" Card_Time :"+Card_Time+" Card_Time_Color :"+Card_Time_Color);
					
					if((Card_Title.equalsIgnoreCase(elementProperties.getProperty("Card_Title_Font"))&&(Card_Title_colour.equalsIgnoreCase("rgba(68, 68, 68, 1)"))))
					{
						test.log(LogStatus.PASS, "Font and Color of main title in Events Card "+i+" is populating fine");
					}
					else
					{
						test.log(LogStatus.FAIL, "Font and Color of main title in Events Card "+i+" is not populating fine");
					}
					
					if((Card_Sub_Title.equalsIgnoreCase(elementProperties.getProperty("Card_Sub_Title_Font"))&&(Card_Title_colour.equalsIgnoreCase("rgba(68, 68, 68, 1)"))))
					{
						test.log(LogStatus.PASS, "Font and Color of Sub title in Events Card "+i+" is populating fine");
					}
					else
					{
						test.log(LogStatus.FAIL, "Font and Color of Sub title in Events Card "+i+" is not populating fine");
					}
					
					if((Card_Time.equalsIgnoreCase(elementProperties.getProperty("Card_Title_Font"))&&(Card_Time_Color.equalsIgnoreCase("rgba(117, 117, 117, 1)"))))
					{
						test.log(LogStatus.PASS, "Font and Color of Time Text in Events Card "+i+" is populating fine");
					}
					else
					{
						test.log(LogStatus.FAIL, "Font and Color of Time Text in Events Card "+i+" is not populating fine");
					}
				}			
			}
			catch (TimeoutException | NoSuchElementException e) {
				Article_Page_Validations.Verify_Events_Article_Page();
			}
		}
		catch (StaleElementReferenceException | ElementNotInteractableException e) {
			test.log(LogStatus.FAIL, "Events cards functionality is failed due to Exception");
			e.printStackTrace();
		}
	}
		
			
	
	
}
