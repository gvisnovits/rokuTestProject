package helloworld;

import helper.RokuHelper;
import serverrequests.ResponseCode;
import xpathevaluator.XPathEvaluator;

import java.net.http.HttpResponse;

public class HelloWorldPage {

	private String helloWorld = "Hello World!";
	private String helloWorldXpath = "//Value[contains(string(), 'Hello World!')]";

	public boolean isHelloWorldDisplayedWithStatusCode(String sessionId) {
		RokuHelper rokuHelper = new RokuHelper();
		HttpResponse<String> response = rokuHelper.getElementByText(sessionId, helloWorld);
		int responseCode = rokuHelper.getStatusCode(response);
		return responseCode == ResponseCode.SUCCESS.getCode();
	}

	public boolean isHelloWorlddisplayedUsingXpath(String sessionId) {
		RokuHelper rokuHelper = new RokuHelper();
		String xml = rokuHelper.getPageXml(sessionId);
		return XPathEvaluator.isDisplayed(xml, helloWorldXpath);
	}

}
