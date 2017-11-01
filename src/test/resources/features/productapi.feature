@Home_Search
Feature: Serenity Rest Assured API test

  @api @productsearch @restapi
  Scenario: Product search via drop down api
    #When Alex GET home page api
    Then User successfully verify following product API from dropdown
      |home-and-living | bathroom |
      |accessories | hair-accessories |
#Endpoints->  #https://www.etsy.com/uk/c/home-and-living/bathroom?ref=catnav-891  ;httpMethod=GET
#https://www.etsy.com/uk/c/accessories/hair-accessories?ref=catnav-10855    ; httpMethod=GET

  @api @productsearch @restapi
  Scenario: Product search via search box api
    When Alex GET home page api
    And he search for shoe shine product
    Then 200 should be api response code
    And Response body should have following product
      |Necktie |
      |Vintage |

    #Endpoints-> https://www.etsy.com/uk/search?q=shirt+button   httpMethod=GET

