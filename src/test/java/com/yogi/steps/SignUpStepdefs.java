package com.yogi.steps;


import com.yogi.steps.serenity.SignUpUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SignUpStepdefs {
    @Steps
    SignUpUserSteps user;

    @When("^he fill random signup details$")
    public void registerUser() {
        user.signUp();
    }
    @When("^he fill following signup details$")
    public void he_fill_following_signup_details(List<String> userDetails) throws Throwable {

        user.signUp(userDetails);
    }

  @Then("^he verify confirmation message$")
    public void checkUserRegistered() {
        user.verify_registration_complete();
    }
}