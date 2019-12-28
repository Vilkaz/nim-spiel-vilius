package de.holisticon.nimgamevilius.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PlayersMove  {

    @NotNull(message = "Please enter how manny matches you took. Keyword = 'matchesToTake' values = 1,2,3")
    @Min(message = "Has to be atleast 1", value = 1L)
    @Max(message = "Can be maximal 3", value = 3L)
    private Integer matchesToTake;

    public Integer getMatchesToTake() {
        return matchesToTake;
    }

    public void setMatchesToTake(Integer matchesToTake) {
        this.matchesToTake = matchesToTake;
    }
}
