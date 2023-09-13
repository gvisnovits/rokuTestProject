package xpathevaluator;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XPathEvaluator {

	public static String getText(String xml, String xpathExpression) {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		InputSource source = new InputSource(new StringReader(xml));
		try {
			return xpath.evaluate(xpathExpression, source);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean isDisplayed(String xml, String xpathExpression) {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		InputSource source = new InputSource(new StringReader(xml));
		try {
			return (Boolean) xpath.compile(xpathExpression)
					.evaluate(source, XPathConstants.BOOLEAN);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}
	}

}
