package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/SignUp.feature", "src/test/resources/Login.feature", "src/test/resources/Contact.feature", "src/test/resources/Cart.feature"},
        tags = "@Test",
        plugin = {"pretty",
                "json:target/cucumber_json_reports/portal.json",
                "html:target/portal-html/report/report.html"},
        glue = {"infrastructure.driver",
                "stepdefinitions"})

public class MainRunner {

    @BeforeClass
    public static void init() {

    }


    @AfterClass
    public static void teardown() {
    }
}
