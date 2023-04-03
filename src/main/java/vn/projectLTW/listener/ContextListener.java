package vn.projectLTW.listener;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.util.Properties;


@WebListener("application context listener")
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        //Initialized log4j
        ServletContext context=event.getServletContext();
        String log4jConfigFile=context.getInitParameter("log4j-config-location");
        String fullPath=context.getRealPath("/")+ File.separator+log4jConfigFile;

        System.out.println(fullPath);
        PropertyConfigurator.configure(fullPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }


}
