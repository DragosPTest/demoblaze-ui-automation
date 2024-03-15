package infrastructure.driver;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class TearDown {

    private WebDriver driver;
    public TearDown()
    {
        this.driver = Setup.driver;
    }


//    @After
//    public void quitDriver(Scenario scenario){
//        if(scenario.isFailed()){
// //          saveScreenshotsForScenario(scenario);
//        }
//        this.driver.quit();
//    }


    @After
    public void doAfterEachScenario(){
        //StuffToDoAfterEachScenario
    }
}
