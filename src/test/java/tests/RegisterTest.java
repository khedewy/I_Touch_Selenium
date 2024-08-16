package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{
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
    public void getAssertionMessage(){

        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getAssertionMessage(),"My account");
    }

}
