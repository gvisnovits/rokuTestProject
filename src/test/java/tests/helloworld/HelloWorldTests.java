package tests.helloworld;

import helloworld.HelloWorldPage;
import helper.RokuHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;

public class HelloWorldTests {

	/**
	 * 1. In Roku Device upload portal, upload zip to roku device before running tests.
	 */

	String sessionId;

	@BeforeMethod
	public String createSession() throws URISyntaxException, IOException, InterruptedException {
		RokuHelper rokuHelper = new RokuHelper();
		sessionId = rokuHelper.createAndGetSessionId();
		System.out.println("SessionId is: " + sessionId);
		return sessionId;
	}

	@AfterMethod
	public void tearDown() throws URISyntaxException, IOException, InterruptedException {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.closeChannelSession(sessionId);
	}

	@Test
	public void launchAndCheckHelloWorldUsingStatusCodes() throws Exception {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.launchChannel(sessionId);
		Thread.sleep(3000);
		HelloWorldPage helloWorldPage = new HelloWorldPage();
		Assert.assertTrue(helloWorldPage.isHelloWorldDisplayedWithStatusCode(sessionId), "Hello World text is not displayed.");
	}

	@Test
	public void launchAndCheckHelloWorldUsingXPath() throws URISyntaxException, IOException, InterruptedException, XPathExpressionException {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.launchChannel(sessionId);
		Thread.sleep(3000);
		HelloWorldPage helloWorldPage = new HelloWorldPage();
		Assert.assertTrue(helloWorldPage.isHelloWorlddisplayedUsingXpath(sessionId), "Hello World is not displayed");
	}
}
