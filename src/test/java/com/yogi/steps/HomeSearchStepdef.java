package com.yogi.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.yogi.steps.serenity.ProductSearchSteps;

public class HomeSearchStepdef {

    @Steps
    ProductSearchSteps productSearchSteps;

    @Given("^Alex goto home page$")
    public void goToHomePagef() throws Throwable {
        productSearchSteps.opens_etsy_home_page();
    }
    @When("^he search \"([^\"]*)\" product$")
    public void searchProduct(String keyword) throws Throwable {
        productSearchSteps.searches_for_items_containing(keyword);
    }
    @When("^he search \"([^\"]*)\" product from the \"([^\"]*)\" drop-down-menu$")
    public void searchProductFromDropDown(String keyword , String productSection) throws Throwable {
       // productSearchSteps.searches_for_items_containing(keyword);
        productSearchSteps.searches_for_items_from_DropDown(keyword , productSection);
    }


    @Then("^Product \"([^\"]*)\" search result should be displayed$")
    public void searchResult(String keyword) throws Throwable {
        productSearchSteps.should_see_items_related_to(keyword);

    }
}
