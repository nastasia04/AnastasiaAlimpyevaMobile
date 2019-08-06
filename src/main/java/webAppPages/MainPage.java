package webAppPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Driver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * This class describes main page of web app,
 * contains asserts for visible fields and buttons
 */
public class MainPage {
    private AppiumDriver driver;

    @FindBy(id="intro")
    private RemoteWebElement textAtHeader;


    public MainPage(AppiumDriver appiumDriver)  {
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Opens Website and check the page is loaded.
     *
     * @return MainPage object
     */
    public MainPage openPage(String sut) {
        driver.get(sut);
        Driver.driverWait().until(urlMatches(sut + "/"));
        return this;
    }

    /**
     * Checks the browser title is correct.
     *
     * @return MainPage object
     */
    public MainPage checkPageIsOpened(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle, "Browser title is incorrect");
        return this;
    }

    /**
     * Checks that Status Code is OK (200).
     *
     * @throws IOException If HttpURLConnection is incorrect
     * @return MainPage object
     **/
    public MainPage checkPageStatusCode() throws IOException {
        URL sut = new URL(driver.getCurrentUrl());
        HttpURLConnection connection = (HttpURLConnection) sut.openConnection();
        assertEquals(connection.getResponseCode(), HTTP_OK, "HTTP response code is not 200");
        return this;
    }
    /**
     * Checks that text at header is displayed.
     * Proof that web site loaded.
     *
     * @return MainPage object
     **/
    @SuppressWarnings("UnusedReturnValue")
    public MainPage checkTextAtHeaderIsDisplayed(){
        assertTrue(textAtHeader.isDisplayed());
        return this;
    }
}