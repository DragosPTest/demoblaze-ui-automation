package pages;

import basepage.BasePage;
import infrastructure.driver.Wait;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private Wait wait;

    public CartPage() {
        PageFactory.initElements(driver, this);
        wait = new Wait(driver);
    }

    private String phoneElement = "//*[@id=\"tbodyid\"]/div[1]//h4/a";
    private String monitorElement = "//*[@id=\"tbodyid\"]/div[1]//h4/a";
    private String laptopElement = "//*[@id=\"tbodyid\"]/div[6]//h4/a";
    private String addToCartButtonElement = "//*[@id=\"tbodyid\"]/div[2]//a";
    private String nextButtonElement = "next2";

    public void clickOnPhoneProduct() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(phoneElement)).click();
    }

    public void clickOnMonitorProduct() {
        driver.findElement(By.id(nextButtonElement)).click();
        wait.justSleep(1000);
        driver.findElement(By.xpath(monitorElement)).click();
    }

    public void clickOnLaptopProduct() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(laptopElement)).click();
    }

    public void clickOnAddToCartButton() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(addToCartButtonElement)).click();
    }

    public void productAddedToCart() {
        wait.justSleep(1000);
        Alert alert = driver.switchTo().alert();
        String productAddedMessage = alert.getText();
        Assert.assertEquals(productAddedMessage, "Product added");
    }
}
