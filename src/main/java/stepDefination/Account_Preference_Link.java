package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Account_Preference_Link extends Baseclass {

	@Then("^The user is able to see the account preferences link in the footer$")
	public void the_user_is_able_to_see_the_account_preferences_link_in_the_footer() throws Throwable {
		Baseclass.scrollDownFull();
		try {
			boolean Link = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Preference_link")))
					.isDisplayed();

			if (Link) {
				test.log(LogStatus.PASS, "Preference Account link is visible");
			} else {
				test.log(LogStatus.FAIL, "Preference Account link is not visible");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Preference Account link is not visible");
			e.printStackTrace();
		}
	}

}