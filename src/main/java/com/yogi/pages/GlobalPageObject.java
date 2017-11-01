package com.yogi.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalPageObject extends PageObject{
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalPageObject.class);

    /**
     * @param id      the id selector with _id_VALUE_ placeholder
     * @param idValue to replace the _id_VALUE_ placeholder
     * @return the final id By
     */
    public By getIdReplacingIdValue(final By id, final String idValue) {
        return By.id(id.toString().replace("By.id: ", "").replace("_ID_VALUE_", idValue));
    }
    protected  void scrollToElement(WebElement element){
        int elementPosition = element.getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        ((JavascriptExecutor) getDriver() ).executeScript(js);
    }
}
