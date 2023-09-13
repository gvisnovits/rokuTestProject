package ServerRequests.JsonBodyRequests;

import ServerRequests.ElementUsingEnum;

public class ElementRequest {

	private ElementData elementData[];
	private ParentData parentData[];

	/**
	 * Postman get element by "text" locator
	 * "using": "text"
	 * "value": "Text String"
	 */
	public ElementRequest(ElementUsingEnum elementUsingEnum, String value) {
		this.elementData = new ElementData[]{new ElementData(elementUsingEnum, value)};
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

		public ElementData(ElementUsingEnum elementUsingEnum, String value) {
			this.using = elementUsingEnum.getUsing();
			this.value = value;
		}

	}

	private class ParentData {
		private String using;
		private String value;
		private String attribute;
	}
}
