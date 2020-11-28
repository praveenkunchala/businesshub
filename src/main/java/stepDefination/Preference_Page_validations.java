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

public class Preference_Page_validations extends Baseclass {

	@Then("^validate preference Page Objects$")
	public void validate_preference_page_objects() throws Throwable {
		try {
			
			boolean Fn = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("First_Name")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (Fn) {
				test.log(LogStatus.PASS, "First name is displayed");
			} else {
				test.log(LogStatus.FAIL, "First name is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "First Name is not displayed");
			e.printStackTrace();
		}

		try {
			boolean ln = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Last_Name")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (ln) {
				test.log(LogStatus.PASS, "last name is displayed");
			} else {
				test.log(LogStatus.FAIL, "last name is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "last name is not displayed");
			e.printStackTrace();
		}

		try {
			boolean em = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Email")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (em) {
				test.log(LogStatus.PASS, "Email is displayed");
			} else {
				test.log(LogStatus.FAIL, "Email is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Email is not displayed");
			e.printStackTrace();
		}

		try {
			
			WebElement flag = Baseclass.driver
					.findElement(By.xpath(elementProperties.getProperty("Delete_button")));
			((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
			boolean da = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Delete_button")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (da) {
				test.log(LogStatus.PASS, "delete Account button  is displayed");
			} else {
				test.log(LogStatus.FAIL, "delete Account button is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "delete Account button not displayed");
			e.printStackTrace();
		}

		try {
			WebElement flag = Baseclass.driver
					.findElement(By.xpath(elementProperties.getProperty("Preferences_Text")));
			((JavascriptExecutor) (Baseclass.driver)).executeScript("arguments[0].scrollIntoView();", flag);
			
			boolean pt = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Preferences_Text")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (pt) {
				test.log(LogStatus.PASS, "Preferences title  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Preferences title is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Preferences title not displayed");
			e.printStackTrace();
		}

		try {
			boolean pt = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Tab")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (pt) {
				test.log(LogStatus.PASS, "Your business tab  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Your business tab is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Your business tab not displayed");
			e.printStackTrace();
		}
		try {
			boolean yi = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Your_Interests")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (yi) {
				test.log(LogStatus.PASS, "Your Interest tab  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Your Interest  tab is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Your Interest  tab not displayed");
			e.printStackTrace();
		}
		try {
			boolean B = Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_Type")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (B) {
				test.log(LogStatus.PASS, "Business type drop down  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Business type drop down  is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Business Type drop down not displayed");
			e.printStackTrace();
		}
		try {
			Baseclass.scrollDownFull();
			boolean BT = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_turnover")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (BT) {
				test.log(LogStatus.PASS, "Business turn over drop down  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Business turn over drop down  is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Business turn over drop down  not displayed");
			e.printStackTrace();
		}
		try {
			boolean BL = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Business_location")))
					.isDisplayed();
			Baseclass.explicitlyWait(Baseclass.timeout);
			if (BL) {
				test.log(LogStatus.PASS, "Business location drop down  is displayed");
			} else {
				test.log(LogStatus.FAIL, "Business location drop down  is not displayed");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Business location drop down  not displayed");
			e.printStackTrace();
		}
	}
}
