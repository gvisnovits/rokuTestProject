package serverrequests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RokuWebServer {

	public static HttpResponse<String> launchChannel(HttpClient httpClient, String sessionId, String jsonRequest) {
		try {
			HttpRequest postRequest = HttpRequest.newBuilder()
					.uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/launch", sessionId)))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
					.build();
			return httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static HttpResponse<String> createSession(HttpClient httpClient, String jsonRequest) {
		try {
			HttpRequest postRequest = HttpRequest.newBuilder()
					.uri(new URI("http://127.0.0.1:9000/v1/session"))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
					.build();
			return httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static HttpResponse<String> deleteSession(String sessionId, HttpClient httpClient) {
		try {
			HttpRequest deleteRequest = HttpRequest.newBuilder()
					.uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s", sessionId)))
					.DELETE()
					.build();
			return httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static HttpResponse<String> sendButtonRequest(String sessionId, HttpClient httpClient, String jsonRequest) {
		try {
			HttpRequest navigationRequest = HttpRequest.newBuilder()
					.uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/press", sessionId)))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
					.build();
			return httpClient.send(navigationRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static HttpResponse<String> getFocusedElement(String sessionid, HttpClient httpClient) {
		try {
			HttpRequest focusedElement = HttpRequest.newBuilder()
					.uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/element/active", sessionid)))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(""))
					.build();
			return httpClient.send(focusedElement, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static HttpResponse<String> getElement(String sessionId, HttpClient httpClient, String jsonRequest) {
		try {
			HttpRequest navigationRequest = HttpRequest.newBuilder()
					.uri(new URI(String.format("http://127.0.0.1:9000/v1/session/%s/element", sessionId)))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
					.build();
			return httpClient.send(navigationRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
