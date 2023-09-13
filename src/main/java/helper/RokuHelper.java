package helper;

import com.google.gson.Gson;
import config.Config;
import serverrequests.LocatorStrategy;
import serverrequests.RokuWebServer;
import serverrequests.jsonbodyrequests.CreateSession;
import serverrequests.jsonbodyrequests.ElementRequest;
import serverrequests.jsonbodyrequests.KeyPress;
import serverrequests.jsonbodyrequests.LaunchChannel;
import serverrequests.jsonbodyresponse.CommonResponses;
import serverrequests.jsonbodyresponse.CreateSessionResponse;
import serverrequests.jsonbodyresponse.ElementResponse;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class RokuHelper {

	public String createAndGetSessionId() {
		CreateSession createSession = new CreateSession(Config.ROKU_IP);
		Gson gson = new Gson();
		HttpClient httpClient = HttpClient.newHttpClient();
		String jsonRequest = gson.toJson(createSession);
		HttpResponse<String> postResponse = RokuWebServer.createSession(httpClient, jsonRequest);
		CreateSessionResponse createSessionResponse = gson.fromJson(postResponse.body(), CreateSessionResponse.class);
		return createSessionResponse.getSessionId();
	}

	public void launchChannel(String sessionId) {
		LaunchChannel launchChannel = new LaunchChannel("dev");
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(launchChannel);
		HttpClient httpClient = HttpClient.newHttpClient();
		RokuWebServer.launchChannel(httpClient, sessionId, jsonRequest);
	}

	public void sendButtonRequest(String sessionId, RokuNav rokuNav) {
		KeyPress keyPress = new KeyPress(rokuNav.getNavigation());
		Gson gson = new Gson();
		HttpClient httpClient = HttpClient.newHttpClient();
		String jsonRequest = gson.toJson(keyPress);
		RokuWebServer.sendButtonRequest(sessionId, httpClient, jsonRequest);
	}

	public void closeChannelSession(String sessionId) {
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			RokuWebServer.deleteSession(sessionId, httpClient);
		} catch (Exception e) {
			System.out.println("Caught an exception");
		}
	}

	public String getFocusedElement(String sessionId) {
		Gson gson = new Gson();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> postResponse = RokuWebServer.getFocusedElement(sessionId, httpClient);
		ElementResponse elementActiveResponse = gson.fromJson(postResponse.body(), ElementResponse.class);
		return new Gson().toJson(elementActiveResponse);
	}

	public HttpResponse<String> getElementByText(String sessionId, String text) {
		ElementRequest elementRequest = new ElementRequest(LocatorStrategy.TEXT, text);
		Gson gson = new Gson();
		HttpClient httpClient = HttpClient.newHttpClient();
		String jsonRequest = gson.toJson(elementRequest);
		return RokuWebServer.getElement(sessionId, httpClient, jsonRequest);
	}

	public int getStatusCode(HttpResponse<String> jsonBodyResponse) {
		Gson gson = new Gson();
		CommonResponses commonResponses = gson.fromJson(jsonBodyResponse.body(), CommonResponses.class);
		return commonResponses.getStatus();
	}

	public String getPageXml(String sessionId) {
		String jsonResponse = getFocusedElement(sessionId);
		return JsonToXmlHelper.convertJsonToXml(jsonResponse);
	}
}
