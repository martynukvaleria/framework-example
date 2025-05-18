package config;

import org.openqa.selenium.By;
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

    public By getLocator(String xpath) {
        try {
            Node node = (Node) XPathFactory
                    .newInstance()
                    .newXPath()
                    .evaluate(xpath, doc, XPathConstants.NODE);

            if (node == null) {
                throw new RuntimeException("No element found for xpath: " + xpath);
            }

            String locatorValue = node.getTextContent().trim();
            return By.xpath(locatorValue);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get locator from XML path: " + xpath, e);
        }
    }
}
