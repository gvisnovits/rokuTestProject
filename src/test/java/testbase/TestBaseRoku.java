package testbase;

import driver.DriverFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestBaseRoku {

    public synchronized void setupRokuDriver() {
        DriverFactory.getDriver();
        log.info("Got Driver");
    }

    public synchronized void tearDown() {
        DriverFactory.quitDriver();
        log.info("Quit Driver");
    }
}
