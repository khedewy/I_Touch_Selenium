package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private final By accountManager = By.xpath("//a[@class='nav-top-link nav-top-not-logged-in is-small']");

    public RegisterPage navigateToRegisterPage(){
        driver.findElement(accountManager).click();
        return new RegisterPage(driver);
    }


}
