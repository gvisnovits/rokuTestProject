package tests.helloworld;

import helper.RokuHelper;
import helper.RokuNav;
import org.testng.annotations.Test;

public class RokuTestAutomation {

    @Test
    public static void setupTests() throws Exception {
        RokuHelper rokuHelper = new RokuHelper();
        String sessionId = rokuHelper.createAndGetSessionId();
        rokuHelper.launchChannel(sessionId);
        Thread.sleep(3000);
        rokuHelper.sendButtonRequest(sessionId, RokuNav.DOWN);
        rokuHelper.closeChannelSession(sessionId);
    }
}
