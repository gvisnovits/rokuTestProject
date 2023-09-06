package HelloWorld;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
