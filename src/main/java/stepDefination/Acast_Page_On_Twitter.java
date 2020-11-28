package stepDefination;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

import cucumber.api.java.en.Then;

public class Acast_Page_On_Twitter extends Baseclass {
	 static String Article_Title;
	@Then("^Verify article share functionality on Twitter page$")
	public void verify_article_share_functionality_on_Twitter_page() throws Throwable {

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
				Acast_Page.search_for_the_acast_page_on_frontend_eg_technically_speaking();
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
	@Then("^Check the post on Twitter Page$")
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
	
	}


