package serverrequests.jsonbodyrequests;

import serverrequests.LocatorStrategy;

public class ElementRequest {

	private ElementData elementData[];
	private ParentData parentData[];

	/**
	 * Postman get element by "text" locator
	 * "using": "text"
	 * "value": "Text String"
	 */
	public ElementRequest(LocatorStrategy locatorStrategy, String value) {
		this.elementData = new ElementData[]{new ElementData(locatorStrategy, value)};
	}

	private class ElementData {
		private String using;
		private String value;
		private String attribute;

		public String getUsing() {
			return using;
		}

		public String getValue() {
			return value;
		}

		public String getAttribute() {
			return attribute;
		}

		public ElementData(LocatorStrategy locatorStrategy, String value) {
			this.using = locatorStrategy.getUsing();
			this.value = value;
		}

	}

	private class ParentData {
		private String using;
		private String value;
		private String attribute;
	}
}
