package com.utility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static String title = null;
	public static List<WebElement> list;
	public static int count;
	public static String browser = "Browser";
	
	public static WebDriver driver;
	public static ChromeDriver ChromeDriver;
	public static int timeout = 10;
	public static InternetExplorerOptions options;
	
	public Scenario scenario;
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExtentReports er;
	
	public static String CurrentUrl = null;
	public static final String AUTOMATE_USERNAME = "vishnu182";
	  public static final String AUTOMATE_ACCESS_KEY = "q1HXjZ17KEpuisMq1xyc";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static Properties elementProperties;
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties("data.properties");
	}

	public static void openBrowser(String browserType ) throws Exception {
		
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;

		case "internetexplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "safari":
			Baseclass.Safari_setup();
			browser = "safari";
			break;
			
		case "Mobile":
			Baseclass.Mobile_setup();
			browser = "Mobile";
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		  
	}
	
	public static void Safari_setup() throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "Catalina");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "13.1");
	    caps.setCapability("os", "OS X");
	    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	  }
	
	public static void Mobile_setup() throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "emulator-5554");
	    caps.setCapability("platformName", "Android");
	    caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	    caps.setCapability(CapabilityType.VERSION, "11");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    caps.setCapability("autoDismissAlerts", true);
//	    driver =new ChromeDriver(options);
	    driver = new RemoteWebDriver(new java.net.URL("http://0.0.0.0:4723/wd/hub"), caps);
	  }
		
	public static WebElement WaitElementVisible(WebDriver driver, By by) {
	    return new WebDriverWait(driver,10)
	        .until(ExpectedConditions.visibilityOfElementLocated((by)));
	}
	
	
	public static void navigateUrl(String url) {
		try {
			if(driver!=null){
			driver.get(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getPageTitle(){
		
		if(driver!=null){
		title =	driver.getTitle();
		}
		return title;
	}

	public static void windowmaximize() {
		try {
			if(driver!=null){
			driver.manage().window().maximize();
		} 
			}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void RefreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void scrollDownFull() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 100000);");
	}
	
	public static void scrollDown() {

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scroll(0, 800);");
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
	}
	
	public static void explicitlyWait(int time) {

		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getParentWindow() {
		String main_window = driver.getWindowHandle();
		return main_window;
	}

	public static void switchToNewWindow() {
		
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("Window Handles "+winHandle);
			driver.switchTo().window(winHandle);
		}
	}
	
	public static void closeAllBrowsers() {
		try{
		
		if(driver!=null){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Baseclass.driver.quit();
		}else{
			System.out.println("Session is null");
		}
		}catch(NoSuchSessionException e){
			e.printStackTrace();
		}
	}
	
public static int get_Count(String Webelement){
		
		if(driver!=null){
		list =	driver.findElements(By.xpath(Webelement));
		count = list.size();		
		}
		else{
			System.out.println("Session is null");
		}
		return count;
}

public static void testSetup(Scenario scenario) 
{
	System.out.println("Chrome Browser Test Environment created");  
	  System.out.println("Test Environment Set up ");
	  System.out.println("----------------------------------------------------------------------");
	  System.out.println("Executing Scenario :"+scenario.getName());
	  
	  String dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	  Date date = new Date();
      er=new ExtentReports("D:\\Bhanu_Test\\PPC Reports\\Report"+dateFormat+".html",true);
	  test = er.startTest("ExtentDemo");
	  
}

public static void tearDown(Scenario scenario)
{
	scenario.write("Finished scenario");
	if (scenario.isFailed())
			{
				scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
			}
	System.out.println("Test Environment Destroyed ");
	System.out.println("----------------------------------------------------------------------");
	er.endTest(test);
	er.flush();
}

public static void JavaScriptExec_click(WebElement WebElement) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", WebElement);   
}

public static String get_Url() {
	if(driver!=null){
		String Current = driver.getCurrentUrl();
		System.out.println("CurrentUrl : "+Current);
		String[] Url = Current.split("/");
		CurrentUrl = Url[3];
		
		}
		return CurrentUrl;
}

public static void JavaScriptExec_Send_Keys(String WebElement,String SendKeys) {
	
	try {
		if(driver!=null)
			{
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].setAttribute('value', '" + SendKeys +"')", WebElement);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
}

public static void Handle_Alerts() {
	
	Actions builder = new Actions(driver);
	builder.sendKeys(Keys.ESCAPE).build().perform();
	
}

	}