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
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;


public class Business_Preferences_Saving extends Baseclass{

  

    @Then("^Select preferences for 'your business' section$")
    public void select_preferences_for_your_business_section() throws Throwable {
		WebElement flag = Baseclass.driver
				.findElement(By.xpath(elementProperties.getProperty("Delete_button")));
		((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
        Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Tab"))).click();
       WebElement bt= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Type")));
    Select s=new Select(bt);
    s.selectByIndex(4);
    WebElement bto=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_turnover")));
    Select t=new Select(bto);
    t.selectByIndex(2);
    WebElement bl=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_location")));
    Select r=new Select(bl);
    r.selectByIndex(3);
    Baseclass.scrollDownFull();
   
    
    }

    @Then("^Click save preferences$")
    public static void click_save_preferences() throws Throwable {
    	 Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preferences"))).click();
    }

    @Then("^Verify The page displays an 'successfully saved' message$")
    public void verify_the_page_displays_an_successfully_saved_message() throws Throwable {
    	try {
			String success_msg=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Successfull_Msg"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);
			
			if(success_msg.equals(elementProperties.getProperty("Msg_text")))
			{
			test.log(LogStatus.PASS, "Successfully saved message is  Displayed");
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

    

}
