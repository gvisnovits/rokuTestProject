package serverrequests.jsonbodyresponse;

public class ElementResponse extends CommonResponses {
	private Value value;

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
