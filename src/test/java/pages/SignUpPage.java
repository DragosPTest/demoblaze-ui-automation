package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class SignUpPage extends BasePage {
    private String randomUserName;

    public SignUpPage() {
        PageFactory.initElements(driver, this);
        this.randomUserName = "JohnDoe" + generateNumber();
    }

    String websiteUrl = "https://www.demoblaze.com/index.html";
    String signUpButtonMainPage = "signin2";
    String inputUserName = "sign-username";
    String password = "sign-password";
    String userNameAlreadyUsed = "Test1234525";
    String previouslyUsedPassword = "UniquePass";
    String clickOnSignUpButton = "//*[@onclick='register()']";

    public int generateNumber() {
        return new Random().nextInt(9999);
    }


    public void navigateToDemoBlazeWebsite() {
        driver.get(websiteUrl);
    }

    public void signUpButtonMainPageClick() {

        driver.findElement(By.id(signUpButtonMainPage)).click();
    }

    public void inputUserName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserName)).sendKeys(randomUserName);
    }

    public void userNameAlreadyUsed() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserName)).sendKeys(userNameAlreadyUsed);
    }

    public void emptyUserName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserName)).sendKeys("");
    }

    public void inputPassword() {
        driver.findElement(By.id(password)).sendKeys("UniquePass" + generateNumber());

    }

    public void previouslyUsedPassword() {
        driver.findElement(By.id(password)).sendKeys(previouslyUsedPassword);
    }

    public void emptyPassword() {
        driver.findElement(By.id(password)).sendKeys("");
    }

    public void clickOnTheSignUpButton() {
        driver.findElement(By.xpath(clickOnSignUpButton)).click();
    }

    public void signUpMessage() throws InterruptedException {
        Thread.sleep(1000);
        String signUpText = driver.switchTo().alert().getText();
        switch (signUpText) {
            case "Sign up successful.":
                Assert.assertEquals(signUpText, "Sign up successful.");
                break;
            case "This user already exist.":
                Assert.assertEquals(signUpText, "This user already exist.");
                break;
            case "Please fill out Username and Password.":
                Assert.assertEquals(signUpText, "Please fill out Username and Password.");
                break;
            default:
                Assert.fail("Unexepected message: " + signUpText);
                driver.switchTo().alert().accept();
        }

    }


}