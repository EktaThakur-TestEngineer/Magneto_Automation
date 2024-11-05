package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BaseClass 

{
	
	public WebDriver driver;
	
	public BaseClass(WebDriver driver) 
	{
		this.driver =driver;
	}
	

	
	//Common Methods
	
	public void close_browser() 
	{
		driver.close();
	}
	
	public void windowHandles() 
	{
		
		String mainWindowHandle = driver.getWindowHandle();
	
		for(String windowHandle : driver.getWindowHandles()) 
		{
			if (!windowHandle.equals(mainWindowHandle)) 
			{
				driver.switchTo().window(windowHandle);
	            break;
	        }
		
		}
		
	}
	
	public void scrollUntilElementIsFound(WebElement element) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    while (true) 
	    {
	        try {
	            	if (element.isDisplayed()) 
	            { 
	                break;
	            }
	        }
	        	catch (Exception e) 
	        {
	            
	            js.executeScript("window.scrollBy(0, 250);");
	        }
	    }
	}

	
	
	public void scrollDownC(int pixelsToScroll) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Scroll down by specified pixels vertically
	    js.executeScript("window.scrollBy(0," + pixelsToScroll + ")");
	}


}
