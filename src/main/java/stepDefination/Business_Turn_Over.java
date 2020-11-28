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

public class Business_Turn_Over extends Baseclass {
	int t;

	@Then("^Select a 'business turn over' from the drop down menu$")
	public void select_a_business_turn_over_from_the_drop_down_menu() throws Throwable {
		try {
			WebElement b1 = Baseclass.WaitElementVisible(driver,
					By.xpath(elementProperties.getProperty("Business_turnover")));
			Select r1 = new Select(b1);

			t = r1.getOptions().size() - 1;
			for (int i = 0; i <= t; i++) {

				for (int ii = 0; ii < 3; ii++) {
					try {
						WebElement b = Baseclass.WaitElementVisible(driver,
								By.xpath(elementProperties.getProperty("Business_turnover")));
						Select r = new Select(b);
						r.selectByIndex(i);
						test.log(LogStatus.PASS, "" + r.getFirstSelectedOption().getText()
								+ " option in Business turn over drop Down are able to Select");
						break;
					} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}

				}

			}
		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "All options in Business turn over  drop Down are not able to Select");
			e.printStackTrace();
		}

	}

}
