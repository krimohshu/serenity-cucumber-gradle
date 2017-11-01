@Home_Search
Feature: Home search
  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

  @ui @productsearch @Search @dropdownsearch @specificsearch
  Scenario Outline: Search product from the drop-down menu
    Given Alex navigate to the Etsy home page
    Then he verify the page title
    When he select "<primaryProductSubCategory>" subcategory in "<primaryProductCategory>" category menu
    Then the result should have "<primaryProductSubCategory>" link text
    Examples:
      | primaryProductCategory  |      primaryProductSubCategory   |
      | Jewellery & Accessories        | Scarves & Wraps  |
      | Jewellery & Accessories        | Hats & Caps  |
      | Jewellery & Accessories        | Keychains & Lanyards  |


  @ui @productsearch @Search @iconsearch @specificsearch
  Scenario Outline: Search product from the icons
    Given Alex navigate to the Etsy home page
    When he selects product from "<iconLink>" icon search
    Then the result should have "<verifySearchText>" link text
   # the result should contain "<verifySearchText>"
    Examples:
      | iconLink                 |  verifySearchText     |
      | Home & Living            | Home & Living         |
      | Jewellery                | Jewellery             |
      | Craft Supplies & Tools   | Craft Supplies & Tools|

