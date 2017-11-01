package com.yogi.pages;


import com.yogi.pagecommands.HomePageCommands;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DefaultUrl("http://www.etsy.com")
public class HomePage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    GlobalPageObject globalPageObject;

    public final static By INPUT_SEARCH = By.id("search-query");
    public final static By SELECT_MAINPRODUCT_CAT = By.id("catnav-primary-link-_ID_VALUE_");
    public final static By SELECT_All_MAINPRODUCT_CAT = By.xpath("//*[@id=\"catnav-primary-link-\"]");
//    public final static By SELECT_All_MAINPRODUCT_CAT = By.xpath("//*[@id=\"side-nav-category-link-\"]");


    @FindBy(css = "button[value='Search']")
    WebElement searchButton;

    @FindBy(id = "search-query")
    WebElement searchInputField;

   /* @FindBy(id = "search-query")
    side-nav-category-link-10873
*/

    public void searchFor(String keywords) {
         find(INPUT_SEARCH).clear();
         find(INPUT_SEARCH).sendKeys(keywords);
      //  $("#search-query").sendKeys(keywords);
        searchButton.click();
    }

    public void  searchFromDropDown(String keywords , String productSection){

       //find(globalPageObject.getIdReplacingIdValue(SELECT_MAINPRODUCT_CAT , productSection));

        List<WebElement> topProductHeader = getDriver().findElements(SELECT_All_MAINPRODUCT_CAT);
        topProductHeader.stream().forEach(System.out::println);

    }

    public HomePage(){
        new HomePageCommands();
    }
   /* public HomePage(String commandName, String PageName){
        new HomePageCommands();
    }
*/

}