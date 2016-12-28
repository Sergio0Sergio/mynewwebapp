package resources;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by sgrimanov on 27.12.2016.
 */
public class ReadXMLFilesSax {

    public static Object readXML(String xmlFile){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFile, handler);
            return handler.getObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
