package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;

import java.awt.*;
import java.io.IOException;

public class AddToCartTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;
    HomePage homePage;
    RegisterData data;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        registerPage = new RegisterPage(driver);
        data = new RegisterData();
        data.testData();
        registerPage.enterRegisterData(data.email+currentTime+"@gmail.com", data.password);
    }

    @Test(priority = 2)
    public void getRegisterAssertionMessage(){

        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getAssertionMessage(),"My account");
    }
    @Test(priority = 3)
    public void searchForProduct() throws AWTException, InterruptedException {
        searchPage = new SearchPage(driver);
        Thread.sleep(5000);
        searchPage.searchForProduct("iphone");
    }
    @Test(priority = 4)
    public void getAssertionMessage() throws InterruptedException {
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getAssertionMessage(),"Search results: “iphone”");
    }
    @Test(priority = 5)
    public void navigateToAddProductToCart() throws InterruptedException {
        add = new AddToCartPage(driver);
        add.navigateToAddToCartPage();
    }
    @Test(priority = 6)
    public void addProductToCart() throws InterruptedException {
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }
    @Test(priority = 7)
    public void navigateToCheckoutPage() throws InterruptedException {
        add = new AddToCartPage(driver);
        add.navigateToCheckOutPage();
    }


}
