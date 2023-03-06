Feature: User Creates a New Account in Magento APP

  Scenario Outline:  Create an Account
    Given a user is navigating the Magento app
    When  user clicks on link to "Create Account"
    Then  the page "<title>" is opened
    When  user fills the form and creates the account
    Then  the account is successfully  created
    And   user sign out
    Examples:
      | title                       |
      | Create New Customer Account |

