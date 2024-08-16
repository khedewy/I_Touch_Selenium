package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }
    private final By chosenProduct = By.xpath("//a[text()='Apple iPhone 15 Pro Max FineWoven Case With Magsafe Mulberry']");
    private final By addToCartButton = By.xpath("//button[@class='single_add_to_cart_button button alt']");
    private final By checkoutPage = By.linkText("Checkout");


    public void navigateToAddToCartPage() throws InterruptedException {
        // it is not recommended to use Thread.sleep
        Thread.sleep(5000);
        driver.findElement(chosenProduct).click();
    }

    public void addProductToCart() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(addToCartButton).click();
    }
    public CheckoutPage navigateToCheckOutPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(checkoutPage).click();
        Thread.sleep(5000);
        return new CheckoutPage(driver);

    }



}
