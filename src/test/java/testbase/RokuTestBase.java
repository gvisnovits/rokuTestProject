package testbase;

import config.Config;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class RokuTestBase {

	private static final File location = new File(String.format(Config.LOCAL_USER_DIR + "/src"));
	private static final String command = "go run .";
	private static Process process;
	private static ProcessBuilder builder = new ProcessBuilder();

	@BeforeClass(alwaysRun = true)
	public void setupWebServer() {
		builder.directory(location);
		builder.command("sh", "-c", command);
		try {
			process = builder.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		builder.directory(location);

		System.out.println("Running in: " + location);
		System.out.println("Command: " + command);
		builder.directory(location);

		OutputStream outputStream = process.getOutputStream();
		InputStream inputStream = process.getInputStream();
		InputStream errorStream = process.getErrorStream();

		try {
			printStream(inputStream);
			printStream(errorStream);
			boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
			outputStream.flush();
			outputStream.close();
			if(!isFinished) {
				closeServer(process);
			}
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeServer(process);
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
