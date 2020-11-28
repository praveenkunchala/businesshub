package stepDefination;

import java.net.MalformedURLException;

import com.utility.Baseclass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public Scenario scenario;
	@Before({"@PCC_Home_page,@PCC_Article_Validations,@Acast_Page,@Account_Preference_Link,@Business_Preferences_Saving,@clear_All_Button_All_Article_Page,@clear_All_Button_On_Pop_Up,@Clicking_On_Logo,@deleting_Profile,@Dropdowns_Selection,@Login_Button,@Preference_Categories,@Preference_Page,@Preference_Page_validations,@Preference_Page_View,@Select_All_Filter_Pop_Up,@User_Subscription,@Spot_Light_Article"})
	public void ExtentReport(Scenario scenario) throws NullPointerException, MalformedURLException, NoClassDefFoundError
	{
		this.scenario= scenario;
		Baseclass.testSetup(scenario);
	}
	
	
	@After({"@PCC_Home_page,@PCC_Article_Validations,@Acast_Page,@Account_Preference_Link,@Business_Preferences_Saving,@clear_All_Button_All_Article_Page,@clear_All_Button_On_Pop_Up,@Clicking_On_Logo,@deleting_Profile,@Dropdowns_Selection,@Login_Button,@Preference_Categories,@Preference_Page,@Preference_Page_validations,@Preference_Page_View,@Select_All_Filter_Pop_Up,@User_Subscription,@Spot_Light_Article"})
	public void afterScenario(Scenario scenario) {
		
		Baseclass.tearDown(scenario);
		Baseclass.closeAllBrowsers();
	}
	
}
