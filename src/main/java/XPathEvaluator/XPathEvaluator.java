package XPathEvaluator;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XPathEvaluator {

    public static String xPathEvaluator(String xml, String xpathExpression) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        InputSource source = new InputSource(new StringReader(xml));
        return xpath.evaluate(xpathExpression, source);
    }

    public static Boolean isDisplayed(String xml, String xpathExpression) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        InputSource source = new InputSource(new StringReader(xml));
        Boolean evaluation = (Boolean) xpath.compile(xpathExpression)
                .evaluate(source, XPathConstants.BOOLEAN);
        return evaluation;
    }

}
