package HelpfulDebugging;

import helper.JsonToXmlHelper;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XmlTests {

    public static void main(String[] args) throws XPathExpressionException {
        String returnStatement = "{\n" +
                "    \"sessionId\": \"7d55462b-6106-54a1-9135-615803b0cda2\",\n" +
                "    \"status\": 0,\n" +
                "    \"value\": {\n" +
                "        \"XMLName\": {\n" +
                "            \"Space\": \"\",\n" +
                "            \"Local\": \"HelloWorld\"\n" +
                "        },\n" +
                "        \"Attrs\": [\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"bounds\"\n" +
                "                },\n" +
                "                \"Value\": \"{0, 0, 1920, 1080}\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"children\"\n" +
                "                },\n" +
                "                \"Value\": \"0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"extends\"\n" +
                "                },\n" +
                "                \"Value\": \"Scene\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"focusable\"\n" +
                "                },\n" +
                "                \"Value\": \"true\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"focused\"\n" +
                "                },\n" +
                "                \"Value\": \"true\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Name\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"rcid\"\n" +
                "                },\n" +
                "                \"Value\": \"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Nodes\": [\n" +
                "            {\n" +
                "                \"XMLName\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"Poster\"\n" +
                "                },\n" +
                "                \"Attrs\": [\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"bounds\"\n" +
                "                        },\n" +
                "                        \"Value\": \"{0, 0, 1920, 1080}\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"index\"\n" +
                "                        },\n" +
                "                        \"Value\": \"0\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"inheritParentOpacity\"\n" +
                "                        },\n" +
                "                        \"Value\": \"false\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"inheritParentTransform\"\n" +
                "                        },\n" +
                "                        \"Value\": \"false\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"loadStatus\"\n" +
                "                        },\n" +
                "                        \"Value\": \"3\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"rcid\"\n" +
                "                        },\n" +
                "                        \"Value\": \"0\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"uri\"\n" +
                "                        },\n" +
                "                        \"Value\": \"/RokuOS/Artwork/SceneGraph/GenevaTheme/Base/FHD/background.png\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Nodes\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"XMLName\": {\n" +
                "                    \"Space\": \"\",\n" +
                "                    \"Local\": \"Label\"\n" +
                "                },\n" +
                "                \"Attrs\": [\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"bounds\"\n" +
                "                        },\n" +
                "                        \"Value\": \"{0, 0, 1280, 720}\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"color\"\n" +
                "                        },\n" +
                "                        \"Value\": \"#72d7eeff\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"index\"\n" +
                "                        },\n" +
                "                        \"Value\": \"0\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"name\"\n" +
                "                        },\n" +
                "                        \"Value\": \"myLabel\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"rcid\"\n" +
                "                        },\n" +
                "                        \"Value\": \"0\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Name\": {\n" +
                "                            \"Space\": \"\",\n" +
                "                            \"Local\": \"text\"\n" +
                "                        },\n" +
                "                        \"Value\": \"Hello World!\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Nodes\": null\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        String xmlReturn = JsonToXmlHelper.convertJsonToXml(returnStatement);
        System.out.println(xmlReturn);
//        returnString(xmlReturn);
        booleanTest(xmlReturn);

    }

    private static String returnString(String xmlReturn) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        InputSource source = new InputSource(new StringReader(xmlReturn));
        String name = xpath.evaluate("//Value[contains(string(), 'Hello World!')]", source);
        return name;
    }

    private static void booleanTest(String xmlReturn) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        InputSource source = new InputSource(new StringReader(xmlReturn));
        Boolean evaluation = (Boolean) xpath.compile("//Value[contains(string(), 'Hellfo World!')]")
                .evaluate(source, XPathConstants.BOOLEAN);

    }
}
