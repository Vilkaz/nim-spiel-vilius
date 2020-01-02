package de.holisticon.nimgamevilius.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Gets the Strings from the language propperty file.
 * For Demo, hardcoded in english.
 */
@Component
public class Translator {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    Translator(ResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }

    /**
     * For production usage, we would change the hardcoded english
     * with LocaleSupplier.
     */
    public static String getText(String msg) {
        return messageSource.getMessage(msg, null, Locale.ENGLISH);
    }
}
