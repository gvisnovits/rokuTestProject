package tests.helloworld;

import helper.RokuHelper;
import helper.RokuNav;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class RokuTestAutomation {

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
    public void setupTests() throws Exception {
        RokuHelper rokuHelper = new RokuHelper();
        rokuHelper.launchChannel(sessionId);
        Thread.sleep(3000);
        rokuHelper.getFocusedElement(sessionId);
        rokuHelper.sendButtonRequest(sessionId, RokuNav.DOWN);
    }
}
