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
        Transcript transcript = new Transcript();
        transcript.setIp(Config.ROKU_IP);
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);
        System.out.println("This is my Json Body Request: " + jsonRequest);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = RokuWebServer.getCreateSession(httpClient, jsonRequest);
        System.out.println("This is the post response body: " + postResponse.body());
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        return transcript.getSessionId();
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

    public void launchChannel(String sessionId) throws URISyntaxException, IOException, InterruptedException {
        Transcript transcript = new Transcript();
        Gson gson = new Gson();
        transcript.setChannelId("dev");
        String jsonRequest = gson.toJson(transcript);
        HttpClient httpClient = HttpClient.newHttpClient();
        RokuWebServer.launchChannel(httpClient, sessionId, jsonRequest);
    }

    public void sendButtonRequest(String sessionId, RokuNav rokuNav) throws URISyntaxException, IOException, InterruptedException {
        Transcript transcript = new Transcript();
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        transcript.setButton(rokuNav.getNavigation());
        String jsonRequest = gson.toJson(transcript);
        System.out.println("Print of jsonRequest for Nav is: " + jsonRequest);
        RokuWebServer.sendButtonRequest(sessionId, httpClient, jsonRequest);
    }

    public void closeChannelSession(String sessionId) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        RokuWebServer.getDeleteSession(sessionId, httpClient);
    }
}
