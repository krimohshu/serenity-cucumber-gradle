package com.yogi;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features="src/test/resources/features"
    //  , dryRun = true
       // ,tags ={"@api , @specificsearch , @signup "}
        ,tags ={"@ui"}
        )
public class AcceptanceTest {
/*

        @Managed
        WebDriver driver;
*/

}
