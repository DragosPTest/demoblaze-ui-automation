package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    private String loginButtonMainPageElement = "login2";
    private String loginUserNameElement = "loginusername";
    private String loginPasswordElement = "loginpassword";
    private String loginButtonElement = "//*[@id=\"logInModal\"]//div[3]/button[2]";
    private String nameOfUserElement = "nameofuser";

    public void clickOnLoginButtonMainPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(loginButtonMainPageElement)).click();
    }

    public void inputCorrectUserName(String correctUserName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(loginUserNameElement)).sendKeys(correctUserName);
    }

    public void emptyUserName() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(loginUserNameElement)).sendKeys("");
    }

    public void inputIncorrectUserName(String incorrectUserName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(loginUserNameElement)).sendKeys(incorrectUserName);
    }

    public void inputCorrectPassword(String correctPassword) {
        driver.findElement(By.id(loginPasswordElement)).sendKeys(correctPassword);
    }

    public void inputIncorrectPassword(String incorrectPasssword) {
        driver.findElement(By.id(loginPasswordElement)).sendKeys(incorrectPasssword);
    }

    public void emptyPassword() {
        driver.findElement(By.id(loginUserNameElement)).sendKeys("");
    }


    public void clickOnLoginButton() {
        driver.findElement(By.xpath(loginButtonElement)).click();
    }

    public void loginMessage(String loginMessage) throws InterruptedException {
        Thread.sleep(2000);
        try {
            Alert alert = driver.switchTo().alert();
            String loginFailureMessage = alert.getText();
            Assert.assertEquals(loginFailureMessage, loginMessage);
            alert.accept();
        } catch (NoAlertPresentException e) {
            String loginSuccessMessage = driver.findElement(By.id(nameOfUserElement)).getText();
            Assert.assertEquals(loginMessage, loginSuccessMessage);
        }

    }


}
