Feature: Automation Practice website Testing
  @SmokeTest
  Scenario Outline: Search for an item
    Given user is on the home page
    When user enter <item> in the search box and clicks search button
    Then search results are displayed to the user <item>

    Examples:
    | item   |
    | SHIRT |
    | DRESS |

    @SmokeTest
    Scenario: add item to cart
      Given results are displayed to the user
      When user click on the search button and enters details
      Then user can add them to the cart

      @SmokeTest
      Scenario: Search for items - datatables
        Given user is on the home page
        When user enters details to search
        |SHIRT|
        Then results are displayed based on his search
        |SHIRT|

        @SmokeTest
        Scenario: User contact costumer services
          Given user is on contact us page
          When user add all information on the page
          |Customer service|a@bgmail.com|123456|hello|
          Then user send all information
