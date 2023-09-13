package config;

import java.io.File;

public class Config {

	public static final String ROKU_IP = "192.168.68.67";

	//Logging
	public static final File LOGS_DIR = new File("target/logs");

	//OS Provided Properties
	private static final String LOCAL_USER_DIR = System.getProperty("user.dir");

}
