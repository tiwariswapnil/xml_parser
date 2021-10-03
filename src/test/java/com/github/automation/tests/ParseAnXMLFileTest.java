package com.github.automation.tests;

import com.github.automation.essentials.XMLParser;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParseAnXMLFileTest {

    @Test
    public void parseXmlFile() throws ParserConfigurationException, SAXException, IOException {
        XMLParser xmlParser = new XMLParser();
        xmlParser.printXMLElements();
    }
}
