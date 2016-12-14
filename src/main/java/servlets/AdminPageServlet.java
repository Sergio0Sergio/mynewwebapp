package servlets;

import accountServer.AccountServer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sg on 14.12.2016.
 */
public class AdminPageServlet extends HttpServlet {
    //static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    public static final String PAGE_URL = "/admin";
    private final AccountServer accountServer;
    public AdminPageServlet(AccountServer accountServer){

        this.accountServer = accountServer;
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html;charset-utf8");
        response.getWriter().println(accountServer.getUsersLimit());
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
