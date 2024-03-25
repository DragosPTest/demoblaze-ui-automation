package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class ContactPage extends BasePage {
    public ContactPage() {
        PageFactory.initElements(driver, this);
    }

    private String contactButtonElement = "//*[@id=\"navbarExample\"]/ul/li[2]/a";
    private String contactPopUpFormElement = "exampleModalLabel";
    private String recipientEmailElement = "recipient-email";
    private String recipientnameElement = "recipient-name";
    private String messageTextElement = "message-text";
    private String sendMessageButtonElement = "//*[@id=\"exampleModal\"]//button[2]";

    public int generateNumber() {
        return new Random().nextInt(9999);
    }

    public void clickOnContactButton() {
        driver.findElement(By.xpath(contactButtonElement)).click();
    }

    public void contactPopUpForm() throws InterruptedException {
        Thread.sleep(1000);
        String newMessage = driver.findElement(By.id(contactPopUpFormElement)).getText();
        Assert.assertEquals(newMessage, "New message");
    }

    public void recipientEmail() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id(recipientEmailElement)).sendKeys("JohnDoe" + generateNumber() + "@mail.zzzz.com");
    }

    public void recipientName() {
        driver.findElement(By.id(recipientnameElement)).sendKeys("JohnDoe" + generateNumber());
    }

    public void messageText() {
        driver.findElement(By.id(messageTextElement)).sendKeys("This is a test message");
    }

    public void sendMessageButtonClick() {
        driver.findElement(By.xpath(sendMessageButtonElement)).click();
    }

    public void successfullySendingTheMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        String thanksForTheMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(thanksForTheMessage, message);

    }
}
