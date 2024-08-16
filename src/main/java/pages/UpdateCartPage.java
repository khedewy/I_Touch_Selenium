package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateCartPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public UpdateCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By viewCart = By.linkText("View cart");
    private final By plusButton = By.xpath("//input[@value='+']");
    private final By updateCart = By.name("update_cart");
    private final By updateAssertionMessage = By.xpath("//div[@class='message-container container success-color medium-text-center']");
    private final By removeItem = By.xpath("//a[@class='remove']");
    private final By removeItemAssertion = By.xpath("//div[@class='message-container container medium-text-center']");

    public void navigateToCartPage() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(viewCart).click();
    }

    public void setUpdateCart()  {
        driver.findElement(plusButton).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(updateCart)));
        driver.findElement(updateCart).click();
    }

    public String setUpdateAssertionMessage() throws InterruptedException {
        Thread.sleep(15000);
        return driver.findElement(updateAssertionMessage).getText();
    }
    public void setRemoveItem(){
        driver.findElement(removeItem).click();
    }
    public String getRemoveItemAssertionMessage() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(removeItemAssertion).getText();
    }
}
