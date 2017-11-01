@Home_Search
Feature: Product search via api

  @test @api @productsearch @paramwithspace
  Scenario: Search for Caps through API
    Given John is a Etsy customer
    When he makes a GET request to landing page
    Then api should return response code 200
    When he makes a search for keyword CHILD HAT
    Then api should return response code 200
    And system should return below values in the result
      | Shark Hat |
      | Baby Hat  |

  @test @api @productsearch @singleparam
  Scenario: Search for Caps through API
    Given John is a Etsy customer
    When he makes a GET request to landing page
    Then api should return response code 200
    When he makes a search for keyword shoe shine
    Then api should return response code 200
    And system should return below values in the result
      |Necktie |
      |Vintage |
