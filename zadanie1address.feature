Feature: Zadanie 1

  Scenario: Successful search
    Given Browser with open page at address https://mystore-testlab.coderslab.pl
    When Log in as an existing user
    And Address clicked
    And Create New Address
    And Alias <Alias>
    And Address added <Address>
    And City added <City>
    And Postal Code <PostalCode>
    And Phone <Phone>
    And Country
    And Save
    Then Checking if address has been saved
    Examples:
    |Alias |Address     | City    | PostalCode | Phone    |
    |Test1 |Sunrise 2   | London  |02-299      |123654789|