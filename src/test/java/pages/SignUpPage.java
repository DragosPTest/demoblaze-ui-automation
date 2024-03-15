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
    String userNameAlreadyUsed = "Test1234525";

    String previouslyUsedPassword = "UniquePass";
    String password = "sign-password";
    String clickOnSignUpButton = "//*[@onclick='register()']";


    public int generateNumber() {
        return new Random().nextInt(9999);
    }


    public void NavigateToDemoBlazeWebsite() {
        driver.get(websiteUrl);
    }

    public void SignUpButtonMainPageClick() {

        driver.findElement(By.id(signUpButtonMainPage)).click();
    }

    public void InputUserName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserName)).sendKeys(randomUserName);
    }

    public void UserNameAlreadyUsed()throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id(inputUserName)).sendKeys(userNameAlreadyUsed);
    }

    public void InputPassword() {
        driver.findElement(By.id(password)).sendKeys("UniquePass" + generateNumber());

    }

    public void previouslyUsedPassword(){
        driver.findElement(By.id(password)).sendKeys(previouslyUsedPassword);
    }

    public void ClickOnTheSignUpButton() {
        driver.findElement(By.xpath(clickOnSignUpButton)).click();
    }

    public void SignUpMessage() throws InterruptedException {
        Thread.sleep(1000);
        String signUpText = driver.switchTo().alert().getText();
        switch (signUpText) {
            case "Sign up successful.":
                Assert.assertEquals(signUpText, "Sign up successful.");
                break;
            case "This user already exist.":
                Assert.assertEquals(signUpText, "This user already exist.");
                break;
            default:
                Assert.fail("Unexepected message: " + signUpText);
                driver.switchTo().alert().accept();
        }


    }
}