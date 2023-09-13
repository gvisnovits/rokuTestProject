package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextUtility {

	public static String getTimestamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd_HH-mm-ss");
		return sdf.format(date);
	}
}
