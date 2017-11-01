package com.yogi.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class EtsySearchPage extends PageObject {

    public static String subCategoryLink = "";
    GlobalPageObject globalPageObject;

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".gnav-search-inner button[type='submit']")
    WebElementFacade searchButton;

    @FindBy(css = ".top-nav-item")
    List<WebElement> primaryLinksLocator;

    @FindBy(css = ".catnav-subcategories")
    List<WebElement> subCategoryLocator;

    @FindBy(css = "#content .vesta-hp-category-default .block-grid-xs-1 a")
    List<WebElement> allIconLinks;

    public EtsySearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public void selectItem(final String primaryProduct , final String subCategory) {
        subCategoryLocator.stream().forEach(t-> System.out.println(t.getText()));

        primaryLinksLocator.stream()
                .filter(s -> s.getText().equalsIgnoreCase(primaryProduct))
                .findFirst()
                .ifPresent(primaryProductCategory ->{
                    primaryProductCategory.click();
                    subCategoryLink = subCategory;
                    selectSubCategoryFromDropDown(subCategoryLink);});
    }

    public void searchProductByIcon(String productIconTitle){
      //  allIconLinks.stream().forEach(t->System.out.println(t));

        allIconLinks.stream()
                .filter(product -> product.getText().equalsIgnoreCase(productIconTitle))
                .findFirst()
                .ifPresent(productIcon -> {
               //     new GlobalPageObject().scrollToElement(productIcon);
                    productIcon.click();
                });
    }


    public void selectSubCategoryFromDropDown(final String subCategory) {
        getDriver().findElement(By.linkText(subCategory)).click();
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("div.ui-toolkit.cat-nav")).getText().toLowerCase();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline.text-smaller")).getText();
    }

    public String getResultHeader() {
        return find(By.cssSelector(".float-left h1")).getText();
    }

}
