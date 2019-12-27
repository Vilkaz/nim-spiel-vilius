package de.holisticon.nimgamevilius;

import de.holisticon.nimgamevilius.spring.BeanConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
public class NimSpielViliusApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimSpielViliusApplication.class, args);
	}

}
