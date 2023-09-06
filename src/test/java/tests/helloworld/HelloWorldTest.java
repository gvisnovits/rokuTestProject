package tests.helloworld;

import HelloWorld.HelloWorldPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBaseRoku;

public class HelloWorldTest extends TestBaseRoku {

    @Test
    public void launchHelloWorld() {
        HelloWorldPage helloWorldPage = new HelloWorldPage();
        System.out.println("Did Roku Hello World channel launch?");
        Assert.assertTrue(helloWorldPage.isHelloWorldDisplayed());
    }
}
