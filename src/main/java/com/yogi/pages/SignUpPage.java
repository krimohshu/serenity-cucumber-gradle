package com.yogi.pages;


import com.yogi.dto.SignUpUserDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SignUpPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpPage.class);

    @FindBy(id = "register")
    WebElementFacade signup_button;
    @FindBy(id = "first-name")
    WebElementFacade first_name;
    @FindBy(id = "email")
    WebElementFacade email;
    @FindBy(id = "password")
    WebElementFacade password;
    @FindBy(id = "password-repeat")
    WebElementFacade confirm_password;
    @FindBy(id = "register_button")
    WebElementFacade register;
    @FindBy(css= ".confirm-email-notice p")
    WebElementFacade signUpConfirmLabel;
    @FindBy(css= ".confirm-email-notice p strong")
    WebElementFacade signUpConfirmEmail;
    @FindBy(css=".recaptcha-checkbox-checkmark")
    WebElementFacade uicaptcha;

       public SignUpUserDTO signUp(SignUpUserDTO signUpUserDTO){
        try {
            signup_button.click();
            first_name.sendKeys(signUpUserDTO.getUsername());
            email.sendKeys(signUpUserDTO.getEmail());
            password.sendKeys(signUpUserDTO.getPassword());
            confirm_password.sendKeys(signUpUserDTO.getPassword());
            performCaptcha();
            register.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return signUpUserDTO;
    }

    public SignUpUserDTO signUp(){
        return this.signUp(new SignUpUserDTO());
    }

    public void performCaptcha(){
        if(uicaptcha.isPresent()){
            uicaptcha.click();
        }
    }
    public String verifyConfirmEmailText() {

        /*System.out.println(signUpConfirmEmail.getText());
        System.out.println(signUpConfirmLabel.getText());*/

        return signUpConfirmLabel.getText().toLowerCase();

    }








}
