package de.holisticon.nimgamevilius.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath*:application.properties")
public class PropertiesConfiguration {
}
