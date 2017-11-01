@Authorization @login @registration
Feature: Signup user

  @signup @smoke @p0 @userinputsignup
  Scenario: Register a new user for ETSY website
    Given user navigate to Etsy homepage
    When he fill following signup details
      |alex | createrandomemail | mypassword123|
    Then he verify confirmation message

  @signup @smoke @p0
  Scenario: Register a new user for ETSY website
    Given user navigate to Etsy homepage
    When he fill random signup details
    Then he verify confirmation message



