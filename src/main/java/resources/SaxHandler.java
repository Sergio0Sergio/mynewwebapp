package resources;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import reflection.ReflectionHelper;

/**
 * Created by sgrimanov on 27.12.2016.
 */
@SuppressWarnings("UnusedDeclaration")
public class SaxHandler extends DefaultHandler{
    private static final String CLASSNAME = "class";
    private String element = null;
    private Object object = null;

    public void startDocument() throws SAXException{
        System.out.println("Start document");
    }

    public void endDocument() throws SAXException{
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes){

        if(!CLASSNAME.equals(qName)){

            element = qName;
        }
        else {

            String className = attributes.getValue(0);
            System.out.println("Class name "+className);
            object = ReflectionHelper.createInstance(className);

        }

    }

    public void endElement (String uri, String localName, String qName){element = null;}

    public void characters(char ch[], int start, int length) throws SAXException{

    }

    public Object getObject(){
        return object;
    }
}
