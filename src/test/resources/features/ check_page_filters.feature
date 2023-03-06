Feature: Store Menu Page filters

  @UserLoggedIn @Test3
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