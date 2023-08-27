package driver;

import config.Config;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

@Log4j2
public class RokuDriverFactory implements IDriverFactory{

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Roku");
        caps.setCapability("appium:automationName", "Roku");
        caps.setCapability("appium:app", Config.APP.getAbsolutePath());
        caps.setCapability("appium:rokuHost", Config.ROKU_IP);
        caps.setCapability("appium:rokuEcpPort", Config.ROKU_ECP_PORT);
        caps.setCapability("appium:rokuWebPort", Config.ROKU_WEB_PORT);
        caps.setCapability("appium:rokuUser", Config.ROKU_USER);
        caps.setCapability("appium:rokuPass", Config.ROKU_PASSWORD);
        caps.setCapability("appium:rokuHeaderHost", Config.ROKU_IP);
        return caps;
    }

    @Override
    public AppiumDriver createDriver() throws IOException {
        return null;
    }

    @Override
    public void clean() {

    }
}