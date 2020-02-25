package nimgame.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * After the game has started, the player has to give us amount of taken matches.
 *
 * Here mostly are validations for that move.
 */
public class PlayersMove  {

    @NotNull(message = "Please enter how manny matches you took. Keyword = 'matchesToTake' values = 1,2,3")
    @Min(message = "You have to take atleast 1 match", value = 1L)
    @Max(message = "You can maximal take 3 matches", value = 3L)
    @MatchesToTake
    private Integer matchesToTake;

    public Integer getMatchesToTake() {
        return matchesToTake;
    }

    public void setMatchesToTake(Integer matchesToTake) {
        this.matchesToTake = matchesToTake;
    }
}
