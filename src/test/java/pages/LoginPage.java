package pages;
import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static infrastructure.driver.Setup.driver;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    String websiteUrl = "https://www.demoblaze.com/index.html";
    String loginButtonMainPage = "login2";
    String loginUserName = "loginusername";
    String loginPassword = "loginpassword";
    String loginButton = "//*[@id=\"logInModal\"]//div[3]/button[2]";
    String nameOfUser = "nameofuser";



    public void navigateToDemoBlazeWebsite(){
        driver.get(websiteUrl);
    }

    public void clickOnLoginButtonMainPage()throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id(loginButtonMainPage)).click();
    }

    public void inputUserName(String existingUser) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id(loginUserName)).sendKeys(existingUser);
    }

    public void inputPassword(String existingPassword){
        driver.findElement(By.id(loginPassword)).sendKeys(existingPassword);
    }

    public void clickOnLoginButton(){
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void successfullyLoggedIn(String welcomeMessageLogin) throws InterruptedException{
        Thread.sleep(2000);
        String welcomeMessage = driver.findElement(By.id(nameOfUser)).getText();
        Assert.assertEquals(welcomeMessage, welcomeMessageLogin);
    }
}
