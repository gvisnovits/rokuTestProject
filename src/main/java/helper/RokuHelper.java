package helper;

import ServerRequests.RokuWebServer;
import com.google.gson.Gson;
import config.Config;
import transcript.Transcript;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class RokuHelper {

    public String createAndGetSessionId() throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> postResponse = createSession();
        System.out.println("This is the post response body: " + postResponse.body());
        return getSessionId(postResponse);
    }

    public HttpResponse<String> createSession() throws URISyntaxException, IOException, InterruptedException {
        RokuWebServer rokuWebServer = new RokuWebServer();
        Transcript transcript = new Transcript();
        transcript.setIp(Config.ROKU_IP);
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);
        System.out.println("This is my Json Body Request: " + jsonRequest);
        HttpClient httpClient = HttpClient.newHttpClient();
        return rokuWebServer.getCreateSession(httpClient, jsonRequest);
    }

    public String getSessionId(HttpResponse<String> postResponse) {
        Transcript transcript = new Transcript();
        Gson gson = new Gson();
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        String sessionId = transcript.getSessionId();
        return sessionId;
    }
}
