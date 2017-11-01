package com.yogi.steps;

import com.yogi.SerenityRestClient;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


import java.util.List;
import java.util.Map;

public class LandingPageApiStepdefs {



    @Steps
    private SerenityRestClient serenityRestClient;

    @When("^Alex GET home page api$")
    public void home_page_api() {
        serenityRestClient.sendBuiltRequest();
    }

    @When("^he search for (.*) product$")
    public void product_search_from_searchbox(String searchCriteria) {
        serenityRestClient.editBoxSearch(searchCriteria);
    }

    @Then("^User (.*) verify following product API from dropdown$")
    public void user_verify_following_product_from_dropdown(final String expectedStatusCode, Map<String, String> productCatalogue) throws Throwable {
        productCatalogue
               .entrySet()
               .stream()
               .forEach(products ->serenityRestClient.getApiProductsOfDropDown(products.getKey() ,products.getValue() , expectedStatusCode));

    }

    @Then("^Response body should have following product$")
    public void response_body_should_have_following_product(List<String> productName) {

        productName.stream().forEach(product -> {
            serenityRestClient.verifySearchResults(product);
        });
    }

    @Then("^(\\d+) should be api response code$")
    public void api_response_status_code_verification(int code) {
        serenityRestClient.verifyStatusCode(code);
    }

}