package readers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class LocatorReader {
    private final Document doc;

    public LocatorReader(String xmlPath) {
        try {
            File file = new File(xmlPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load locator XML: " + xmlPath, e);
        }
    }

    public String getLocator(String xpath) {
        try {
            Node node = (Node) XPathFactory
                    .newInstance()
                    .newXPath()
                    .evaluate(xpath, doc, XPathConstants.NODE);

            if (node == null) {
                throw new RuntimeException("No element found for xpath: " + xpath);
            }

            return node.getTextContent().trim();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get locator from XML path: " + xpath, e);
        }
    }
}
