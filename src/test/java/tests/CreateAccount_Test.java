package tests;

import org.testng.annotations.Test;

public class CreateAccount_Test {
	 @Test
	    public void testSuccessfulAccountCreation() {
	        
	        System.out.println("Thank you for registering with Main Website Store.");
	    }
	    
	    @Test
	    public void testAccountCreationWithExistingEmail() {
	        
	        System.out.println("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
	    }
	    
	    @Test
	    public void testAccountCreationWithMismatchedPasswordAndConfirmation() {
	        System.out.println("There is an error message indicating that the passwords do not match.");
	    }

	    @Test
	    public void testAccountCreationWithInvalidEmailFormat() {
	        System.out.println("There is an error message indicating that the email format is invalid.");
	    }

	    
	    
}
