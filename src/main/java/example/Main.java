package example;

import accountServer.AccountServer;
import accountServer.AccountServerController;
import accountServer.AccountServerControllerMBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resources.*;
import servlets.AdminPageServlet;
import servlets.HomePageServlet;
import servlets.ResourcePageServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by sgrimanov on 06.12.2016.
 */
public class Main {

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

//        if (args.length != 1){
//            logger.error("Use port as the first argument");
//            System.exit(1);
//        }

        String portString = "8080";//args[0];
        int port = Integer.valueOf(portString);

        logger.info("Starting at http:/127.0.0.1:" + portString);

        AccountServer accountServer = new AccountServer();
        ResourceServer resourceServer = new ResourceServer();

        AccountServerControllerMBean serverStatistics = new AccountServerController(accountServer);
        ResourceServerControllerMBean serverStatistics1 = new ResourceServerController(resourceServer);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=AccountServerController");
        ObjectName resource = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);
        mbs.registerMBean(serverStatistics1, resource);

        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new HomePageServlet(accountServer)), HomePageServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new AdminPageServlet(accountServer)), AdminPageServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new ResourcePageServlet(resourceServer)), ResourcePageServlet.PAGE_URL);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        server.start();
        logger.info("Server started");

    }
}
