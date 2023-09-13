package debug;

import com.google.gson.Gson;
import serverrequests.LocatorStrategy;
import serverrequests.jsonbodyrequests.ElementRequest;
import serverrequests.jsonbodyresponse.CommonResponses;

public class SerializationDebugging {

	public static void main(String[] args) {
		serializeExample();
        deserializeExample();
	}

	/**
	 * serializeExample is a debugging tool that will convert a Java Object to a Json Object
	 * Create a JsonBodyRequest Object or use one of the few provided in ServerRequests package
	 */
	private static void serializeExample() {
		ElementRequest elementRequest = new ElementRequest(LocatorStrategy.TEXT, "Hello World!");
		Gson gson = new Gson();
		gson.toJson(elementRequest);
		String json = gson.toJson(elementRequest);
		System.out.println(json);
	}

	/**
	 * deserializeExample is a debugging tool that will convert a Json object into a Java Object
	 */
	private static void deserializeExample() {
		String returnStatement = "";
		Gson gson = new Gson();
		CommonResponses commonResponses = gson.fromJson(returnStatement, CommonResponses.class);
	}
}
