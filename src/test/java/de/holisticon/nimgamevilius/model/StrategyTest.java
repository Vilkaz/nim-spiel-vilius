package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyTest {


    @Test
    void randomWithMoreThan3Matches() {
        IntStream.range(4, 14)
                .forEach(i ->
                        assertThat(Strategy.RANDOM.calculateMatchesToTake(i))
                                .isBetween(1, 3)
                );
    }

    @Test
    void calculateMaxFor3AndLower() {
        IntStream.range(3, 1)
                .forEach(i ->
                        assertThat(Strategy.calculateMax(i))
                                .isEqualTo(i)
                );
    }

    @Test
    void calculateMaxForGreaterThan3() {
        int max = Strategy.calculateMax(1);
        assertThat(max).isEqualTo(1);
    }

    @Test
    void winningStrat() {
        assertThat(calculateWinStrategy(1)).isEqualTo(1); //Loss
        assertThat(calculateWinStrategy(2)).isEqualTo(1); //Winn
        assertThat(calculateWinStrategy(3)).isEqualTo(2); //Winn
        assertThat(calculateWinStrategy(4)).isEqualTo(3); //Winn
        assertThat(calculateWinStrategy(5)).isEqualTo(1); //Loss
        assertThat(calculateWinStrategy(6)).isEqualTo(1); //Winn
        assertThat(calculateWinStrategy(7)).isEqualTo(2); //Winn
        assertThat(calculateWinStrategy(8)).isEqualTo(3); //Winn
        assertThat(calculateWinStrategy(9)).isEqualTo(1); //Loss
        assertThat(calculateWinStrategy(10)).isEqualTo(1); //Winn
        assertThat(calculateWinStrategy(11)).isEqualTo(2); //Winn
        assertThat(calculateWinStrategy(12)).isEqualTo(3); //Winn
        assertThat(calculateWinStrategy(13)).isEqualTo(1); //Loss
    }

    private Integer calculateWinStrategy(Integer amount) {
        return Strategy.WIN.calculateMatchesToTake(amount);
    }

    @Test
    void reduceAmount() {
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(1)).isEqualTo(1);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(2)).isEqualTo(2);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(3)).isEqualTo(3);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(4)).isEqualTo(4);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(5)).isEqualTo(1);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(6)).isEqualTo(2);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(7)).isEqualTo(3);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(8)).isEqualTo(4);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(9)).isEqualTo(1);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(10)).isEqualTo(2);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(11)).isEqualTo(3);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(12)).isEqualTo(4);
        assertThat(Strategy.reduceAmountBy4UntilSmallerThan5(13)).isEqualTo(1);
    }

}
