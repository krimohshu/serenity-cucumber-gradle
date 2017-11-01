@Home_Search
Feature: Home search
  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words


  @home_sr_01=product @hm_sr @search
  Scenario Outline: Alex, a non loggedin user search the product
    Given Alex goto home page
    When he search "<etsyProduct>" product
    Then Product "<etsyProduct>" search result should be displayed
    Examples:
      | etsyProduct  |
      | shirt        |

  @home_sr_02=product @hm_sr @search
  Scenario Outline: Alex, a non loggedin user search the product from dropdown
    Given Alex goto home page
    When he search "<etsyProduct>" product from the "<etsyProductHeader>" drop-down-menu
    Then Product "<etsyProduct>" search result should be displayed
    Examples:
      | etsyProduct  |      etsyProductHeader   |
      | neckless        | Jewellery & Accessories |


  @ui @productsearch @Search @dropdownsearch
  Scenario: Should be able to search for a product from the drop-down menu e.g. Hats & Caps or Belts & Braces
    Given John is viewing the Etsy landing page
    When he selects the first menu item
    And he selects the first link from the drop down menu
    Then the result should have link text

  @ui @productsearch @Search @iconsearch
  Scenario: Should be able to search for a product from the icons e.g. Home & Living
    Given John is viewing the Etsy landing page
    When he selects the Home & Living icon
    Then the result should contain Home & Living

