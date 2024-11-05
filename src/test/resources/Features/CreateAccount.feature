Feature: User Create Account

@CreateAccount
  Scenario: Successful account creation
    Given User is on URL "https://magento.softwaretestingboard.com/"
    And Click on the Create Account link "Create an Account"
    Then Create Account Page should open
    When User enter valid details
    And Click on the button "Create An Account"
    Then User should see a success message indicating successful login 
    And Close the browser
   
@CreateAccount
  Scenario: Account creation with an existing email
    Given User is on URL "https://magento.softwaretestingboard.com/"
    And Click on the Create Account link "Create an Account"
    Then Create Account Page should open
    When User enter details with an already registered email 
    And Click on the button "Create Account"
    Then User should see an error message indicating the email is already in use
    And Close the browser
    
@CreateAccount
  Scenario: Account creation with mismatched password and confirmation
    Given User is on URL "https://magento.softwaretestingboard.com/"
    And Click on the Create Account link "Create an Account"
    Then Create Account Page should open
    When User enters a password and a different confirmation password
    And Click on the button "Create An Account"
    Then User should see an error message indicating that the passwords do not match
    And Close the browser

@CreateAccount
  Scenario: Account creation with an invalid email format
    Given User is on URL "https://magento.softwaretestingboard.com/"
    And Click on the Create Account link "Create an Account"
    Then Create Account Page should open
    When User enters an email in an incorrect format
    And Click on the button "Create An Account"
    Then User should see an error message indicating that the email format is invalid
    And Close the browser

    