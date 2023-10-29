package tests.helloworld;

import helloworld.HelloWorldPage;
import helper.RokuHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testbase.RokuTestBase;
import utilities.WaiterUtility;

public class HelloWorldTests extends RokuTestBase {

	String sessionId;

	@BeforeMethod
	public String createSession() {
		RokuHelper rokuHelper = new RokuHelper();
		sessionId = rokuHelper.createAndGetSessionId();
		return sessionId;
	}

	@AfterMethod
	public void tearDown() {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.closeChannelSession(sessionId);
	}

	@Test
	public void launchAndCheckHelloWorldUsingStatusCodes() {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.launchChannel(sessionId);
		WaiterUtility.pauseFor(3000);
		HelloWorldPage helloWorldPage = new HelloWorldPage();
		Assert.assertTrue(helloWorldPage.isHelloWorldDisplayedWithStatusCode(sessionId), "Hello World text is not displayed.");
	}

	@Test
	public void launchAndCheckHelloWorldUsingXPath() {
		RokuHelper rokuHelper = new RokuHelper();
		rokuHelper.launchChannel(sessionId);
		WaiterUtility.pauseFor(3000);
		HelloWorldPage helloWorldPage = new HelloWorldPage();
		Assert.assertTrue(helloWorldPage.isHelloWorlddisplayedUsingXpath(sessionId), "Hello World is not displayed");
	}
}
