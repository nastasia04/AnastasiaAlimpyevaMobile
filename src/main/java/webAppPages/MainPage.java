package webAppPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import setup.Driver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static org.testng.Assert.assertEquals;


/**
 * This class describes main page of web app,
 * contains asserts for visible fields and buttons
 */
public class MainPage {
    private AppiumDriver dr;


    public MainPage(AppiumDriver appiumDriver)  {
        dr = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(dr), this);
    }

    /**
     * Opens Website and check the page is loaded.
     *
     * @return MainPage object
     */
    public MainPage openPage(String sut) {
        dr.get(sut);
        Driver.driverWait().until(urlMatches(sut + "/"));
        return this;
    }

    /**
     * Checks the browser title is correct.
     *
     * @return MainPage object
     */
    public MainPage checkPageIsOpened(String browserTitle) {
        assertEquals(dr.getTitle(), browserTitle, "Browser title is incorrect");
        return this;
    }

    /**
     * Checks that Status Code is OK (200).
     *
     * @throws IOException If HttpURLConnection is incorrect
     * @return MainPage object
     **/
    @SuppressWarnings("UnusedReturnValue")
    public MainPage checkPageStatusCode() throws IOException {
        URL sut = new URL(dr.getCurrentUrl());
        HttpURLConnection connection = (HttpURLConnection) sut.openConnection();
        assertEquals(connection.getResponseCode(), HTTP_OK, "HTTP response code is not 200");
        return this;
    }
}
