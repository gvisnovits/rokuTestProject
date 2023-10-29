package debug;

import config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WaiterUtility;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class GeneralDebugging {

	private static final File location = new File(String.format(Config.LOCAL_USER_DIR + "/src"));
	private static final String command = "go run .";
	private static final String shell = "sh";
	private static final String terminalCommand = "-c";
	private static Process process;
	private static ProcessBuilder builder = new ProcessBuilder();

	@BeforeMethod
	public void setup() throws IOException {
		builder.directory(location);
		builder.command(shell, terminalCommand, command);
		process = builder.start();
	}

	@AfterMethod
	public void close() {
		System.out.println("sleeping for 10 seconds");
		WaiterUtility.pauseFor(10000);
		closeServer(process);
	}

	@Test
	public void debugTerminalStart() throws Exception {
		runCommand(location, command);
	}

	public static void runCommand(File whereToRun, String command) throws Exception {
		System.out.println("Running in: " + whereToRun);
		System.out.println("Command: " + command);

		builder.directory(whereToRun);
//		builder.command(shell, terminalCommand, command);


		OutputStream outputStream = process.getOutputStream();
		InputStream inputStream = process.getInputStream();
		InputStream errorStream = process.getErrorStream();

		printStream(inputStream);
		printStream(errorStream);

		boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
		outputStream.flush();
		outputStream.close();

		if(!isFinished) {
			closeServer(process);
		}
	}

	public static void closeServer(Process process) {
		System.out.println("Closing server");
		process.destroyForcibly();
	}

	private static void printStream(InputStream inputStream) throws IOException {
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		}
	}
}
