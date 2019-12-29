package de.holisticon.nimgamevilius.model.validators;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameHandler;
import de.holisticon.nimgamevilius.model.MatchesToTake;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchesToTakeValidator implements ConstraintValidator<MatchesToTake, Integer> {

   public boolean isValid(Integer matchesToTake, ConstraintValidatorContext context) {
      Game currentRunningGame = GameHandler.status();
      return currentRunningGame != null &&
              matchesToTake <= GameHandler.status().getMatchesInStack();
   }


}
