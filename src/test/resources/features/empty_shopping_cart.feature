Feature: Empty Shopping Cart

  Background:
    Given the user selects filters from the store menu
      |Women | Tops | Jackets |
    When user selects "Black" color in Shopping Options panel
    And user selects price "50-60"
    When user adds all displayed items in Shopping Cart

 @Test6 @UserLoggedIn
  Scenario: User removes items from shopping cart
    Given user opens Shopping Cart
    When user deletes "1" item from shopping cart
    Then the number of items is decreased by "1" item


#  Precondition: Test 5
#  1. Delete the first item on shopping cart.
#  2. Verify that the number of elements in Shopping Cart table is decreased by 1.
#  3. Repeat steps 1&2 until the last item is deleted.
#  4. Verify that Shopping Cart is empty (Check message ‘You have no items in your
#  shopping cart.’ is displayed).
#  5. Close the browser