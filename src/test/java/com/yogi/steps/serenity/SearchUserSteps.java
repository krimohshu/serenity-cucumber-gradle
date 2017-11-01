package com.yogi.steps.serenity;


import com.yogi.pages.EtsySearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUserSteps extends ScenarioSteps {

    EtsySearchPage etsySearchPage;

    public static final String PAGE_TITLE = "Etsy.com | Shop for anything from creative people everywhere";

    @Step
    public void search_from_input_box(String searchKeyword) {
        etsySearchPage.searchFromInputBox(searchKeyword);
    }


    @Step
    public void choose_item(String category ,String subCategory) {
        etsySearchPage.selectItem(category , subCategory);
    }
    @Step
    public void selectProductFromIcon(String productIconTitle){
        etsySearchPage.searchProductByIcon(productIconTitle);

    }


    @Step
    public void assertPageTitle() {
        assertThat(etsySearchPage.getTitle(), containsString(PAGE_TITLE));
    }

    @Step
    public void verify_search_keyword_in_result_page(String searchText) {
        assertThat(etsySearchPage.getResultHeader(), containsString("\"" +searchText + "\""));
    }


    @Step
    public void verify_categories_on_homepage(String category) {
        assertThat(etsySearchPage.getAllCategoriesHeader(), containsString(category));
    }

    @Step
    public void verify_link_text_in_result_page(String subCategoryLink) {
        assertThat(etsySearchPage.getResultHeader(), containsString(subCategoryLink));

    }

}


