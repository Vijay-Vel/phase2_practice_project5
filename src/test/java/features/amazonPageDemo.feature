@all
Feature: to test the amazon page on chrome browser

  Background: 
    Given the User is on the amazon home page

@login
  Scenario Outline: to test the sign in page
    Then the User hover and clicks on the sign in button on the amazon page
    When the User enter email as '<EmailId>' on the amazon page
    When the User enter password as '<password>' on the amazon page
    And the User clicks on the sign in button on the amazon page
    Then the User captures the error message on the amazon page
    And the User close the amazon page and browser

    Examples: 
      | EmailId         | password |
      | vijay@gmail.com |     1234 |

@search
  Scenario: to test search page
    Then the user hover mobiles and click on apple
    Then the user click on the searched item
    And the user click on add to cart
    And the User close the amazon page and browser