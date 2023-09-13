package debug;

import helper.JsonToXmlHelper;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XmlDebugging {

	public static void main(String[] args) throws XPathExpressionException {
		// json String is json response from an API call
		String json = "";
		String xmlReturn = JsonToXmlHelper.convertJsonToXml(json);
		System.out.println(xmlReturn);
		returnString(xmlReturn);
		booleanTest(xmlReturn);

	}

	private static String returnString(String xmlReturn) throws XPathExpressionException {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		InputSource source = new InputSource(new StringReader(xmlReturn));
		return xpath.evaluate("//Value[contains(string(), 'Hello World!')]", source);
	}

	private static boolean booleanTest(String xmlReturn) throws XPathExpressionException {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		InputSource source = new InputSource(new StringReader(xmlReturn));
		return (Boolean) xpath.compile("//Value[contains(string(), 'Hellfo World!')]")
				.evaluate(source, XPathConstants.BOOLEAN);

	}
}
