package com.github.automation.essentials;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLParser {

    //Create a Document from the xml file
    public Document readFile(String filePath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            throw new FileNotFoundException("File Does not exists");
        }

        Document doc = builder.parse(xmlFile);

        return doc;
    }

    public void printXMLElements() throws IOException, SAXException, ParserConfigurationException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/demo.xml";
        Document doc = readFile(filePath);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("student");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Student roll no : "
                        + eElement.getAttribute("rollno"));
                System.out.println("First Name : "
                        + eElement
                        .getElementsByTagName("firstname")
                        .item(0)
                        .getTextContent());
                System.out.println("Last Name : "
                        + eElement
                        .getElementsByTagName("lastname")
                        .item(0)
                        .getTextContent());
                System.out.println("Nick Name : "
                        + eElement
                        .getElementsByTagName("nickname")
                        .item(0)
                        .getTextContent());
                System.out.println("Marks : "
                        + eElement
                        .getElementsByTagName("marks")
                        .item(0)
                        .getTextContent());
            }
        }
    }

}
