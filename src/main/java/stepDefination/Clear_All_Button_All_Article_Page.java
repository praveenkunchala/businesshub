package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Clear_All_Button_All_Article_Page extends Baseclass {
	String Before_Filter;
	WebElement After_Filter;
	String Msg;

	@Then("^On the all articles page click on filter by category$")
	public void on_the_all_articles_page_click_on_filter_by_category() throws Throwable {
		Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Filter_Pop_Up_Button"))).click();

	}

	@Then("^Select the category by checking on the check box and click apply$")
	public void select_the_category_by_checking_on_the_check_box_and_click_apply() throws Throwable {
		WebElement Pop_Up = Baseclass.driver.findElement(By.xpath(elementProperties.getProperty("Pop_Up_Browser")));
		Pop_Up.findElement(By.xpath(elementProperties.getProperty("Cyber_Security_check_Box"))).click();

		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {

			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		}
		Pop_Up.findElement(By.xpath(elementProperties.getProperty("Pop_Up_Apply"))).click();
		Baseclass.explicitlyWait(Baseclass.timeout);
	}

	@Then("^Verify the page only displays the selected categories$")
	public void verify_the_page_only_displays_the_selected_categories() throws Throwable {
		try {
			String category_Name = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Selected_Category"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);

			if (category_Name.equals(elementProperties.getProperty("Category_Text"))) {
				test.log(LogStatus.PASS, "Selected Category Appeared");
			} else {
				test.log(LogStatus.FAIL, "Selected Category not Appeared");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "Selected Category not appeared");
			e.printStackTrace();
		}

	}

	@Then("^Now click on clear all button on the page$")
	public void now_click_on_clear_all_button_on_the_page() throws Throwable {
		
	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Clear_All"))).click();
	Baseclass.explicitlyWait(Baseclass.timeout);

	}

	@Then("^verify the text appears on the page' you are viewing all articles'$")
	public void verify_the_text_appears_on_the_page_you_are_viewing_all_articles() throws Throwable {
		try {
			String Msg = Baseclass
					.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Confirmation_Msg1"))).getText();
			Baseclass.explicitlyWait(Baseclass.timeout);

			if (Msg.equals(elementProperties.getProperty("Confirmation_Msg_Text1"))) {
				test.log(LogStatus.PASS, "you are viewing all articles Message is appeared");
			} else {
				test.log(LogStatus.FAIL, "you are viewing all article Message is not appeared");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "you are viewing all article Message is not appeared");
			e.printStackTrace();
		}

	}

	@Then("^Verify all categories are now displayed on the view all articles page$")
	public void verify_all_categories_are_now_displayed_on_the_view_all_articles_page() throws Throwable {
		try {
			WebElement w=
			 Baseclass
				.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Confirmation_Msg1")));
			if(w.isDisplayed()) {
				test.log(LogStatus.PASS, "All Categories Are Displayed");
			} else {
				test.log(LogStatus.FAIL, "All Categories Are Not Displayed yet");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "All Categories Are Not Displayed");
			e.printStackTrace();
		}

	}
}