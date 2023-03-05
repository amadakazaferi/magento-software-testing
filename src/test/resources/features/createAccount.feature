Feature: User Creates a New Account in Magento APP

  Scenario Outline:  Create an Account
    Given a user is navigating the Magento app
    When  user clicks on link to "Create Account"
    Then  the page "<title>" is opened
    When  user fills the form and creates the account
    Then  the account is successfully  created
    And   user sign out
Examples:
  |title|
  |Create New Customer Account|

#  1. Navigate to: https://magento.softwaretestingboard.com/.
#  2. Click Create an Account link.
#  3. Check title of the open page.
#  4. Fill in form fields.
#  5. Click Create an Account button.
#  6. Check successful message is displayed on the screen (text + icon).
#  7. Click on User profile and Sign Out.

