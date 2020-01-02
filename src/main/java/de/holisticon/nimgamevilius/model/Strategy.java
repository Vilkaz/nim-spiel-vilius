package de.holisticon.nimgamevilius.model;


import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;

/**
 * Depending on Strategy, the program will try to win or just use random numbers.
 */
public enum Strategy {
    RANDOM(Strategy::calculateRandomAmount),
    WIN(Strategy::calculateWinningAmount);


    private static Integer calculateRandomAmount(Integer amountOfMatches) {
        int max = calculateMax(amountOfMatches);
        return ThreadLocalRandom.current().nextInt(1, max + 1);
    }

    /**
     * The rules are :
     * Every player has to take 1-3 matches
     * who ever takes the last match loses.
     * So we try to leave opponent with 1 Match.
     * If we can't move opponent in losing position, we try to drag game out
     * by taking the minimum amount.
     * Here is the Table
     * Amount of matches : matches to take - Potential outcome
     * 1 : 1 - Loss
     * 2 : 1 - Win
     * 3 : 2 - Win
     * 4 : 3 - Win
     * 5 : 1 - no guaranteed win
     * 6 : 1 - Win
     * 7 : 2 - Win
     * 8 : 3 - Win
     * 9 : 1 - no guaranteed win
     * 10: 1 - Win
     * 11: 2 - Win
     * 12: 3 - Win
     * 13: 1 - no guaranteed win
     * <p>
     * As you see, the core logic is in the first 4 Positions and simply repeating itself.
     * <p>
     * This is what we will implement. Reduce number to the first 4 positions and
     * then follow the logic in table above.
     *
     * @param amountOfMatches in the Game
     * @return Amount of matches to take for best possible outcome
     */
    private static Integer calculateWinningAmount(Integer amountOfMatches) {
        int amount = reduceAmountBy4UntilSmallerThan5(amountOfMatches);
        if (amount > 1) {
            amount--;
        }
        return amount;
    }

    /**
     * Package open for tests
     *
     * @param amountOfMatches initial amount
     * @return reduced amount
     */
    static int reduceAmountBy4UntilSmallerThan5(Integer amountOfMatches) {
        while (amountOfMatches > 4) {
            amountOfMatches -= 4;
        }
        return amountOfMatches;
    }

    static int calculateMax(Integer amountOfMatches) {
        return amountOfMatches < 3 ? amountOfMatches : 3;
    }

    private IntFunction<Integer> move;

    Strategy(IntFunction<Integer> move) {
        this.move = move;
    }


    public Integer calculateMatchesToTake(Integer amountOfMatches) {
        return move.apply(amountOfMatches);
    }}

