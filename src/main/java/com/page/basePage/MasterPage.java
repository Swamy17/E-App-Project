package com.page.basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MasterPage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public MasterPage(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\DSS_eApp_Automation_Component_Parallel_Sequential_Execution\\PageObjectModel_1\\src\\main\\java"
					+ "\\com\\page\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Chrome Driver latest\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.chrome.driver","D:\\Chrome Driver latest\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver(); 
	}
		//driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//eventListener = new WebEventListener();
		//driver.register(eventListener);
		//driver = driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //create util class for timeunit
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}	
	
	// Resuable Methods in MasterPage class.
	
	public static void enterText(WebElement ele,String txt)
	{
		ele.sendKeys(txt);
		
	}
	public static void waitForObject(WebDriver driver)
	{
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public static void clickButton(WebElement ele,String str)
	{
		System.out.println("im in master");
		System.out.println(str);
		ele.click();
	}
	
	public void actionMethods(WebDriver driver,WebElement el) {
		Actions action=new Actions(driver);
		action.doubleClick(el).build().perform();
		
	}
	
	public static void windowHandling(WebDriver driver)
	{

		String parent=driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();
		for(String cWindow:child)
		{
			driver.switchTo().window(cWindow);
			if(driver.getTitle().equalsIgnoreCase("Sykes"))
			{
			driver.close();
			}
			else
				{
				System.out.println("It is jumped into else block");
				}
				}
		}
		
}
