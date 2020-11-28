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

public class Acast_Page_Face_Book extends Baseclass {
	static String Article_Title;

	@Then("^Verify article share functionality on Facebook Page$")
	public void verify_article_share_functionality_on_Facebook_Page() throws Throwable {

		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Share"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_user"))).sendKeys(elementProperties.getProperty("Facebook_Username"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Pass"))).sendKeys(elementProperties.getProperty("Facebook_Password"));
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Login"))).click();
			Baseclass.explicitlyWait(Baseclass.timeout);
			try {
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_login_error")))
						.isDisplayed();
				test.log(LogStatus.FAIL, "Facebook Login credentials are wrong");
			} catch (TimeoutException e) {
				String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
				Article_Title =dateFormat;
				System.out.println("Actual: " + Article_Title);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_pop_Text")))
						.sendKeys(Article_Title);
				Baseclass.explicitlyWait(Baseclass.timeout);
				Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Pop_share")))
						.click();
				test.log(LogStatus.PASS, "Acast Post is shared on the facebook wall");
			}
			Baseclass.switchToNewWindow();

		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}

	}

	@Then("^Check the post on Facebook Page$")
	public void check_the_post_on_Facebook_Page() throws Throwable {
		try {
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.switchToNewWindow();
			Baseclass.navigateUrl(elementProperties.getProperty("Facebook"));
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.Handle_Alerts();
			Baseclass.explicitlyWait(Baseclass.timeout);
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Check_Home")))
					.click();
			String Text = null;
			Text = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_Check")))
					.getText();
			System.out.println("Text " + Text);
			 if(Text.equalsIgnoreCase(Article_Title))
			{
				test.log(LogStatus.PASS, "Logged into Facebook and checked the Acast Post is shared on the facebook wall");
			}
			 else
			{
				Baseclass.scrollDown();
				String SecondPost = Baseclass
						.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Facebook_second_Post")))
						.getText();
				System.out.println("SecondPost " + SecondPost);
				 if(SecondPost.equalsIgnoreCase(Article_Title))
				{
					test.log(LogStatus.PASS,
							"Logged into Facebook and checked the Acast Post is shared on the facebook wall");
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
}
