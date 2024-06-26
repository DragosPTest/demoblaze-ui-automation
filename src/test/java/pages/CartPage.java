package pages;

import basepage.BasePage;
import infrastructure.driver.Wait;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    private String deleteButtonElement = "//*[@id=\"tbodyid\"]//td[4]/a";
    private String totalPriceElement = "totalp";
    private String firstProductPriceElement = "//*[@id=\"tbodyid\"]//td[3]";
    private String secondProductPriceElement = "//*[@id=\"tbodyid\"]/tr[2]/td[3]";

    private String getTheFirstProductPrice;
    private String getTheSecondProductPrice;
    private String getTheTotalPriceOfAllProducts;


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

    public void clickOnDeleteButton() {
        wait.justSleep(1000);
        driver.findElement(By.xpath(deleteButtonElement)).click();
    }


    public void getThePriceOfProducts() {
        wait.justSleep(1000);
        List<WebElement> firstProduct = driver.findElements(By.xpath(firstProductPriceElement));
        List<WebElement> secondProduct = driver.findElements(By.xpath(secondProductPriceElement));

        if (!firstProduct.isEmpty()) {
            getTheFirstProductPrice = firstProduct.get(0).getText();
        }

        if (!secondProduct.isEmpty()) {
            getTheSecondProductPrice = secondProduct.get(0).getText();
        }

        getTheTotalPriceOfAllProducts = driver.findElement(By.id(totalPriceElement)).getText();
    }

    public void totalPrice() {
        wait.justSleep(1000);
        List<WebElement> cartItems = driver.findElements(By.xpath(firstProductPriceElement));
        String totalPrice = driver.findElement(By.id(totalPriceElement)).getText();
        if (cartItems.isEmpty()) {
            Assert.assertEquals(totalPrice, "");
        } else {
            String productPrice = driver.findElement(By.xpath(firstProductPriceElement)).getText();
            Assert.assertEquals(productPrice, totalPrice);
        }
    }

    public void productAddedToCart() {
        wait.justSleep(1000);
        Alert alert = driver.switchTo().alert();
        String productAddedMessage = alert.getText();
        Assert.assertEquals(productAddedMessage, "Product added");
        alert.accept();
    }

    public void sumOfProducts() {
        int firstProductPrice = Integer.parseInt(getTheFirstProductPrice);
        int secondProductPrice = Integer.parseInt(getTheSecondProductPrice);
        int totalPrice = Integer.parseInt(getTheTotalPriceOfAllProducts);
        int sumOfProductPrices = firstProductPrice + secondProductPrice;
        Assert.assertEquals(totalPrice, sumOfProductPrices);


    }

    public void totalPriceSubtraction() {
        wait.justSleep(1000);
        Integer firstProductPrice = (getTheFirstProductPrice != null) ? Integer.parseInt(getTheFirstProductPrice) : null;
        int totalPrice = Integer.parseInt(getTheTotalPriceOfAllProducts);
        int subtractionProductPrices = firstProductPrice - 0;
        Assert.assertEquals(subtractionProductPrices, totalPrice);

    }

}


