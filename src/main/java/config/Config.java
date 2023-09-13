package config;

import config.channels.Channels;

import java.io.File;

public class Config {

	public static final boolean DEFAULT_AUTO_APPIUM_START = true;
	private static final String DEFAULT_APP_PATH = Channels.HELLO_WORLD.getChannelNameDirectory();
	private static final String DEFAULT_APP_NAME = Channels.HELLO_WORLD.getAppName();


	//Appium Settings
	public static final File APPIUM_PATH = new File("/opt/homebrew/bin/appium");
	public static final Integer APPIUM_PORT = 4723;

	//Roku Settings
	public static final String ROKU_ECP_PORT = "8060";
	public static final String ROKU_WEB_PORT = "80";
	public static final String ROKU_USER = "rokudev";
	public static final String ROKU_PASSWORD = "passwordGoesHere";
	public static final String ROKU_IP = "192.168.68.67";

	//Logging
	public static final File LOGS_DIR = new File("target/logs");

	//OS Provided Properties
	private static final String LOCAL_USER_DIR = System.getProperty("user.dir");
	public static final String URL_STRING = String.format("http://localhost:%s/", APPIUM_PORT);


	//Global Settings
	public static final File APP = new File(LOCAL_USER_DIR + DEFAULT_APP_PATH, DEFAULT_APP_NAME);

}
