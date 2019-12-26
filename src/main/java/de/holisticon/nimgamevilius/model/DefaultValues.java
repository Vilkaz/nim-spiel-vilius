package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.propertyloaders.ApplicationProperties;

public enum DefaultValues {

    AMOUNT_OF_STARTING_MATCHES("game.amountOfStartingMatches");

    private String value;


    DefaultValues(String key) {
        this.value = ApplicationProperties.get(key);
    }

    public Integer getInteger() {
        return Integer.parseInt(value);
    }

}
