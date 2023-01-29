Feature: Testing scenarios for smart bear application
  @SanityTest
  Scenario: Smartbear login
    Given user on the login page
    When user enter username as "Tester" and password as "test"
    Then user is loggedin

    @SanityTest
      Scenario: Check View all Orders
      Given User is on the View all orders page
      When user views the title as "List of All Orders"
      Then view all order page load successfully

      @SanityTest
      Scenario: users creating new order
        Given user on the order page
        When user entered all information
        |Product | FamilyAlbum |
        |Quantity |10          |
        |Customer name | recep   |
        |Street       |1905 22nd rd|
        |City         |Astoria     |
        |State        |new york    |
        |Zip          |11105       |
        |Card         |visa        |
        |Card Nr    |0123456789    |
        |Expire date (mm/yy)| 01/01|
        Then user order is successfully



        @Temp
        Scenario: Login with page object model
          Given user wants to enter username
          Then user wants to enter password


          @Temp2
          Scenario: verify that complete order
            Given user wants to enter username
            Then user wants to enter password
            Then user wants to go to order page
            And user vants to enter prodact information
              |Product | FamilyAlbum |
              |Quantity |10          |
              And user vants to enter adress information
              |Customer name | recep   |
              |Street       |1905 22nd rd|
              |City         |Astoria     |
              |State        |new york    |
              |Zip          |11105       |
              And user vant to enter payment information
              |Card         |visa        |
              |Card Nr    |0123456789    |
              |expire date| 01/01|

Scenario Outline:
  Given user wants to enter username
  Then user wants to enter password
  Then user wants to go to order page
  Then user vants to enter prodact information as "<productInfo>"
  And user vant to enter payment information as "<Card>" and "<Card Nr>" and "<expire date>"

  Examples:
  |productInfo|Card|Card Nr|expire date|
  |MyMoney    |visa|0123456789|01/01   |
  |FamilyAlbum|visa|0123413455|03/09   |
  |ScreenSaver|visa|1223474758|08/14   |


