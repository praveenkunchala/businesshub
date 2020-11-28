package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.Baseclass;

public class Select_All_Filter_Pop_Up extends Baseclass {

	@Then("^Click on all select all button and Verify all the categories are selected for a topic$")
	public void click_on_all_select_all_button_and_verify_all_the_categories_are_selected_for_a_topic()
			throws Throwable {

		String[] category = {elementProperties.getProperty("Business_Guidance"),elementProperties.getProperty("Market_Trends"),elementProperties.getProperty("Sector")};
		System.out.println(category.length);
		System.out.println(category.toString());
		for (int i = 0; i < category.length; i++) {
			System.out.println(category[i]);
			// looping all three category
			WebElement checkbox = driver.findElement(By.xpath(category[i]));
			boolean isSelected = checkbox.isSelected();
			// validate the check box whether user select or not
			if (isSelected == false) {
				try {
					checkbox.click();
					test.log(LogStatus.PASS,"All  Checkbox are selected");
				}

				catch (Exception e) {

					e.printStackTrace();

				}

			} else {
				test.log(LogStatus.FAIL,"All Checkbox are not selected");
			}

			Baseclass.explicitlyWait(Baseclass.timeout);

			driver.findElement(By.xpath(elementProperties.getProperty("Clear_All_Button"))).click();
		}

	
		
	}
}
