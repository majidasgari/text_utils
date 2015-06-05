package ir.ac.iust.text.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import java.io.File;
import java.io.IOException;

/**
 * Created by majid on 12/20/14.
 */
public class LoggerUtils {

    private static boolean initiated = false;

    public static void initLogger(String filename) {
        try {
//            PatternLayout LOG_PATTERN = new PatternLayout("%5p %d{HH:mm:ss} - %m%n");
            PatternLayout LOG_PATTERN = new PatternLayout("%m%n");
            Logger.getRootLogger().getAppender("stdout").setLayout(LOG_PATTERN);

            //add file appender
            String filePath = System.getProperty("user.dir") + File.separator + filename;
            RollingFileAppender appender = new RollingFileAppender(LOG_PATTERN, filePath);
            appender.setName("Fast DP Log");
            appender.setMaxFileSize("10MB");
            appender.activateOptions();
            Logger.getRootLogger().addAppender(appender);
            Logger.getRootLogger().setLevel(Level.INFO);
            initiated = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger(Class clazz, String filename) {
        if (!initiated) initLogger(filename);
        return Logger.getLogger(clazz);
    }
}
