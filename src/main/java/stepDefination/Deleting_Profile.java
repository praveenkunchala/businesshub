package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Deleting_Profile extends Baseclass {

	@Then("^click on delete my account button$")
	public void click_on_delete_my_account_button() throws Throwable {
		WebElement flag = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("First_Name")));
		((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Delete_button"))).click();
		Baseclass.explicitlyWait(Baseclass.timeout);

	}

	@Then("^verify The profile icon is hidden 'Account preferences' is removed from footer$")
	public void verify_the_profile_icon_is_hidden_account_preferences_is_removed_from_footer() throws Throwable {
		try {
			String s = Baseclass.getPageTitle();
			Baseclass.explicitlyWait(Baseclass.timeout);

			if (s.contains(elementProperties.getProperty("homepagetitle"))) {
				test.log(LogStatus.PASS, "Both Account Preference link and Profile icon are not displayed");
			} else {
				test.log(LogStatus.FAIL, "Both Account Preference link and Profile icon are  displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Both Account Preference link and Profile icon are  displayed");
			e.printStackTrace();
		}
	}

	@And("^click confirm$")
	public void click_confirm() throws Throwable {
		WebElement Msg = Baseclass.WaitElementVisible(driver,
				By.xpath(elementProperties.getProperty("Confirmation_Msg")));
		Msg.findElement(By.xpath(elementProperties.getProperty("Accept"))).click();
	}
}
