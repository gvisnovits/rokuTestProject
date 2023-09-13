package serverrequests.jsonbodyresponse;

public class CreateSessionResponse extends CommonResponses {
	Value value;

	private static class Value {
		String ip;
		int timeout;
		int pressDelay;
		String vendorName;
		String modelName;
		String language;
		String country;
	}
}
