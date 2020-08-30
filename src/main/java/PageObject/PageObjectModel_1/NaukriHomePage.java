package PageObject.PageObjectModel_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.basePage.MasterPage;

public class NaukriHomePage extends MasterPage
{
	@FindBy(xpath="//div[contains(text(),'Login')]") 
	@CacheLookup
	public WebElement eltlogin;
	
	//@FindBy(xpath="//div[@class='form-row']//following::input[starts-with(@placeholder,'Enter your active')]") 
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']") 
	@CacheLookup
	public WebElement eltUserName;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']") 
	@CacheLookup
	public WebElement eltPassword;
	
	@FindBy(xpath="//button[@class='btn-primary loginButton']") 
	@CacheLookup
	public WebElement eltLoginBtn;
	
	// Initializing the Page Objects:
		public NaukriHomePage() 
		{
			PageFactory.initElements(driver, this);
		}
		
		     
        
      	public void  enterUserName() {
		
		//enterText();
		clickButton(eltlogin,"ClickonButton");
		waitForObject(driver);
		enterText(eltUserName,"tkumaraswamy.qa@gmail.com");
		enterText(eltPassword,"Krishna**248");
		clickButton(eltLoginBtn,"ClickonButton");
        //actionMethods(driver,eltUserName);
        windowHandling(driver);
	}



}
