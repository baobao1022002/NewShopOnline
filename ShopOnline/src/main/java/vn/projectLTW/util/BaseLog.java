package vn.projectLTW.util;



import org.apache.log4j.PropertyConfigurator;

import java.util.logging.Logger;

public class BaseLog {
    public static Logger LOGGER=null;

    public static void loadLog4j(){
        String log4Jpath=System.getProperty("user.dir")+"/log4j.properties";
        PropertyConfigurator.configure(log4Jpath);

    }

}
