package helloworld;

import helper.RokuHelper;
import serverrequests.ResponseCode;
import xpathevaluator.XPathEvaluator;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class HelloWorldPage {

	private String helloWorld = "Hello World!";
	private String helloWorldXpath = "//Value[contains(string(), 'Hello World!')]";

	public boolean isHelloWorldDisplayedWithStatusCode(String sessionId) throws InterruptedException, URISyntaxException, IOException {
		RokuHelper rokuHelper = new RokuHelper();
		HttpResponse<String> response = rokuHelper.getElementByText(sessionId, helloWorld);
		int responseCode = rokuHelper.getStatusCode(response);
		return responseCode == ResponseCode.SUCCESS.getCode();
	}

	public boolean isHelloWorlddisplayedUsingXpath(String sessionId) throws URISyntaxException, IOException, InterruptedException, XPathExpressionException {
		RokuHelper rokuHelper = new RokuHelper();
		String xml = rokuHelper.getPageXml(sessionId);
		return XPathEvaluator.isDisplayed(xml, helloWorldXpath);
	}

}
