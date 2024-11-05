package runnerFile;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    dryRun = false,
	    monochrome = true,
	    tags = "@SignIn"
	)
	
	@Test
	public class SignIn_TestRunner 
	{
		
	}


