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

        if(!qName.equals(CLASSNAME)){

            element = qName;
            //System.out.println("reading element = " +qName);
        }
        else {


            String className = attributes.getValue(0);
            System.out.println("reading CLASSNAME = " +className);
            object = ReflectionHelper.createInstance(className);
            System.out.println("object was created = " +object.toString());

        }

    }

    public void endElement (String uri, String localName, String qName){element = null;}

    public void characters(char ch[], int start, int length) throws SAXException{
        if (element != null){
            String value = new String(ch, start, length);
            System.out.println(element + " = " + value);
            ReflectionHelper.setFieldValue(object, element, value);
        }
    }

    public Object getObject(){
        return object;
    }
}
