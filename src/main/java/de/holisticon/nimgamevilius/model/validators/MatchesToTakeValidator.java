package de.holisticon.nimgamevilius.model.validators;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameHandler;
import de.holisticon.nimgamevilius.model.MatchesToTake;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchesToTakeValidator implements ConstraintValidator<MatchesToTake, String> {
   public void initialize(MatchesToTake constraint) {
   }

   public boolean isValid(String amountString, ConstraintValidatorContext context) {
      int matchesToTake = Integer.parseInt(amountString);
      Game currentRunningGame = GameHandler.status();
      return matchesToTake <= currentRunningGame.getMatchesInStack();
   }


}
