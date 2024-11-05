# Project Overview

This project focuses on automating the testing of the Create Account and Sign In functionalities for the Magento website.

## Create Account Scenarios

The following scenarios are implemented for the Create Account functionality:

- **Scenario: Successful Account Creation**
  - Tests the ability to create a new account with valid details.

- **Scenario: Account Creation with Existing Email**
  - Tests the response when attempting to register with an already registered email address.

- **Scenario: Account Creation with Mismatched Passwords**
  - Tests the response when the password and confirmation password do not match.

- **Scenario: Account Creation with Invalid Email Format**
  - Tests the response when an incorrectly formatted email is provided.

## Sign In Scenarios

The following scenarios are implemented for the Sign In functionality:

- **Scenario: Sign In with Valid Credentials**
  - Tests the ability to successfully sign in with correct user credentials.

- **Scenario: Sign In with Invalid Credentials**
  - Tests the response when an invalid username or password is provided.

- **Scenario: Sign In with Empty Credentials**
  - Tests the response when the username and password fields are left empty.

## Gherkin Syntax

You can view the feature files and their steps written in Gherkin syntax located in the `src/test/resources` directory. 
(Gherkin is a language used to describe software behavior without detailing how that functionality is implemented.)

Each feature file contains scenarios that describe various functionalities in a given context, using keywords such as `Given`, `When`, `Then`, and `And`.

## Changing XPaths

To change and view the XPaths used in the Page Object (PO) pattern, navigate to the `**src/main/java**` directory. Here you will find the implementation of the page objects, where XPaths are defined. This allows you to easily modify the locators used in the automation tests without changing the test logic itself.

## Additional Notes

Ensure that you have the necessary setup and configurations before running the tests. If you need to change any test data, refer to the Constants in the Utilities file. Run the tests from the Test Runner file, executing each as JUnit. Each feature has its own test runner file located in `src/test/java/runnerFile`.
