package nimgame.configuration;

import nimgame.repository.GameRepository;
import nimgame.repository.GameRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Configurations {


    private static final String CONTROLLER_PACKAGE = "de.holisticon.nimgamevilius.controller";

//    @Primary
//    @Bean(name = "GameService")
//    GameService gameService() {
//        return new GameServiceImpl(gameRepository());
//    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    @Primary
    @Bean
    GameRepository gameRepository() {
        return new GameRepositoryImpl();
    }

}
