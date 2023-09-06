package tests.helloworld;

import com.google.gson.Gson;
import transcript.Transcript;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestClass {

    public static void main(String[] args) throws Exception {
        Transcript transcript = new Transcript();
        transcript.setIp("192.168.68.52");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        System.out.println("This is my Json Body Request: " + jsonRequest);
        //POST - Create SessionId
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("http://127.0.0.1:9000/v1/session"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());


        System.out.println("This is the post response body: " + postResponse.body());

        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        System.out.println("This is the transcript getting the session id: " + transcript.getSessionId());

        //DEL delete session
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s", transcript.getSessionId())))
                .DELETE()
                .build();

        HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("This is the delete response body: " + deleteResponse.body());
//        transcript = gson.fromJson(deleteResponse.body(), Transcript.class);
//        System.out.println("Delete response is: " + transcript);

    }
}
