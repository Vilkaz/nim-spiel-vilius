package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.model.validators.MatchesToTakeValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = MatchesToTakeValidator.class)
@Documented
/**
 * Validation if the player took a valid amount of matches.
 *
 * We are already covering the min an max, but we must check if he is taking
 * more matches that are in game, and that is not a static value.
 *
 */
public @interface MatchesToTake {

    String message() default "You can't take more matches that are in game";

    Class<?>[] groups() default {};

    Class<? extends PlayersMove>[] payload() default {};

}
