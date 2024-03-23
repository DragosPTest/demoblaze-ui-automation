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

    String websiteUrl = "https://www.demoblaze.com/index.html";
    String loginButtonMainPage = "login2";
    String loginUserName = "loginusername";
    String loginPassword = "loginpassword";
    String loginButton = "//*[@id=\"logInModal\"]//div[3]/button[2]";
    String nameOfUser = "nameofuser";


    public void navigateToDemoBlazeWebsite() {
        driver.get(websiteUrl);
    }

    public void clickOnLoginButtonMainPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(loginButtonMainPage)).click();
    }

    public void inputCorrectUserName(String correctUserName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(loginUserName)).sendKeys(correctUserName);
    }

    public void inputIncorrectUserName(String incorrectUserName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id(loginUserName)).sendKeys(incorrectUserName);
    }

    public void inputCorrectPassword(String correctPassword) {
        driver.findElement(By.id(loginPassword)).sendKeys(correctPassword);
    }

    public void inputIncorrectPassword(String incorrectPasssword) {
        driver.findElement(By.id(loginPassword)).sendKeys(incorrectPasssword);
    }


    public void clickOnLoginButton() {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void loginMessage(String loginMessage) throws InterruptedException {
        Thread.sleep(2000);
        try {
            Alert alert = driver.switchTo().alert();
            String loginFailureMessage = alert.getText();
            Assert.assertEquals(loginFailureMessage, loginMessage);
            alert.accept();
        } catch (NoAlertPresentException e) {
            String loginSuccessMessage = driver.findElement(By.id(nameOfUser)).getText();
            Assert.assertEquals(loginMessage, loginSuccessMessage);
        }
    }


}
