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

    private String websiteUrl = "https://www.demoblaze.com/index.html";
    private String signUpButtonMainPageElement = "signin2";
    private String inputUserNameElement = "sign-username";
    private String passwordElement = "sign-password";
    private String userNameAlreadyUsed = "Test1234525";
    private String previouslyUsedPassword = "UniquePass";
    private String clickOnSignUpButtonElement = "//*[@onclick='register()']";

    public int generateNumber() {
        return new Random().nextInt(9999);
    }


    public void navigateToDemoBlazeWebsite() {
        driver.get(websiteUrl);
    }

    public void signUpButtonMainPageClick() {

        driver.findElement(By.id(signUpButtonMainPageElement)).click();
    }

    public void inputUserName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserNameElement)).sendKeys(randomUserName);
    }

    public void userNameAlreadyUsed() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserNameElement)).sendKeys(userNameAlreadyUsed);
    }

    public void emptyUserName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserNameElement)).sendKeys("");
    }

    public void inputPassword() {
        driver.findElement(By.id(passwordElement)).sendKeys("UniquePass" + generateNumber());

    }

    public void previouslyUsedPassword() {
        driver.findElement(By.id(passwordElement)).sendKeys(previouslyUsedPassword);
    }

    public void emptyPassword() {
        driver.findElement(By.id(passwordElement)).sendKeys("");
    }

    public void clickOnTheSignUpButton() {
        driver.findElement(By.xpath(clickOnSignUpButtonElement)).click();
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