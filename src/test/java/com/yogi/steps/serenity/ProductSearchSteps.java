package com.yogi.steps.serenity;

import com.yogi.pages.HomePage;
import com.yogi.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class ProductSearchSteps {
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Step("^Opening product on estay")
    public void opens_etsy_home_page() {
        // DO something with page obejct;  homePage.open();
        homePage.open();
        //homePage.searchFor("jeans");
    }
    @Step("^Buying product on estay")
    public void searches_for_items_containing(String keywords) {
        homePage.searchFor(keywords);
    }

    @Step("^searches_for_items_from_DropDown")
    public void searches_for_items_from_DropDown(String keywords , String productSection) {
        homePage.searchFromDropDown(keywords , productSection);
    }

    @Step("^Verifying product on estay")
    public void should_see_items_related_to(String keywords) {
        List<String> resultTitles = searchResultsPage.getResultTitles();
        resultTitles
                .stream()
                .forEach(title -> assertThat(title.contains(keywords)));
    }
}
