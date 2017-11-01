package ru.nyxale.zipdiff;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {
    List<Doc> docsList = new ArrayList<>();
    Doc doc = null;
    String content = null;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
        throws SAXException {

        switch(qName){
            //Create a new Doc object when the start tag is found
            case "doc":
                doc = new Doc();
                doc.id = attributes.getValue("id");
                doc.name = attributes.getValue("name");
                doc.brand = attributes.getValue("brand");
                doc.stock = attributes.getValue("stock");
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch(qName){
            case "doc":
                docsList.add(doc);
                break;
            case "id":
                doc.id = content;
                break;
            case "name":
                doc.name = content;
                break;
            case "brand":
                doc.brand = content;
                break;
            case "stock":
                doc.stock = content;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

}

class Doc {
    String id;
    String name;
    String brand;
    String stock;

    @Override
    public String toString() {
        return "Doc{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", brand='" + brand + '\'' +
            ", Stock='" + stock + '\'' +
            '}';
    }
}
