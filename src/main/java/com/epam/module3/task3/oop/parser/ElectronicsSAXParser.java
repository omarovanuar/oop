package com.epam.module3.task3.oop.parser;

import com.epam.module3.task3.oop.action.CreateListFromArrayAction;
import com.epam.module3.task3.oop.entity.Electronics;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsSAXParser extends DefaultHandler {
    private int id;
    private List<Electronics> list = new ArrayList<>();
    private String[] electronic = new String[7];
    private StringBuilder thisElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with electronics...");
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        thisElement = new StringBuilder();
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if (qName.equals("electronic")) {
            list = CreateListFromArrayAction.create(electronic);
        } else {
            String elementVal = thisElement.toString();
            if (qName.equals("id")) {
                id = Integer.parseInt(elementVal);
                electronic[0] = elementVal;
            } else if (qName.equals("type")) {
                electronic[1] = elementVal;
            } else if (qName.equals("title")) {
                electronic[2] = elementVal;
            } else if (qName.equals("price")) {
                electronic[3] = elementVal;
            } else if (qName.equals("consumption")) {
                electronic[4] = elementVal;
            } else if (qName.equals("batteryn")) {
                electronic[5] = elementVal;
            } else if (qName.equals("isplugged")) {
                electronic[6] = elementVal;
            }
        }
        thisElement = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML document with electronics...");
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        thisElement.append(ch, start, length);
    }

    public int getId() {
        return id;
    }

    public List<Electronics> getList() {
        return list;
    }
}
