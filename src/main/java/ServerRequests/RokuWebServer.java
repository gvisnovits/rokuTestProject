package ServerRequests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RokuWebServer {

    public static HttpResponse<String> launchChannel(HttpClient httpClient, String sessionId, String jsonRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/launch", sessionId)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Post response to launch the channel is: " + postResponse);
        return postResponse;
    }

    public static HttpResponse<String> getCreateSession(HttpClient httpClient, String jsonRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("http://127.0.0.1:9000/v1/session"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        return postResponse;
    }

    public static HttpResponse<String> getDeleteSession(String sessionId, HttpClient httpClient) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s", sessionId)))
                .DELETE()
                .build();

        HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        return deleteResponse;
    }

    public static HttpResponse<String> sendButtonRequest(String sessionId, HttpClient httpClient, String jsonRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest navigationRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/press", sessionId)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpResponse<String> navResponse = httpClient.send(navigationRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("This is the navigation response: " + navResponse);
        return navResponse;
    }

/*
    public static HttpResponse<String> getElementByText(String sessionId, HttpClient httpClient, String jsonRequest) {
        HttpRequest navigationRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/press", sessionId)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpResponse<String> navResponse = httpClient.send(navigationRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("This is the navigation response: " + navResponse);
        return navResponse;
    }
*/

}
