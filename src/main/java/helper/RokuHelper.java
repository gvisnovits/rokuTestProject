package helper;

import ServerRequests.JsonBodyRequests.CreateSession;
import ServerRequests.JsonBodyRequests.KeyPress;
import ServerRequests.JsonBodyRequests.LaunchChannel;
import ServerRequests.JsonBodyResponse.CreateSessionResponse;
import ServerRequests.RokuWebServer;
import com.google.gson.Gson;
import config.Config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class RokuHelper {

    public String createAndGetSessionId() throws URISyntaxException, IOException, InterruptedException {
        CreateSession createSession = new CreateSession(Config.ROKU_IP);
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(createSession);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = RokuWebServer.getCreateSession(httpClient, jsonRequest);
        CreateSessionResponse createSessionResponse = gson.fromJson(postResponse.body(), CreateSessionResponse.class);
        return createSessionResponse.getSessionId();
    }

    public void launchChannel(String sessionId) throws URISyntaxException, IOException, InterruptedException {
        LaunchChannel launchChannel = new LaunchChannel("dev");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(launchChannel);
        HttpClient httpClient = HttpClient.newHttpClient();
        RokuWebServer.launchChannel(httpClient, sessionId, jsonRequest);
    }

    public void sendButtonRequest(String sessionId, RokuNav rokuNav) throws URISyntaxException, IOException, InterruptedException {
        KeyPress keyPress = new KeyPress(rokuNav.getNavigation());
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        String jsonRequest = gson.toJson(keyPress);
        System.out.println("Print of jsonRequest for Nav is: " + jsonRequest);
        RokuWebServer.sendButtonRequest(sessionId, httpClient, jsonRequest);
    }

    public void closeChannelSession(String sessionId) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        RokuWebServer.getDeleteSession(sessionId, httpClient);
    }
}
