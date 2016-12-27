package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    //private final TestResource testResource;

    public ResourcePageServlet (){}

    public void doPost (HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException{

        responce.setContentType("text/html:charset=utf-8");
        String resourcePath = request.getParameter("path_to_resource");
        if (resourcePath != null){

        }
    }

}
