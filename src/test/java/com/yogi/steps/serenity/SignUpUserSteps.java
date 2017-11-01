package com.yogi.steps.serenity;


import com.yogi.dto.SignUpUserDTO;
import com.yogi.pages.SignUpPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpUserSteps extends ScenarioSteps {

    SignUpPage signUpPage;
    private SignUpUserDTO signUpUserDTO;
    @Step
    public void signUp() {
        signUpUserDTO =  signUpPage.signUp();
    }
    @Step
    public void signUp(List<String> userDetails) {
        SignUpUserDTO signUpUser = new SignUpUserDTO(userDetails.get(0) , userDetails.get(1) ,userDetails.get(2) );
        signUpUser.setEmail(userDetails.get(1));
        signUpUserDTO =  signUpPage.signUp(signUpUser);
    }

    @Step
    public void verify_registration_complete() {
        assertThat(signUpPage.verifyConfirmEmailText(), containsString(signUpUserDTO.getEmail().toLowerCase()));
    }
}
