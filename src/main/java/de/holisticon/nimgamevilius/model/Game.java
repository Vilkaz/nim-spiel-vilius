package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.common.Translator;


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

    void calculatePlayersTurn(PlayersMove playersMove) {
//        List<Function<Integer, String>> validators =
//                List.of(
//                        i -> i > matchesInStack ?
//                                Translator.getText("validation.took-too-manny-matches")
//                                : "",
//                        i ->  i < 1 || i > 3 ?
//                                Translator.getText("validation.min-max-amount")
//                                : ""
//                );
//        Integer reduceMatchesBy = playersMove.getMatchesToTake();
//        message = "";
//        message = validators.stream()
//                .map(v -> v.apply(reduceMatchesBy))
//                .filter(m -> !Strings.isNullOrEmpty(m))
//                .collect(Collectors.joining());

//        if (message.isEmpty()) {
            matchesInStack -= playersMove.getMatchesToTake();
            makeMove();
//        }

    }
}
