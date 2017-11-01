package com.yogi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String name;
    private String code;
    private String localizationLang;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocalizationLang() {
        return localizationLang;
    }

    public void setLocalizationLang(String localizationLang) {
        this.localizationLang = localizationLang;
    }
}
