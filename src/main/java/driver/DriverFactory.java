package driver;

import config.Config;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DriverFactory {

    private static AppiumDriver driver = null;
    private static IDriverFactory driverFactory = null;

    private static void initDriver() {
        try {
            log.info("App URL: " + Config.APP.getAbsolutePath());
            AppiumFactory.startAppium();
            driverFactory = (IDriverFactory) new RokuDriverFactory();
            driver = driverFactory.createDriver();
            if (driver == null) throw new RuntimeException("Driver was not created!");
        } catch (Exception e) {
            e.printStackTrace();
            quitDriver();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static AppiumDriver getDriver() {
        if (!driverExists()) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driverExists()) {
            driver.quit();
        }
        if (Config.DEFAULT_AUTO_APPIUM_START) {
            AppiumFactory.stopAppium();
            driverFactory.clean();
        }
    }

    public static boolean driverExists() {
        return driver != null;
    }

}
