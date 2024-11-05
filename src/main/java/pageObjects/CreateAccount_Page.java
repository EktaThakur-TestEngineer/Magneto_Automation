package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;
import utilities.Constants;

public class CreateAccount_Page extends Constants
{
	
	   WebDriver driver;
	   
	   public CreateAccount_Page(WebDriver driver) 
	    {
	        this.driver = driver;
	    }
	   
	    By createAccountPageLink   = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
	    By firstNameField          = By.id("firstname");
	    By lastNameField              = By.id("lastname");
	    By emailField                 = By.id("email_address");
	    By passwordField              = By.id("password");
	    By confirmPasswordField       = By.id("password-confirmation");
	    public By createAccountButton = By.xpath("//*[@id='form-validate']/div/div[1]/button");
	    By successMessage             = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div");
	    By welcomeMessage             = By.cssSelector("li.greet.welcome span.logged-in");
	    By usedMailErrorMessage	      = By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div");
	    By emailAddressError          = By.id("email_address-error");
	    By passwordConfirmationError  = By.id("password-confirmation-error");

	    
	    public void clickCreateAccountPageLink()
	    {
	    	driver.findElement(createAccountPageLink).click();
	    }
	    
	    public void enterFirstName(String firstName) 
	    {
	        driver.findElement(firstNameField).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) 
	    {
	        driver.findElement(lastNameField).sendKeys(lastName);
	    }

	    public void enterEmail(String email) 
	    {
	        driver.findElement(emailField).sendKeys(email);
	        
	    }

	    public void enterPassword(String password) 
	    {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) 
	    {
	        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	    }
	    
	    public void clickCreateAccount() 
	    {
	        driver.findElement(createAccountButton).click();
	    }
	    
	    public String actualSignupSuccessMsg()
	    {
	    	return driver.findElement(successMessage).getText();
	    }
	    
	    public String expectedSignupSuccessMsg()
	    {
	    	String successMessage = "Thank you for registering with Main Website Store.";
	    	return successMessage;
	    }
	    
	    public String actualUserTextDisplay()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement welcomeMessageDisp = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
	    	
	    	return welcomeMessageDisp.getText();

	    }
	    
	    public String expectedWelcomeTextDisplay() 
	    {
	    	String signInWelcomeText = "Welcome, " + firstName + " " + lastName + "!";
			return signInWelcomeText;
	    	
	    }
	    
	    public String actualAlreadyUsedMailErrorMsg()
	    {
	    	return driver.findElement(usedMailErrorMessage).getText();
	    }
	    
	    public String expectedAlreadyUsedMailErrorMsg()
	    {
	    	String alreadyUsedMailErrorMsg = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
	    	return alreadyUsedMailErrorMsg;
	    }
	    
	    public String actualPasswordConfirmationErrorMsg()
	    {
	    	return driver.findElement(passwordConfirmationError).getText();
	    }
	    
	    public String expectedPasswordConfirmationErrorMsg()
	    {
	    	String alreadyUsedMailErrorMsg = "Please enter the same value again.";
	    	return alreadyUsedMailErrorMsg;
	    }
	    
	    public String actualEmailAddressErrorMsg()
	    {
	    	return driver.findElement(emailAddressError).getText();
	    }
	    
	    public String expectedEmailAddressErrorMsg()
	    {
	    	String alreadyUsedMailErrorMsg = "Please enter a valid email address (Ex: johndoe@domain.com).";
	    	return alreadyUsedMailErrorMsg;
	    }
	    
}


