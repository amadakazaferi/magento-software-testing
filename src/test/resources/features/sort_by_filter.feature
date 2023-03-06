Feature: Check page filters

  @UserLoggedIn @Test7
  Scenario Outline: User sorts products by filter options

    Given the user selects filters from the store menu
      | Women | Tops | Jackets |
    When user click on Sort menu and selects "<option>"
    Then the products are sorted in ascending and descending direction

    Examples:
      | option       |
      | Product Name |
      | Price        |
