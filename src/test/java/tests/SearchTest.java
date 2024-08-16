package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.awt.*;

public class SearchTest extends TestBase{
    SearchPage searchPage;

    @Test
    public void searchForProduct() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct("iphone");
    }
    @Test(priority = 1)
    public void getAssertionMessage() throws InterruptedException {
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getAssertionMessage(),"Search results: “iphone”");
    }
}
