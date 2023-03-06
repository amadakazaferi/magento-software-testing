Feature:Shopping cart
  Background:
    Given the user selects filters from the store menu
      |Women | Tops | Jackets |
    When user selects "Black" color in Shopping Options panel
    And user selects price "50-60"

  @Test5  @UserLoggedIn
  Scenario Outline: User adds item to shopping cart
  When user adds all displayed items in Shopping Cart
  Then items are successfully added
  When user opens Shopping Cart
    Then  the page "<title>" is opened
  And  sum of all items price equals Total price

    Examples:
      | title                       |
      | Shopping Cart |


#  Precondition: Test 3
#  1. Add all displayed items to the Shopping Cart (Select one of the size options +
#  hover over item and click Add to Cart button).
#  2. Check successful message (text + icon).
#  3. Open the Shopping Cart (by clicking shopping cart link included on the
#  successful message).
#  4. Verify that we have navigated to Shopping Cart Page.
#  5. Verify that the prices sum for all items is equal to Order Total price in the
#  Summary section.