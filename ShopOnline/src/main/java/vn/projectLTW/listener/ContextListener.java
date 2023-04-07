//package vn.projectLTW.listener;
//
//
//
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.io.File;
//
//
//@WebListener("application context listener")
//public class ContextListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent event) {
//        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
//        //Initialized log4j
//        ServletContext context=event.getServletContext();
//        String log4jConfigFile=context.getInitParameter("log4j-config-location");
//        String fullPath=context.getRealPath("/")+ File.separator+log4jConfigFile;
//
//        System.setProperty("PATH",context.getRealPath("/"));
//        System.out.println(fullPath);
//        PropertyConfigurator.configure(fullPath);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
//    }
//
//
//}
