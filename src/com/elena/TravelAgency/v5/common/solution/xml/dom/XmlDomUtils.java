package com.elena.TravelAgency.v5.common.solution.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public final class XmlDomUtils {
    private XmlDomUtils() {
    }

    public static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        return documentBuilder.parse(new File(fileName));
    }

    public static Element getSingleElementByTagName(Document document, String tagName) {
        return (Element) document.getElementsByTagName(tagName).item(0);
    }

    public static String getSingleElementTextContent(Element source, String tagName) {
        return source.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
