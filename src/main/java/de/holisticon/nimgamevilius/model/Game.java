package de.holisticon.nimgamevilius.model;

import com.google.common.base.Strings;
import de.holisticon.nimgamevilius.common.Translator;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Game {
    private int matchesInStack;
    private String message;
    private Strategy strategy;

    Game() {
        // package private
    }

    public int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }

    void makeMove() {
        if (matchesInStack == 0) {
            message = Translator.getText("game.computer-wins");
        } else {
            Integer matchesToTake = strategy.calculateMatchesToTake(matchesInStack);
            matchesInStack -= matchesToTake;
            message = Translator.getText("game.took-amount-of-matches") + matchesToTake;
            if (matchesInStack == 0) {
                message +=  Translator.getText("game.player-wins");
            }
        }
    }

    public Strategy getStrategy() {
        return strategy;
    }

    void setMatchesInStack(int matchesInStack) {
        this.matchesInStack = matchesInStack;
    }

    void setMessage(String message) {
        this.message = message;
    }

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void calculatePlayersTurn(int reduceMatchesBy) {
        List<Function<Integer, String>> validators =
                List.of(
                        i -> i > matchesInStack ?
                                Translator.getText("validation.took-too-manny-matches")
                                : "",
                        i ->  i < 1 || i > 3 ?
                                Translator.getText("validation.min-max-amount")
                                : ""
                );

        message = "";
        message = validators.stream()
                .map(v -> v.apply(reduceMatchesBy))
                .filter(m -> !Strings.isNullOrEmpty(m))
                .collect(Collectors.joining());

        if (message.isEmpty()) {
            matchesInStack -= reduceMatchesBy;
            makeMove();
        }

    }
}
