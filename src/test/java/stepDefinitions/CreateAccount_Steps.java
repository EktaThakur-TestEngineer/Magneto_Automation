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
import utilities.BaseClass;
import utilities.Constants;

public class CreateAccount_Steps extends Constants
{	
	public WebDriver driver;
	public BaseClass B;
    public CreateAccount_Page CAP;

    
    @Given("User is on URL {string}")
    public void user_opens_url(String url) throws InterruptedException 
    {
    	WebDriverManager.edgedriver().setup();  
	    EdgeOptions options = new EdgeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--disable-notifications");
	    DesiredCapabilities cp = new DesiredCapabilities();
	    cp.setCapability(EdgeOptions.CAPABILITY, options);
	    options.merge(cp);
	    
	    driver = new EdgeDriver(options);  
	    CAP = new CreateAccount_Page(driver);
	    B = new BaseClass(driver);
	    driver.get("https://magento.softwaretestingboard.com/");
	    driver.manage().window().maximize();
	    
      
    }
	    @When("Click on the Create Account link {string}")
	    public void click_on_the_create_account_link(String string) 
	    {
	    	CAP.clickCreateAccountPageLink();
	    }

	    @Then("Create Account Page should open")
	    public void create_account_page_should_open() 
	    {
	    	B.windowHandles();
	    }

	    @When("User enter valid details")
	    public void user_enter_valid_details() 
	    {
	    	CAP.enterFirstName(firstName);
	        CAP.enterLastName(lastName);
	        B.scrollDownC(300);
	        CAP.enterEmail(validEmail);
	        B.scrollDownC(300);
	        CAP.enterPassword(password);
	        CAP.enterConfirmPassword(confirmPassword);
	    }

	    @When("Click on the button {string}")
	    public void click_on_the_button(String string) 
	    {
	    	CAP.clickCreateAccount();
	    }

	    @When("User enter details with an already registered email")
	    public void user_enter_details_with_an_already_registered_email() 
	    {
	    	CAP.enterFirstName(firstName);
	        CAP.enterLastName(lastName);
	        B.scrollDownC(300);
	        CAP.enterEmail(alreadyUsedEmail);
	        B.scrollDownC(300);
	        CAP.enterPassword(password);
	        CAP.enterConfirmPassword(confirmPassword);
	    }

	    @When("Click on {string}")
	    public void click_on(String string) 
	    {
	    	CAP.clickCreateAccount();
	    }
	    
	    @Then("User should see a success message indicating successful login")
	    public void user_should_see_a_success_message_indicating_successful_login()
	    {
	    	Assert.assertEquals(CAP.actualSignupSuccessMsg(), CAP.expectedSignupSuccessMsg());
	    	Assert.assertEquals(CAP.actualUserTextDisplay(), CAP.expectedWelcomeTextDisplay());
	    } 
	    

	    @Then("User should see an error message indicating the email is already in use")
	    public void user_should_see_an_error_message_indicating_the_email_is_already_in_use() 
	    {
	        Assert.assertEquals(CAP.actualAlreadyUsedMailErrorMsg(), CAP.expectedAlreadyUsedMailErrorMsg());
	    }
	    
	    
	    @When ("User enters a password and a different confirmation password")
	    public void User_enters_a_password_and_a_different_confirmation_password()
	    {
	    	CAP.enterFirstName(firstName);
	        CAP.enterLastName(lastName);
	        B.scrollDownC(300);
	        CAP.enterEmail(validEmail);
	        B.scrollDownC(300);
	        CAP.enterPassword(password);
	        CAP.enterConfirmPassword(inValidPassword);
	    }
	    
	    @Then ("User should see an error message indicating that the passwords do not match")
	    public void User_should_see_an_error_message_indicating_that_the_passwords_do_not_match()
	    {
	    	Assert.assertEquals(CAP.actualPasswordConfirmationErrorMsg(), CAP.actualPasswordConfirmationErrorMsg());
	    }
	    
	    @When ("User enters an email in an incorrect format")
	    public void User_enters_an_email_in_an_incorrect_format()
	    {
	    	CAP.enterFirstName(firstName);
	        CAP.enterLastName(lastName);
	        B.scrollDownC(300);
	        CAP.enterEmail(inValidEmailFormat);
	        B.scrollDownC(300);
	        CAP.enterPassword(password);
	        CAP.enterConfirmPassword(confirmPassword);
	    }
	    
	   
	    @Then ("User should see an error message indicating that the email format is invalid")
	    public void User_should_see_an_error_message_indicating_that_the_email_format_is_invalid()
	    {
	    	Assert.assertEquals(CAP.actualEmailAddressErrorMsg(), CAP.expectedEmailAddressErrorMsg());
	    }
	    
	    @When("Close the browser")
	    public void close_the_browser()
	    {
	    	B.close_browser();
	    }
	}



