package de.holisticon.nimgamevilius.propertyloaders;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PropertyLoaderTest {

    @Test
    void readsFromFile() {
        String value = ApplicationProperties
                .getInstance()
                .getProperty("test.intValue");
        Assertions.assertThat(value).isEqualTo("1337");
    }
}
