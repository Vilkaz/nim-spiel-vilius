package nimgame.model.validators;

import nimgame.model.Game;
import nimgame.model.MatchesToTake;
import nimgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validation that the player is not taking more matches that there are in game.
 */
@Component
public class MatchesToTakeValidator implements ConstraintValidator<MatchesToTake, Integer> {

   private GameService service;

   @Autowired
   public MatchesToTakeValidator(GameService service) {
      this.service = service;
   }

   public boolean isValid(Integer matchesToTake, ConstraintValidatorContext context) {
      Game currentRunningGame = service.loadGame();
      return currentRunningGame != null &&
              matchesToTake <= service.loadGame().getMatchesInStack();
   }

}
