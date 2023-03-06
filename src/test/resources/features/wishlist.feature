@UserLoggedIn @Test4 @CleanWishlist
Feature: Wishlist

  Background:
    Given the user selects filters from the store menu
      |Women | Tops | Jackets |
    When user selects "Black" color in Shopping Options panel
    And user selects price "50-60"

  Scenario Outline: User is able to add items to wishlist

    Given user removes existing price filter
    Then the item number increases
    When user adds <itemNumber> first item in WishList
    Then  items are added successfully
    And the "<itemNumber>" items added are displayed in User Profile

    Examples:
      | itemNumber |
      | 2          |
