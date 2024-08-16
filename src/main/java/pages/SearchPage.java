package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.awt.event.KeyEvent;


public class SearchPage {
    private final WebDriver driver;
    Robot robot;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    private final By searchBox = By.id("woocommerce-product-search-field-0");
    private final By assertionMessage = By.xpath("//h1[text()='Search results: “iphone”']");

    public void searchForProduct(String product) throws AWTException {
        driver.findElement(searchBox).sendKeys(product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String getAssertionMessage() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        Thread.sleep(10000);
        return driver.findElement(assertionMessage).getText();
    }
}
