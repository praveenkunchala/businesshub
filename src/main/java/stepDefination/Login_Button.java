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

public class Login_Button extends Baseclass {

	@Then("^login Button is visible with login with linkedin Text$")
	public void the_login_button_is_visible_with_login_with_linkedin_text() throws Throwable {
		
		try {
			boolean flag= Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Linkidin")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (flag) {
				test.log(LogStatus.PASS, "login Button is visible with login with linkedin Text");
			} else {
				test.log(LogStatus.FAIL, "login Button is not visible with login with linkedin Text");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "login Button is not visible with login with linkedin Text");
			e.printStackTrace();
		}
	}

	}

