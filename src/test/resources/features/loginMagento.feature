Feature:

  Scenario: User Signs In and Signs Out of Existing Account
    Given a user is navigating the Magento app
    When user clicks on link to "Sign In"
    And user sign in with credentials
    Then the username is displayed right
    And user sign out
#  1. Navigate to: https://magento.softwaretestingboard.com/.
#  2. Click on Sign In link.
#  3. Login with the credentials created from Test 1.
#  4. Check your username is displayed on right corner of the page.
#  5. Click on User profile and Sign Out.