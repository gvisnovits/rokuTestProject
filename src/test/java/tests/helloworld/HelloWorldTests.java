package tests.helloworld;

import HelloWorld.LaunchPage;
import helper.RokuHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HelloWorldTests {

    /**
     * 1. In Roku Device upload portal, upload zip to roku device before running tests.
     */

    String sessionId;

    @BeforeMethod
    public String createSession() throws URISyntaxException, IOException, InterruptedException {
        RokuHelper rokuHelper = new RokuHelper();
        sessionId = rokuHelper.createAndGetSessionId();
        System.out.println("SessionId is: " + sessionId);
        return sessionId;
    }

    @AfterMethod
    public void tearDown() throws URISyntaxException, IOException, InterruptedException {
        RokuHelper rokuHelper = new RokuHelper();
        rokuHelper.closeChannelSession(sessionId);
    }

    @Test
    public void launchAndCheckHelloWorld() throws Exception {
        RokuHelper rokuHelper = new RokuHelper();
        rokuHelper.launchChannel(sessionId);
        Thread.sleep(3000);
        LaunchPage launchPage = new LaunchPage();
        Assert.assertTrue(launchPage.isHelloWorldDisplayed(sessionId), "Hello World text is not displayed.");
    }
}
