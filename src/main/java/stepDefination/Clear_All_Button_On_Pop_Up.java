package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Clear_All_Button_On_Pop_Up extends Baseclass {

	@Then("^Click on select all button$")
	public void click_on_select_all_button() throws Throwable {
		WebElement Pop_Up = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Pop_Up_Browser")));
		Pop_Up.findElement(By.xpath(elementProperties.getProperty("Select_All_Button"))).click();

	}

	@Then("^Click clear all on the bottom of the pop up$")
	public void click_clear_all_on_the_bottom_of_the_pop_up() throws Throwable {
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {

			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		}
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Clear_All_Button"))).click();
		Baseclass.explicitlyWait(Baseclass.timeout);
	}

	@Then("^Verify all the checkboxes are unchecked$")
	public void verify_all_the_checkboxes_are_unchecked() throws Throwable {
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {

			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);

		}

		WebElement Business_Guidance = Baseclass.WaitElementVisible(driver,
				By.xpath(elementProperties.getProperty("Business_Guidance")));
		List<WebElement> w = Business_Guidance.findElements(By.tagName(elementProperties.getProperty("Tag_Name")));
		int count = 0;
		for (WebElement s : w) {

			Boolean flag = s.isSelected();
			if (flag) {
				count++;

			}
		}
		try {

			if (count == 0) {
				test.log(LogStatus.PASS, "All check boxes Are  un checked");
			} else {
				test.log(LogStatus.FAIL, "All check boxes Are not un checked");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "All check boxes Are not un checked");
			e.printStackTrace();
		}
	}

}