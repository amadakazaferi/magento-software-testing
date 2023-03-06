Feature: User login in Magento APP

  Scenario: User Signs In and Signs Out of Existing Account
    Given a user is navigating the Magento app
    When user clicks on link to "Sign In"
    And user sign in with credentials
    Then the username is displayed right
    And user sign out