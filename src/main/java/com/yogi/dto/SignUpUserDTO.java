package com.yogi.dto;

import com.yogi.Utils.RandomUtil;

public class SignUpUserDTO {

    private String username;
    private String email;
    private String password;

    public SignUpUserDTO() {
        this.username = RandomUtil.randomCharacterString(15);
        this.email = RandomUtil.randomEmail();
        this.password = RandomUtil.randomCharacterString(4) + RandomUtil.randomInt(1000, 50000);;
    }

    public SignUpUserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email + RandomUtil.randomEmail();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
