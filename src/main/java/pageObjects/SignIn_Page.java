package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class SignIn_Page extends Constants

{
	    public WebDriver driver;

	    public SignIn_Page(WebDriver driver) 
	    {
	        this.driver = driver;
	    }

	    By signInPageLink       = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
	    By emailField           = By.id("email");
	    By passwordField        = By.id("pass");
	    By signInButton         = By.xpath("//*[@id='send2']");
	    By successMessage       = By.xpath("//span[@class='logged-in']");
	    By welcomeMessage       = By.cssSelector("li.greet.welcome span.logged-in");
	    By errorMessage         = By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div");
	    By errorEmailMessage    = By.id("email-error");
	    By errorPasswordMessage = By.id("pass-error");

	    public void goToSignInPage() 
	    {
	        driver.findElement(signInPageLink).click();
	        
	    }

	    public void enterEmail(String email) 
	    {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) 
	    {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickSignInButton() 
	    {
	        driver.findElement(signInButton).click();
	    }

	    public String getSignInSuccessText() 
	    {
	        return driver.findElement(successMessage).getText();
	    }

	    public String actualSignInFailText() 
	    {
	        return driver.findElement(errorMessage).getText();
	    }
	    
	    public String expectedSignInFailText() 
	    {
	    	String signInFailText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
			return signInFailText;
	    	
	    }
	    
	    public String actualSignInTextDisplay()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement welcomeMessageDisp = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
	    	
	    	return welcomeMessageDisp.getText();

	    }
	    
	    public String expectedSignInTextDisplay() 
	    {
	    	String signInWelcomeText = "Welcome, " + firstName + " " + lastName + "!";
			return signInWelcomeText;
	    	
	    }
	    
	    public String actualErrorMsgForEmailField()
	    {
	    	return driver.findElement(errorEmailMessage).getText();
	    }
	    
	    public String actualErrorMsgForPasswordField()
	    {
	    	return driver.findElement(errorPasswordMessage).getText();
	    }
	    
	    public String expectedFieldErrorMsgDisplay() 
	    {
	    	String signInWelcomeText = "This is a required field.";
			return signInWelcomeText;
	    	
	    }
	    
	    
	

}
