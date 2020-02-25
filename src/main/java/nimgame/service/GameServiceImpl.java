package nimgame.service;

import nimgame.common.Translator;
import nimgame.model.*;
import nimgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Value("${game.amountOfStartingMatches}")
    private Integer startingMatchesAmount;

    private GameRepository repository;

    @Autowired
    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public Game startNewGame(GameStarter gameStarter) {
        Settings settings= new Settings(gameStarter, startingMatchesAmount);
        settings.setStartingMatchesAmount(startingMatchesAmount);

       Game   game = GameBuilder.aGame()
                    .withFirstTurn(settings.getFirstTurn())
                    .withMatchesInStack(settings.getStartingMatchesAmount())
                    .withStrategy(settings.getStrategy())
                    .withMessage(Translator.getText("game.new-game-started"))
                    .build();

        return repository.saveGame(game);
    }

    @Override
    public Game play(PlayersMove playersMove) {
        Game game = repository.loadGame();
        game.handlePlayersTurn(playersMove.getMatchesToTake());
        return repository.saveGame(game);
    }

    @Override
    public Game loadGame() {
        return repository.loadGame();
    }

    @Override
    public Game saveGame(Game game) {
        return repository.saveGame(game);
    }


}
