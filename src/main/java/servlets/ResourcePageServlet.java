package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.*;
//import resources.TestResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sgrimanov on 27.12.2016.
 */
public class ResourcePageServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private String xmlFile;
    private TestResource testResource;
    private ResourceServer resourceServer;

    public ResourcePageServlet (ResourceServer resourceServer){this.resourceServer = resourceServer;}

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html:charset=utf-8");
        xmlFile = request.getParameter("path");
        if (xmlFile != null){
            testResource = (TestResource)new ReadXMLFilesSax().readXML(xmlFile);
            logger.info("resource created");
            System.out.println("testResource = "+testResource.toString());
            resourceServer.setResource(testResource);

            response.getWriter().println("All is ok!");
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            response.getWriter().println("There's aint no filename!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
