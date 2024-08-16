package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("reg_email");
    private final By passwordTxt = By.id("reg_password");
    private final By registerButton = By.xpath("//button[@name='register']");
    private final By assertionMessage = By.xpath("//h1[text()='My account']");

    public void enterRegisterData(String email, String password){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailTxt)));
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registerButton)));
        driver.findElement(registerButton).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
