package infrastructure.driver;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Setup {

    public static WebDriver driver;


    @Before

    public static void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");

        if (browser == null) {

            browser = "chrome";

        }

        switch (browser) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.setAcceptInsecureCerts(true);

                chromeOptions.addArguments("start-maximized");

                chromeOptions.addArguments("--disable-notifications");

                chromeOptions.addArguments("--remote-allow-origins=*");

                chromeOptions.addArguments("--disable-infobars");

                chromeOptions.addArguments("--no-sandbox");

                chromeOptions.addArguments("--disable-dev-shm-usage");

                chromeOptions.addArguments("use-fake-device-for-media-stream");

                chromeOptions.addArguments("use-fake-ui-for-media-stream");

                driver = new ChromeDriver(chromeOptions);

                break;

            case "firefox":

                driver = new FirefoxDriver();

                driver.manage().window().maximize();

                break;

            default:

                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");

        }

    }

    @After

    public void quitDriver(Scenario scenario) {

        if (scenario.isFailed()) {
            //saveScreenshotsForScenario(scenario);
        }
        driver.quit();

    }


}
