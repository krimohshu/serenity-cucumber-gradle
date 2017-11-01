package com.yogi.steps;


import com.yogi.pages.EtsySearchPage;
import com.yogi.task.SearchFor;
import com.yogi.pages.SearchTarget;
import com.yogi.dto.SessionVar;
import com.yogi.steps.serenity.SearchUserSteps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchStepdefs {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUserSteps user;

    EtsySearchPage etsySearchPage;
    Actor theUser = Actor.named("theUser");

    @Given("^Alex navigate to the Etsy home page$")
    public void navigate_On_Home_Page() {
        etsySearchPage.open();
    }

    @Given("^user navigate to Etsy homepage$")
    public void user_got_to_homepage() {
        navigate_On_Home_Page();
    }

    @Given("^([^\\s]+) is viewing the Etsy landing page \\(screenplay\\)$")
    public void goto_landing_page_screenplay(String theUser) {
        theActorCalled(theUser).attemptsTo(Open.browserOn().the(etsySearchPage));
    }

    @When("^he searches for a product ([^\\s]+) from the input box$")
    public void search_from_input_box(String searchKeyword) {
        user.search_from_input_box(searchKeyword);
    }


    @When("^he select \"([^\"]*)\" subcategory in \"([^\"]*)\" category menu$")
    public void he_select_subcategory_in_category_menu(String subCategory, String category) throws Throwable {
        user.choose_item(category , subCategory);
    }

    @When("^he selects product from \"([^\"]*)\" icon search$")
    public void he_selects_product_from_icon_search(String productIconLink) throws Throwable {
        user.selectProductFromIcon(productIconLink);
    }


    @When("^he searches for a product from the input box \\(screenplay\\)$")
    public void search_from_input_box_screenplay() {
        theActorInTheSpotlight().attemptsTo(SearchFor.randomText());
    }

    @Then("^he verify the page title$")
    public void he_verify_the_page_title() throws Throwable {
        user.assertPageTitle();

    }

   /* @Then("^the result should contain (.*)$")
    public void result_should_contain_menu_item(String expectedKeyword) {
        user.verify_search_criteria_in_response(expectedKeyword);
    }*/

    @Then("^Then he can see category (.*)$")
    public void homepage_should_contain_categories(String category) {
        user.verify_categories_on_homepage(category);
    }

    @Then("^the result should have \"([^\"]*)\" link text")
    public void result_should_contain_link_text(String subCategoryLink) {
        user.verify_link_text_in_result_page(subCategoryLink);
    }

    @Then("^the result should be displayed \\(screenplay\\)$")
    public void verify_search_result_screenplay() {
        String searchText = Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the top categories header ", the(SearchTarget.TOP_CATEGORIES_HEADER), containsText(searchText)),
                seeThat("the all categories header ", the(SearchTarget.ALL_CATEGORIES_HEADER), containsText(searchText))
        );
    }

}

