package driver;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public interface IDriverFactory {

    AppiumDriver createDriver() throws IOException;
    void clean();
}
