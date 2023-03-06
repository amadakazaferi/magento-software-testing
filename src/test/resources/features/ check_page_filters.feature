Feature: Store Menu Page filters

  @UserLoggedIn
  Scenario Outline: User checks page filters

  Given the user selects filters from the store menu
  |Women | Tops | Jackets |
  When user selects "<color>" color in Shopping Options panel
  Then all the displayed products have the selected "<color>" bordered in red
  When user selects price "<range>"
  Then products displayed match the price "<range>" criteria

  Examples:
  |color| range |
  |Black| 50-60 |
#  Precondition: Sign in Luma Application
#  1. On store menu click on Women dropdown.
#  2. Hover over Tops dropdown on the open pop up and click on Jacket menu option.
#  3. From Shopping Options panel click on Color dropdown and choose one of the
#  colors.
#  4. Check that all the displayed products have the selected color bordered in red.
#  5. Click on Price dropdown and select the first option ($50.00 - $59.99) and check
#  that only two products are displayed on the page.
#  6. For each product displayed, check that the price matches the defined criteria.