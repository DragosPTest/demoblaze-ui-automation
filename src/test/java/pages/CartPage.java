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
    private String laptopElement = "//*[@id=\"tbodyid\"]/div[8]/div/div/h4/a";
    private String addToCartButtonElement = "//*[@id=\"tbodyid\"]/div[2]//a";
    private String nextButtonElement = "next2";
    private String cartButtonMainPageElement = "//*[@id=\"navbarExample\"]//li[4]/a";
    private String homeButtonMainPageElement = "//*[@id=\"navbarExample\"]//li[1]/a";
    private String totalPriceElement = "totalp";
    private String firstProductPriceElement = "//*[@id=\"tbodyid\"]//td[3]";
    private String secondProductPriceElement = "//*[@id=\"tbodyid\"]/tr[2]/td[3]";
    private String thirdProductPriceElement = "//*[@id=\"tbodyid\"]/tr[3]/td[3]";
    String getTheFirstProductPrice;
    String getTheSecondProductPrice;
    String getTheThirdProductPrice;
    String getTheTotalPriceOfAllProducts;

    public void clickOnPhoneProduct() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(phoneElement)).click();
    }

    public void clickOnMonitorProduct() {
        wait.justSleep(1000);
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

    public void clickOnCartButtonMainPage() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(cartButtonMainPageElement)).click();
    }

    public void clickOnHomeButtonMaiPage() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(homeButtonMainPageElement)).click();
    }

    public void productAddedToCart() {
        wait.justSleep(1000);
        Alert alert = driver.switchTo().alert();
        String productAddedMessage = alert.getText();
        Assert.assertEquals(productAddedMessage, "Product added");
        alert.accept();
    }

    public void totalPriceSingleProduct() {
        wait.justSleep(1000);
        String productPrice = driver.findElement(By.xpath(firstProductPriceElement)).getText();
        String totalPrice = driver.findElement(By.id(totalPriceElement)).getText();
        Assert.assertEquals(productPrice, totalPrice);
    }

    public void getThePriceOfProducts() {
        wait.justSleep(1000);
        getTheFirstProductPrice = driver.findElement(By.xpath(firstProductPriceElement)).getText();
        getTheSecondProductPrice = driver.findElement(By.xpath(secondProductPriceElement)).getText();
        getTheThirdProductPrice = driver.findElement(By.xpath(thirdProductPriceElement)).getText();
        getTheTotalPriceOfAllProducts = driver.findElement(By.id(totalPriceElement)).getText();


    }

    public void sumOfProducts() {
        int firstProductPrice = Integer.parseInt(getTheFirstProductPrice);
        int secondProductPrice = Integer.parseInt(getTheSecondProductPrice);
        int thirdProductPrice = Integer.parseInt(getTheThirdProductPrice);
        int totalPrice = Integer.parseInt(getTheTotalPriceOfAllProducts);
        int sumOfProductPrices = firstProductPrice + secondProductPrice + thirdProductPrice;
        Assert.assertEquals(totalPrice, sumOfProductPrices);

    }

}
