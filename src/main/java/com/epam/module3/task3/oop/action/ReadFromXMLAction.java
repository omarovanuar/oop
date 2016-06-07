package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.interfacee.ReadInterface;
import com.epam.module3.task3.oop.parser.ElectronicsSAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromXMLAction implements ReadInterface {
    private int id;
    private List<Electronics> list = new ArrayList<>();

    @Override
    public void read() {
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        ElectronicsSAXParser handler;
        try {
            sp = spfac.newSAXParser();
            handler = new ElectronicsSAXParser();
            sp.parse(new File("electronics.xml"), handler);
            id = handler.getId();
            list = handler.getList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Electronics> getList() {
        return list;
    }
}
