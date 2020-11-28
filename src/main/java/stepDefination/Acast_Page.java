package stepDefination;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

import cucumber.api.java.en.Then;

public class Acast_Page extends Baseclass {
	@Then("^Search for the acast page on frontend eg:technically speaking$")
	public static void search_for_the_acast_page_on_frontend_eg_technically_speaking() throws Throwable {
	    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Search"))).click();
	    Baseclass.explicitlyWait(Baseclass.timeout);
	    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Input_Text"))).sendKeys(elementProperties.getProperty("Input_Text1")+Keys.ENTER);
	    Baseclass.explicitlyWait(Baseclass.timeout);
	    Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Technical_Text"))).click();
	    
	}

	@Then("^verify the acast pod contains the following: Title, date, mins, subscribe and share button$")
	public void verify_the_acast_pod_contains_the_following_Title_date_mins_subscribe_and_share_button() throws Throwable {
		try {
			String Technical_Text=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Technical_Text"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(Technical_Text.equals(elementProperties.getProperty("Technical_Name")))
			{
			test.log(LogStatus.PASS, "Acast Article Title is Verified");
			}
			else
			{
				test.log(LogStatus.FAIL, "Acast ArticleTitle is not verified");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Acast Article Title is not verified");
			e.printStackTrace();
		}
		try {
			boolean flag=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("date"))).isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(flag)
			{
			test.log(LogStatus.PASS, "Acast Article Date is visible");
			}
			else
			{
				test.log(LogStatus.FAIL, "Acast Article Date is not visible");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Acast Article Date is not visible");
			e.printStackTrace();
		}
		try {
			boolean flag1=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Minutes"))).isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(flag1)
			{
			test.log(LogStatus.PASS, "Acast Article minutes is visible");
			}
			else
			{
				test.log(LogStatus.FAIL, "Acast Article minutes is not visible");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Acast Article minutes is not visible");
			e.printStackTrace();
		}
		try {
			boolean subscribe=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Subscribe_button"))).isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(subscribe)
			{
			test.log(LogStatus.PASS, "Acast Article Subscribe Button is visible");
			}
			else
			{
				test.log(LogStatus.FAIL, "Acast Article Subscribe Button is not visible");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Acast Article Subscribe Button is not visible");
			e.printStackTrace();
		}
		try {
			boolean share=Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Share_Button"))).isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if(share)
			{
			test.log(LogStatus.PASS, "Acast Article Share Button is visible");
			}
			else
			{
				test.log(LogStatus.FAIL, "Acast Article Share Button is not visible");
			}
			
			
		} catch (StaleElementReferenceException | ElementNotInteractableException |TimeoutException e) {
			test.log(LogStatus.FAIL, "Acast Article Share Button is not visible");
			e.printStackTrace();
		}
	    
	}
}
