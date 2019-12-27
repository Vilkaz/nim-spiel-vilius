package de.holisticon.nimgamevilius.spring;

import de.holisticon.nimgamevilius.service.GameService;
import de.holisticon.nimgamevilius.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfigurations {


    @Primary
    @Bean(name = "GameService")
    GameService gameService() {
        return new GameServiceImpl();
    }

}
