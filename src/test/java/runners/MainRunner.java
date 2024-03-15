package runners;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/SignUp.feature"},
        tags = "@regression",
        plugin = {"pretty",
                "json:target/cucumber_json_reports/portal.json",
                "html:target/portal-html/report/report.html"},
        glue = {"infrastructure.driver",
                "stepdefinitions"})

public class MainRunner {

    @BeforeClass
    public static void init() {

    }
//asd

    @AfterClass
    public static void teardown() {
    }
}
