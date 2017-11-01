package com.yogi.steps.serenity;

import com.yogi.pages.HomePage;
import com.yogi.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class BuyerSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Step("^Opening product on estay")
    public void opens_etsy_home_page() {
        homePage.open();

    }

    @Step("^Buying product on estay")
    public void searches_for_items_containing(String keywords) {
        homePage.searchFor(keywords);
    }

    @Step("^Verifying product on estay")
    public void should_see_items_related_to(String keywords) {
        List<String> resultTitles = searchResultsPage.getResultTitles();
     //   resultTitles.stream().forEach(title -> assertThat(title.contains(keywords)));
    }
}
