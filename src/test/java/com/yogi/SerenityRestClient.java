package com.yogi;


import com.yogi.Utils.JsonToObject;
import com.yogi.dto.Catlogue;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class SerenityRestClient {

   EnvironmentVariables prop = SystemEnvironmentVariables.createEnvironmentVariables();
   String etsyBaseURL = prop.getProperty("ETSY_BASE_URL");
    public static Response response;

    public  void setRequestURL(String url) {
        etsyBaseURL = url;
    }

        /*GET Request creation  */
    public void getApiProductsOfDropDown(String category , String subCategory , String expectedStatusCode){
        List<Catlogue> allProducts = new JsonToObject<Catlogue>()
                                          .getObjects(new Catlogue());

        Optional<Catlogue> catlogue = allProducts
                                        .stream()
                                        .filter(t-> t.getCategory().equalsIgnoreCase(category))
                                        .findFirst();

        setRequestURL(etsyBaseURL + "/uk/c/" + category + "/" + subCategory + "?ref=catnav-" + catlogue.get().getCategoryKey());
        sendBuiltRequest();
        verifyStatusCode(Integer.valueOf(expectedStatusCode.equalsIgnoreCase("successfully") ? 200 : 500));
    }

    public  void editBoxSearch(String searchKeyword){
        setRequestURL(etsyBaseURL + "/uk/search?q=" + searchKeyword);
        sendBuiltRequest();
    }

        /*Builder GET request */
    public  void sendBuiltRequest() {
        response = SerenityRest.given().contentType("application/xml").log().all().get(etsyBaseURL);
    }

    /*Verification */
    public  void verifyStatusCode(int statusCode) {
        System.out.println("aha! " + SerenityRest.then().extract().statusCode());
        assertThat(SerenityRest.then().extract().statusCode(), equalTo(statusCode));
    }

    public  void verifySearchResults(String result){
       assertTrue("API Mismatch Result= '" + result + "' with response ", response.asString().contains(result));
      //  assertTrue("ApiSearch Result= '" + result + "' Mismatch with Actual api response ", SerenityRest.then().extract().body().xmlPath("results.geometry.location.lng[0]"));
    }

}

