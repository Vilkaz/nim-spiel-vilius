package nimgame.common;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Gets the Strings from the language propperty file.
 * For Demo, the locale is  hardcoded in english.
 */
public class Translator {

    private Translator() {
        // no initialisation
    }

    /**
     * For production usage, we would change the hardcoded english
     * with LocaleSupplier.
     */
    private static ResourceBundle messageSource = ResourceBundle.getBundle("messages", Locale.ENGLISH);


    /**
     * For Demo, i did this method static, to let it be used also outside of Spring components.
     */
    public static String getText(String msg) {
        return messageSource.getString(msg);
    }
}
