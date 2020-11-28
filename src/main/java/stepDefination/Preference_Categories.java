package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.ArrayList;
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

public class Preference_Categories extends Baseclass {

	@Then("^Click on account preferences tab$")
	public void click_on_account_preferences_tab() throws Throwable {

		Baseclass.scrollDownFull();
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Preference_link"))).click();
	}

	@Then("^Choose your interest tab$")
	public void choose_your_interest_tab() throws Throwable {

		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Your_Interests"))).click();

	}

	@Then("^Verify all categories are displayed on the page$")
	public void verify_all_categories_are_displayed_on_the_page() throws Throwable {
		List<String> l = new ArrayList<String>();
		String categories[] = { "Cyber Security", "Leadership and Management", "Sales and Marketing",
				"Strategy and Planning", "Tech and Innovation", "Reports", "Sustainable Energy Update",
				"Economics Weekly", "Manufacturing Weekly", "Property Monthly", "Agriculture",
				"Charities and Third Sector", "Education", "Healthcare", "Leisure", "Manufacturing and Automotive",
				"Professional Services", "Real Estate", "Renewable Energy", "Retail and Wholesale",
				"Technology, Media and Telecoms" };
		for (String s : categories) {
			l.add(s);
		}
		WebElement flag = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Your_Interests")));
		((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);

		WebElement D = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Restricted_Driver")));
		List<WebElement> w = D.findElements(By.tagName(elementProperties.getProperty("Tag_Name1")));
		for (int k = 1; k <= w.size() - 1; k++) {
			String Category_name = w.get(k).getText();
			System.out.println(Category_name);
			try {

				if (l.contains(Category_name)) {
					test.log(LogStatus.PASS,""+Category_name+" "+"category is displayed");
				} else {
					test.log(LogStatus.FAIL, ""+Category_name+" "+"category is not displayed");
				}

			} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
				test.log(LogStatus.FAIL, "All categories are not displayed");
				e.printStackTrace();
			}
		}

	}
}
