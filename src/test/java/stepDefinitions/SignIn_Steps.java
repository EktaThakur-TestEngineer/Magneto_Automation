package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CreateAccount_Page;
import pageObjects.SignIn_Page;
import utilities.BaseClass;
import utilities.Constants;

public class SignIn_Steps extends Constants
{
	
	public WebDriver driver;
	public BaseClass B;
	public SignIn_Page SIP;
	
	
	  @Given("User is on the URL {string}") 
	  public void user_opens_the_url(String url)throws InterruptedException 
	  { 
		  WebDriverManager.edgedriver().setup();
		  EdgeOptions options = new EdgeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  options.addArguments("--disable-notifications"); 
		  DesiredCapabilities cp = new DesiredCapabilities(); 
		  cp.setCapability(EdgeOptions.CAPABILITY, options);
		  options.merge(cp);
		  
		  driver = new EdgeDriver(options); 
		  SIP = new SignIn_Page(driver); 
		  B = new BaseClass(driver); 
		  driver.get("https://magento.softwaretestingboard.com/");
		  driver.manage().window().maximize(); 
		  
	  }
	 
	  @When("Click on the link of {string}")
	  public void Click_on_the_link_of(String string)
	  {
		  SIP.goToSignInPage();
	  }
	
	@Then("SignIn Page should open")
	public void login_page_should_open() 
	{
	  B.windowHandles();
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() 
	{
	   SIP.enterEmail(validEmail);
	   SIP.enterPassword(password);
	}
	
	@When("Click the button {string}")
    public void click_the_button(String string) 
    {
    	SIP.clickSignInButton();
    }

	@Then("Users account dashboard should be visible on the screen")
	public void users_account_dashboard_should_be_visible_on_the_screen() 
	{
    	Assert.assertEquals(SIP.actualSignInTextDisplay(), SIP.expectedSignInTextDisplay());
	} 
	
	
	@When("User enters invalid credentials")
	public void user_enters_invalid_credentials() 
	{
		SIP.enterEmail(signinInvalidEmail);
		SIP.enterPassword(password);
	}

	@Then("User should see an error message indicating invalid login credentials")
	public void user_should_see_an_error_message_indicating_invalid_login_credentials() 
	{
	    
		Assert.assertEquals(SIP.actualSignInFailText(),SIP.expectedSignInFailText());
	}
	
	@When("User leaves the username and password fields empty")
	public void user_leaves_the_username_and_password_fields_empty() 
	{
		//No action required from user
	}
	
	@Then("User should see an error message indicating that credentials are required")
	public void user_should_see_an_error_message_indicating_that_credentials_are_required() 
	{
	    Assert.assertEquals(SIP.actualErrorMsgForEmailField(), SIP.expectedFieldErrorMsgDisplay());
	    Assert.assertEquals(SIP.actualErrorMsgForPasswordField(), SIP.expectedFieldErrorMsgDisplay());
	}
	
	@When("Close browser")
    public void close_the_browser()
    {
    	B.close_browser();
    }
}
