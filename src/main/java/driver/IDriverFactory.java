package driver;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.time.Duration;

public interface IDriverFactory {
	AppiumDriver createDriver() throws IOException;

	void clean();

	void toggleAirplaneMode(boolean enable);

	void terminateApp(String bundleId);

	void activateApp(String bundleId);

	void reinstallApp(String bundleId);

	void runAppInBackground(Duration duration);

	void tap(int x, int y);

	void swipe(String direction, double percent);

	void scroll(String direction, double percent);
}
