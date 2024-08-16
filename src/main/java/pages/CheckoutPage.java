package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class CheckoutPage {
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    private final By firstNameTxt = By.id("billing_first_name");
    private final By lastNameTxt = By.id("billing_last_name");
    private final By mobileNumTxt = By.id("billing_phone");
    private final By streetNumber = By.id("billing_address_1");
    private final By streetNumber2 = By.id("billing_address_2");
    private final By cityTxt = By.id("billing_city");
    private final By postCodeTxt = By.id("billing_postcode");
    private final By commentTxt = By.id("order_comments");
    private final By placeOrderButton = By.id("place_order");
    private final By  assertionMessage = By.xpath("//strong[text()='Thank you. Your order has been received.']");


    public void enterAddressInf(String firstName,String lastName, String mobile){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(mobileNumTxt).sendKeys(mobile);
    }

    public void completeCheckoutInf(String street1,String street2,String cit,String postCode, String comment){
        driver.findElement(streetNumber).sendKeys(street1);
        driver.findElement(streetNumber2).sendKeys(street2);
        driver.findElement(cityTxt).sendKeys(cit);
        driver.findElement(postCodeTxt).sendKeys(postCode);
        driver.findElement(commentTxt).sendKeys(comment);
    }
    public void placeOrder() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(placeOrderButton)));
        Thread.sleep(6000);
        driver.findElement(placeOrderButton).click();
    }
    public String getPlaceOrderAssertionMessage() throws InterruptedException {
        Thread.sleep(25000);
        return driver.findElement(assertionMessage).getText();
    }
}
