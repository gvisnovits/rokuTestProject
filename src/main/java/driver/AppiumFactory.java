package driver;

import config.Config;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.log4j.Log4j2;
import utilities.TextUtility;

import java.io.File;

@Log4j2
public class AppiumFactory {

    private static AppiumDriverLocalService appiumService = null;

    public static void startAppium() {
        appiumService = new AppiumServiceBuilder()
                .withAppiumJS(Config.APPIUM_PATH)
                .usingPort(Config.APPIUM_PORT)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withLogFile(new File(Config.LOGS_DIR, "appium_" + TextUtility.getTimestamp() + ".log"))
                .build();
        log.info("Starting new appium server...");
        appiumService.start();
        appiumService.clearOutPutStreams();
    }

    public static void stopAppium() {
        if (appiumExists()) {
            log.info("Stopping Appium...");
            appiumService.stop();
        }
    }

    public static boolean appiumExists() {
        return appiumService != null;
    }

}