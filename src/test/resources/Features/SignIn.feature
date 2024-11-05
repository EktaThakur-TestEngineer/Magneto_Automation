Feature: User SignIn

@SignIn
	Scenario: SignIn With Vaild Credentials
		Given User is on the URL "https://magento.softwaretestingboard.com/"
		When Click on the link of "Sign In"
		Then SignIn Page should open
		When User enters valid credentials
		And Click the button "Sign In"
		Then Users account dashboard should be visible on the screen
		And Close browser
	
@SignIn	
	Scenario: SignIn With InVaild Credentials	
		Given User is on the URL "https://magento.softwaretestingboard.com/"
		When Click on the link of "Sign In"
		Then SignIn Page should open
		When User enters invalid credentials
		And Click the button "Sign In"
		Then User should see an error message indicating invalid login credentials
		And Close browser
		
@SignIn
  Scenario: Sign In with empty credentials
    Given User is on the URL "https://magento.softwaretestingboard.com/"
		When Click on the link of "Sign In"
		Then SignIn Page should open
    When User leaves the username and password fields empty
    And Click the button "Sign In"
    Then User should see an error message indicating that credentials are required
    And Close browser
		