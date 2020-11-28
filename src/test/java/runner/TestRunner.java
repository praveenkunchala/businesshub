package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

		@RunWith(Cucumber.class)
		@CucumberOptions(
				features ="src/test/resources/Features",
				glue = { "stepDefination" }, 
				monochrome = true, 
				plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json"},
				tags = {"@Acast_Page,@Account_Preference_Link,@Business_Preferences_Saving,@clear_All_Button_All_Article_Page,@clear_All_Button_On_Pop_Up,@Clicking_On_Logo,@deleting_Profile,@Dropdowns_Selection,@Login_Button,@Preference_Categories,@Preference_Page,@Preference_Page_validations,@Preference_Page_View,@Select_All_Filter_Pop_Up,@User_Subscription,@Spot_Light_Article"}
)
		public class TestRunner {
			
		}
		