package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class User_Subscription extends Baseclass {

	@Then("^Click on the your interests tab$")
	public void click_on_the_your_interests_tab() throws Throwable {
		WebElement flag = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Delete_button")));
		((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Your_Interests"))).click();
		
	}

	@Then("^Tick the check box to be updated for the latest emails$")
	public void tick_the_check_box_to_be_updated_for_the_latest_emails() throws Throwable {
		
		Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Email_click"))).click();

	}
	@Then("^Verify The page displays an 'successfully saved' message on Your Interest screen$")
	public void verify_The_page_displays_an_successfully_saved_message_on_Your_Interest_screen() throws Throwable {
	   
	   try {
		   String Msg=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Success_Msgs"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);
			
			if(Msg.equals(elementProperties.getProperty("msg_text2")))
			{
			test.log(LogStatus.PASS, "message is  Displayed");
			}
			else
			{
				test.log(LogStatus.FAIL, "Message is not displayed");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Message is not displayed");
			e.printStackTrace();
		}
	}


}
