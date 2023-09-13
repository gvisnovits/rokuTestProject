package utilities;

public class WaiterUtility {
	public static void pauseFor(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
