package ServerRequests.JsonBodyResponse;

public class CreateSessionResponse {

	private String sessionId;
	private int status;
	Value value;

	public String getSessionId() {
		return sessionId;
	}

	private class Value {
		String ip;
		int timeout;
		int pressDelay;
		String vendorName;
		String modelName;
		String language;
		String country;
	}
}
