package ServerRequests.JsonBodyResponse;

public class ElementResponse {
	private String sessionId;
	private int status;
	private Value value;

	public String getSessionId() {
		return sessionId;
	}

	public int getStatus() {
		return status;
	}

	public Value getValue() {
		return value;
	}

	private class Value {
		private XMLName XMLName;
		private Attrs Attrs[];
		private Nodes Nodes[];
	}

	private class XMLName {
		private String Space;
		private String Local;
	}

	private class Attrs {
		private Name Name;
		private String Value;
	}

	private class Nodes {
		private XMLName XMLName;
		private Attrs Attrs[];
	}

	private class Name {
		private String Space;
		private String Local;
	}

}
