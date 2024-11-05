package tests;

import org.testng.annotations.Test;

public class SignIn_Test 
{
	@Test
    public void testSuccessfulSignIn() 
	{
        System.out.println("You Are Signed In Successfully.");
    }
    
    @Test
    public void testSignInnWithInVaildCredentials()
    {
        System.out.println("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }
    
    @Test
    public void testSignInnWithEmptyCredentials()
    {
        System.out.println("The required fields are empty.");
    }
}

