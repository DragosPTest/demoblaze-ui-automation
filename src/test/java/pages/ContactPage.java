package pages;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage {
    public ContactPage(){
        PageFactory.initElements(driver, this);
    }

    private String contactButton = "//*[@id=\"navbarExample\"]/ul/li[2]/a";
    private String contactPopUpForm = "exampleModalLabel";

    public void clickOnContactButton(){
        driver.findElement(By.xpath(contactButton)).click();
    }

    public void contactPopUpForm()throws InterruptedException{
        Thread.sleep(1000);
        String newMessage = driver.findElement(By.id(contactPopUpForm)).getText();
        Assert.assertEquals(newMessage, "New message");
    }
}
