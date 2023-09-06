package helper;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

@Log4j2
public class UiHelper {

    public static boolean isDisplayed(By locator) {
        boolean isDisplayed = false;
        AppiumDriver driver = DriverFactory.getDriver();
        try {
            isDisplayed = driver.findElement(locator).isDisplayed();
            log.info("Locator - {} is displayed.", locator);
        } catch (NoSuchElementException e) {
            log.warn("Locator - {} is not displayed - NoSuchElementException", locator);
        }
        return isDisplayed;
    }

}
