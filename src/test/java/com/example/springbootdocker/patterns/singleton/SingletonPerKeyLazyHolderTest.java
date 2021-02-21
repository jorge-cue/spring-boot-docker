package com.example.springbootdocker.patterns.singleton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;


/*
 * Created by jhcue on 19/02/2021
 */
class SingletonPerKeyLazyHolderTest {

    /**
     * Validates that factory method returns same object for equal keys and retrieves different objects for
     * non equal keys.
     *
     * @param name Name of test to perform
     * @param key1 Key for first SingletonPerKey to retrieve
     * @param key2 Key for second SingletonPerKey to retrieve
     */
    @ParameterizedTest(name = "{index}: {0} using parameter1 {1} parameter2 {2}")
    @CsvSource({
            "Must be same, one, one",
            "Must not be same, two, three"
    })
    void getParameter(String name, String key1, String key2) {
        Objects.requireNonNull(key1);
        Objects.requireNonNull(key2);

        boolean isSame = key1.equals(key2);

        final var instance1 = SingletonPerKeyLazyHolder.getInstance(key1);
        final var instance2 = SingletonPerKeyLazyHolder.getInstance(key2);

        assertEquals(key1, instance1.getKey(), "Must use parameter " + key1);
        assertEquals(key2, instance2.getKey(), "Must use parameter " + key2);
        if (isSame) {
            assertSame(instance1, instance2, "Must be same");
        } else {
            assertNotSame(instance1, instance2, "Must not be same");
        }
    }
}