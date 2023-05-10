Feature: As a user
  I want to add an item to the cart


  Scenario: Cart should have an added item
    Given the user opens Onliner site
    When user clicks on search bar and input "Samsung" request
    And search results are appeared on the screen
    Then user clicks on first result link
    And product page is opened
    Then user clicks on first buy button
    Then cart is opened