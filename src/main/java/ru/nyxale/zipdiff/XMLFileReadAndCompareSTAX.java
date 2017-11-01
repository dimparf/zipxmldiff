package ru.nyxale.zipdiff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLFileReadAndCompareSTAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        SAXHandler handler1 = new SAXHandler();
        SAXHandler handler2 = new SAXHandler();
        parser.parse(new File("oldFile/4.xml"), handler1);
        parser.parse(new File("newFile/4.xml"), handler2);
        List<Doc> finalList = new ArrayList<>();
        // Print first xml for verification
        for (Doc doc1 : handler1.docsList) {
            System.out.println(doc1);
        }
        // Print second xml for verification
        for (Doc doc1 : handler2.docsList) {
            System.out.println(doc1);
        }

        for (Doc doc1 : handler1.docsList) {
            for (Doc doc2 : handler2.docsList) {
                if (doc1.id.equals(doc2.id)) {
                    Doc newDoc = new Doc();
                    newDoc.id = doc1.id;
                    newDoc.name = (doc1.name != null) ? (doc1.name) : (doc2.name);
                    newDoc.brand = (doc1.brand != null) ? (doc1.brand) : (doc2.brand);
                    newDoc.stock = (doc1.stock != null) ? (doc1.stock) : (doc2.stock);
                    finalList.add(newDoc);
                }
            }
        }

        //Now print final xml.
        for (Doc doc : finalList) {
            System.out.println(doc);
        }

    }
}