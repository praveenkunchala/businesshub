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


public class Clicking_On_Logo extends Baseclass{

   

    @Then("^Click on Bank logo$")
    public void click_on_bank_logo() throws Throwable {
    	Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("Logo"))).click();
    	Baseclass.explicitlyWait(Baseclass.timeout);
    	
        
    }

    @Then("^verify home page title after clicking on logo$")
    public void verify_home_page_title_after_clicking_on_logo() throws Throwable {
    	String Title=Baseclass.getPageTitle();
    	System.out.println(Title);
    	try {
		

			if (Title.equals(elementProperties.getProperty("Logo_Title"))) {
				test.log(LogStatus.PASS, "Redirect to home page");
			} else {
				test.log(LogStatus.FAIL, "not Redirect to home page");
			}

		} catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
			test.log(LogStatus.FAIL, "not Redirect to home page");
			e.printStackTrace();
		}
        
    }

  

}
