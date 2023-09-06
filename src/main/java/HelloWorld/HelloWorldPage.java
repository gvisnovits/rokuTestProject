package HelloWorld;

import helper.UiHelper;
import org.openqa.selenium.By;

public class HelloWorldPage extends BasePage {

    private final By hellowWorldBox = By.xpath("//Label[@name='myLabel']");

    public boolean isHelloWorldDisplayed() {
        return UiHelper.isDisplayed(hellowWorldBox);
    }


}
