package helper;

import ServerRequests.ElementUsingEnum;
import ServerRequests.JsonBodyRequests.CreateSession;
import ServerRequests.JsonBodyRequests.ElementRequest;
import ServerRequests.JsonBodyRequests.KeyPress;
import ServerRequests.JsonBodyRequests.LaunchChannel;
import ServerRequests.JsonBodyResponse.CommonResponses;
import ServerRequests.JsonBodyResponse.CreateSessionResponse;
import ServerRequests.JsonBodyResponse.ElementResponse;
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

	public String getFocusedElement(String sessionId) throws URISyntaxException, IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();
		Gson gson = new Gson();
		HttpResponse<String> postResponse = RokuWebServer.getFocusedElement(sessionId, httpClient);
		ElementResponse elementActiveResponse = gson.fromJson(postResponse.body(), ElementResponse.class);
		String jsonResponseString = new Gson().toJson(elementActiveResponse);
		System.out.println("Full Response body as string is: " + jsonResponseString);
		return jsonResponseString;
	}

	public HttpResponse<String> getElementByText(String sessionId, String text) throws URISyntaxException, IOException, InterruptedException {
		ElementRequest elementRequest = new ElementRequest(ElementUsingEnum.TEXT, text);
		HttpClient httpClient = HttpClient.newHttpClient();
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(elementRequest);
		return RokuWebServer.getElement(sessionId, httpClient, jsonRequest);
	}

	public int getStatusCode(HttpResponse<String> jsonBodyResponse) {
		Gson gson = new Gson();
		CommonResponses commonResponses = gson.fromJson(jsonBodyResponse.body(), CommonResponses.class);
		return commonResponses.getStatus();
	}

	public String getPageXml(String sessionId) throws URISyntaxException, IOException, InterruptedException {
		String jsonResponse = getFocusedElement(sessionId);
		return JsonToXmlHelper.convertJsonToXml(jsonResponse);
	}
}
