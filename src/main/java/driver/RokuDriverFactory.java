package driver;

import config.Config;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;

@Log4j2
public class RokuDriverFactory {

//    public WebDriver createDriver() throws IOException {
//        return new WebDriver(new URL(Config.URL_STRING), getDesiredCapabilities());
//    }

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

}