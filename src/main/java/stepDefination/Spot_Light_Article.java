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
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Spot_Light_Article extends Baseclass {
	String s;

	@Then("^Search for a word from the campaign list on the searchbox in the front end$")
	public void search_for_a_word_from_the_campaign_list_on_the_searchbox_in_the_front_end() throws Throwable {
		WebElement flag = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Spot_Light")));
		((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
		Baseclass.explicitlyWait(Baseclass.timeout);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Search"))).click();
		Baseclass.explicitlyWait(Baseclass.timeout);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Input_Text")))
				.sendKeys(elementProperties.getProperty("Spot_Light_Text") + Keys.ENTER);
		Baseclass.explicitlyWait(Baseclass.timeout);

	}

	@Then("^On the search results page, notice the result being displayed on the spotlight section eg:SPOTLIGHT$")
	public void on_the_search_results_page_notice_the_result_being_displayed_on_the_spotlight_section_egspotlight1()
			throws Throwable {

		try {

			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Spot"))).click();
			String s = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Spot"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (s.equals(elementProperties.getProperty("Spotlight_text"))) {
				test.log(LogStatus.PASS,
						"noticed that result being displayed on the spotlight section as eg:SPOTLIGHT(1)");
			} else {
				test.log(LogStatus.FAIL,
						"noticed that result are not  displayed on the spotlight section as eg:SPOTLIGHT(1)");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL,
					"noticed that result are not  displayed on the spotlight section as eg:SPOTLIGHT(1)");
			e.printStackTrace();
		}

	}

	@Then("^On the spotlight tab, verify the campaign is displayed$")
	public void on_the_spotlight_tab_verify_the_campaign_is_displayed() throws Throwable {

		try {
boolean p=Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Campaign"))).isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);

			if (p) {
				test.log(LogStatus.PASS, "campaign is displayed");
			} else {
				test.log(LogStatus.FAIL, "campaign is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "campaign is not displayed ");
			e.printStackTrace();
		}
	}

	@Then("^Also clicking on the spotlight result, the page can be verified$")
	public void also_clicking_on_the_spotlight_result_the_page_can_be_verified() throws Throwable {
		Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Campaign"))).click();
		Baseclass.explicitlyWait(Baseclass.timeout);
			
        
	}

}