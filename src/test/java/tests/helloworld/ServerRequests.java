package tests.helloworld;

import com.google.gson.Gson;
import config.Config;
import helper.RokuNav;
import transcript.Transcript;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServerRequests{

    public static void main(String[] args) throws Exception {
        Transcript transcript = new Transcript();
        transcript.setIp(Config.ROKU_IP);
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        String jsonRequest = gson.toJson(transcript);
        System.out.println("This is my Json Body Request: " + jsonRequest);

        //Create Session
        HttpResponse<String> postCreateSessionResponse = getCreateSession(httpClient, jsonRequest);
        System.out.println("This is the post response body: " + postCreateSessionResponse.body());

        transcript = gson.fromJson(postCreateSessionResponse.body(), Transcript.class);
        String sessionId = transcript.getSessionId();

        transcript.setChannelId("dev");
        String jsonRequest2 = gson.toJson(transcript);

        HttpResponse<String> postResponse = launchChannel(httpClient, sessionId, jsonRequest2);

        transcript.setButton(RokuNav.DOWN.getNavigation());
        String jsonRequest3 = gson.toJson(transcript);

        System.out.println("Print of jsonRequest3 is: " + jsonRequest3);
        HttpRequest navigationRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/press", sessionId)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest3))
                .build();
        HttpResponse<String> navResponse = httpClient.send(navigationRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("This is the navigation response: " + navResponse);

        //DEL delete session
        HttpResponse<String> deleteResponse = getDeleteSession(sessionId, httpClient);
        System.out.println("This is the delete response body: " + deleteResponse.body());
    }

    private static HttpResponse<String> launchChannel(HttpClient httpClient, String sessionId, String jsonRequest2) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/launch", sessionId)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest2))
                .build();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Post response to launch the channel is: " + postResponse);
        return postResponse;
    }

    private static HttpResponse<String> getCreateSession(HttpClient httpClient, String jsonRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("http://127.0.0.1:9000/v1/session"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        return postResponse;
    }

    private static HttpResponse<String> getDeleteSession(String sessionId, HttpClient httpClient) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s", sessionId)))
                .DELETE()
                .build();

        HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        return deleteResponse;
    }

}
