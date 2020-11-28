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

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Preference_Page_View extends Baseclass {

	@Then("^Click on the profile icon at the top right of the page$")
	public void click_on_the_profile_icon_at_the_top_right_of_the_page() throws Throwable {
		Baseclass.explicitlyWait(2);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Profile_Icon"))).click();

	}

	@Then("^Once logged in the user is able to view the preference page$")
	public void once_logged_in_the_user_is_able_to_view_the_preference_page() throws Throwable {
		try {
	        Baseclass.scrollDownFull();
			String Preference_title = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Save_Preferences"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);

			if (Preference_title.equals(elementProperties.getProperty("Save_preference_Text"))) {
				test.log(LogStatus.PASS, "user  is able to view Preference Page");
			} else {
				test.log(LogStatus.FAIL, "user is Unable to view Preference Page");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "user is Unable to view Preference Page");
			e.printStackTrace();
		}
	}
}
