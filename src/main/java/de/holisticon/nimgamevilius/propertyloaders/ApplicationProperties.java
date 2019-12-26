package de.holisticon.nimgamevilius.propertyloaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Loads the Values from app.properties file.
 *
 * Based on my experience, i know that not all Java developers know Spring Boot,
 * so i try to reduce usage of Spring to minimum.
 *
 * So im not using @Value in @Configuration but going mainly with default java syntax.
 *
 * We can discuss this in review.
 */
public class ApplicationProperties {

    private static Logger log = LoggerFactory.getLogger(ApplicationProperties.class);

    ApplicationProperties() {
        //no initialisation
    }

    private static Properties prop;

    private static Properties createProperties() {
        URL resource = Thread.currentThread()
                .getContextClassLoader()
                .getResource("app.properties");
        prop = new Properties();
        try {
            prop.load(new FileInputStream(resource.getFile()));
        } catch (IOException e) {
            log.error("error while reading from application Properties", e.getMessage());
        }
        return prop;
    }


    public static Properties getInstance(){
        if (prop == null) {
            prop = createProperties();
        }
        return prop;
    }

}
