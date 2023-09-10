package HelloWorld;

import helper.RokuHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class LaunchPage {

    private String HelloWorld = "Hello World!";

    public boolean isHelloWorldDisplayed(String sessionId) throws InterruptedException, URISyntaxException, IOException {
        RokuHelper rokuHelper = new RokuHelper();
        HttpResponse<String> response = rokuHelper.getElementByText(sessionId, HelloWorld);
        int responseCode = rokuHelper.getStatusCode(response);
        return responseCode == 0;
    }
}
