package ServerRequests;

public enum ResponseCode {

	SUCCESS(0, "Success", "The command executed successfully."),
	NO_SUCH_DRIVER(6, "No Such Driver", "A session is either terminated or not started"),
	NO_SUCH_ELEMENT(7, "No Such Element", "An element could not be located on the page using the given search parameters."),
	UNKNOWN_COMMAND(9, "Unknown Command", "The requested resource could not be found, or a request was received using an HTTP method that is not supported by the mapped resource."),
	UNKNOWN_ERROR(13, "Unknown Error", "An unknown server-side error occurred while processing the command."),
	TIMEOUT(21, "Timeout", "An operation did not complete before its timeout expired."),
	INVALID_SELECTOR(32, "Invalid Selector", "Argument was an invalid selector."),
	SESSION_NOT_CREATED_EXCEPTION(33, "Session Not Created Exception", "A new session could not be created.");

	private final int code;
	private final String summary;
	private final String detail;

	ResponseCode(int code, String summary, String detail) {
		this.code = code;
		this.summary = summary;
		this.detail = detail;
	}

	public int getCode() {
		return code;
	}

	public String getSummary() {
		return summary;
	}

	public String getDetail() {
		return detail;
	}
}
